package com.zc.biz.logistics.service;

import com.alibaba.fastjson.JSON;
import com.zc.biz.logistics.domain.consts.AbLocOrderStatusEnum;
import com.zc.biz.logistics.domain.dao.AbLocOrderOPLogDOMapper;
import com.zc.biz.logistics.domain.dao.AbnormalLocOrderDOMapper;
import com.zc.biz.logistics.domain.dataobject.AbLocOrderOPLogDO;
import com.zc.biz.logistics.domain.dataobject.AbnormalLocOrderDO;
import com.zc.biz.logistics.domain.dataobject.AbnormalLocOrderDOExample;
import com.zc.biz.logistics.service.param.AbnormalLocOrderCreateParam;
import com.zc.biz.logistics.service.param.AbnormalLocOrderUpdateParam;
import com.zc.dataobject.DataObjectUtil;
import com.zc.result.PagedResult;
import com.zc.utils.ListUtil;
import com.zc.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AbnormalLocOrderWriteServiceImpl implements AbnormalLocOrderWriteService {

    @Resource
    private AbnormalLocOrderDOMapper abnormalLocOrderDOMapper;

    @Resource
    private AbLocOrderOPLogDOMapper abLocOrderOPLogDOMapper;

    @Override
    public Long createOrder(AbnormalLocOrderCreateParam createParam) {
        if (createParam == null || StringUtils.isBlank(createParam.getOutBizType())
            ||StringUtils.isBlank(createParam.getOutBizOrderNO())
            || StringUtils.isBlank(createParam.getAbnormalType())) {
            throw new RuntimeException("ILLEGAL_PARAM");
        }

        // --- 一个外部订单号 只对应一个异常单，不能重复建
        boolean exist = isBizOrderNOExist(createParam);
        if (exist){
            throw new RuntimeException("ABNORMAL_LOC_ORDER_ALREADY_EXIST_FOR_THIS_ORDER_NO");
        }

        // 插入
        AbnormalLocOrderDO orderDO = new AbnormalLocOrderDO();

        orderDO.setReporter(createParam.getInputReporter());
        orderDO.setOutBizType(createParam.getOutBizType());
        orderDO.setOutBizOrderNo(createParam.getOutBizOrderNO());
        orderDO.setOutLocCompany(createParam.getOutLocCompany());
        orderDO.setOutLocOrderNo(createParam.getOutLocOrderNO());
        orderDO.setUrgencyLevel(createParam.getUrgencyLevel());
        orderDO.setAbnormalType(createParam.getAbnormalType());
        orderDO.setAbnormalInfo(createParam.getAbnormalInfo());
        orderDO.setConsumerReceiveInfo(createParam.getConsumerReceiveInfo());
        orderDO.setProcessor(createParam.getProcessor());
        orderDO.setProcessResult(createParam.getProcessResult());

        if (ListUtil.isNotBlank(createParam.getAttachFileUrl())){
            orderDO.setAttachFileUrls(createParam.getAttachFileUrl().stream().collect(Collectors.joining(",")));
        }
        orderDO.setMemo(createParam.getMemo());

        orderDO.setOrderStatus(AbLocOrderStatusEnum.WAIT_LOC_COMPANY_PROCESS.name());

        DataObjectUtil.beforeInsert(orderDO, createParam.getOperatorName());

        abnormalLocOrderDOMapper.insertSelective(orderDO);

        return orderDO.getId();
    }

    private boolean isBizOrderNOExist(AbnormalLocOrderCreateParam createParam) {

        AbnormalLocOrderDOExample example = new AbnormalLocOrderDOExample();

        example.createCriteria().andIsDeletedNotEqualTo("y")
            .andOutBizTypeEqualTo(createParam.getOutBizType())
            .andOutBizOrderNoEqualTo(createParam.getOutBizOrderNO());

        return  abnormalLocOrderDOMapper.countByExample(example) > 0;
    }

    @Override
    public boolean updateCreateOrder(AbnormalLocOrderUpdateParam updateParam) {
        if (NumberUtil.isNotPositive(updateParam.getId())){
            throw new IllegalArgumentException("ILLEGAL_PARAM");
        }

        // 先查出来老的 -- 新的对象中不为空则替换，为空则不做修改
        AbnormalLocOrderDO oldOrderDO = abnormalLocOrderDOMapper.selectByPrimaryKey(updateParam.getId());

        if (oldOrderDO == null || "y".equalsIgnoreCase(oldOrderDO.getIsDeleted())){
            throw new IllegalArgumentException("ILLEGAL_PARAM|RECORD_IS_NOT_EXIST");
        }

        if (StringUtils.isNotBlank(updateParam.getOutLocCompany())){
            oldOrderDO.setOutLocCompany(updateParam.getOutLocCompany());
        }

        if (StringUtils.isNotBlank(updateParam.getOutLocOrderNO())){
            oldOrderDO.setOutLocOrderNo(updateParam.getOutLocOrderNO());
        }

        if (StringUtils.isNotBlank(updateParam.getUrgencyLevel())){
            oldOrderDO.setUrgencyLevel(updateParam.getUrgencyLevel());
        }


        if (StringUtils.isNotBlank(updateParam.getConsumerReceiveInfo())){
            oldOrderDO.setConsumerReceiveInfo(updateParam.getConsumerReceiveInfo());
        }


        if (StringUtils.isNotBlank(updateParam.getInputReporter())){
            oldOrderDO.setReporter(updateParam.getInputReporter());
        }

        if (StringUtils.isNotBlank(updateParam.getAbnormalType())){
            oldOrderDO.setAbnormalType(updateParam.getAbnormalType());
        }

        if (StringUtils.isNotBlank(updateParam.getAbnormalInfo())){
            oldOrderDO.setAbnormalInfo(updateParam.getAbnormalInfo());
        }

        if (StringUtils.isNotBlank(updateParam.getProcessor())){
            oldOrderDO.setProcessor(updateParam.getProcessor());
        }

        if (StringUtils.isNotBlank(updateParam.getProcessResult())){
            oldOrderDO.setProcessResult(updateParam.getProcessResult());
        }

        if (ListUtil.isNotBlank(updateParam.getAttachFileUrl())){
            oldOrderDO.setAttachFileUrls(updateParam.getAttachFileUrl().stream().collect(Collectors.joining(",")));
        }

        if (StringUtils.isNotBlank(updateParam.getMemo())){
            oldOrderDO.setMemo(updateParam.getMemo());
        }

        // 更新状态记录日志，不更新则不记录
        if (StringUtils.isNotBlank(updateParam.getOrderStatus())
            && !updateParam.getOrderStatus().equalsIgnoreCase(oldOrderDO.getOrderStatus())){
            oldOrderDO.setOrderStatus(updateParam.getOrderStatus());
            createAbLocOrderOPLog(oldOrderDO, updateParam);
        }

        DataObjectUtil.beforeUpdate(oldOrderDO, updateParam.getCurrentUserName());

        return abnormalLocOrderDOMapper.updateByPrimaryKeySelective(oldOrderDO) > 0;
    }

    private void createAbLocOrderOPLog(AbnormalLocOrderDO oldOrderDO, AbnormalLocOrderUpdateParam updateParam) {

        AbLocOrderOPLogDO orderOPLogDO = new AbLocOrderOPLogDO();

        orderOPLogDO.setAbLocOrderId(oldOrderDO.getId());
        orderOPLogDO.setStatusBefore(oldOrderDO.getOrderStatus());
        orderOPLogDO.setStatusAfter(updateParam.getOrderStatus());
        orderOPLogDO.setUserId(updateParam.getCurrentUserId());
        orderOPLogDO.setUserName(updateParam.getCurrentUserName());

        DataObjectUtil.beforeInsert(orderOPLogDO, updateParam.getCurrentUserName());

        abLocOrderOPLogDOMapper.insertSelective(orderOPLogDO);
    }

    @Override
    public boolean deleteUpdateOrder(Long orderId, String operator) {

        if (NumberUtil.isNotPositive(orderId)){
            throw new IllegalArgumentException("ILLEGAL_PARAM");
        }

        AbnormalLocOrderDOExample example = new AbnormalLocOrderDOExample();

        example.createCriteria().andIsDeletedNotEqualTo("y").andIdEqualTo(orderId);

        AbnormalLocOrderDO record = new AbnormalLocOrderDO();

        record.setIsDeleted("y");

        DataObjectUtil.beforeDelete(record, operator);

        return abnormalLocOrderDOMapper.updateByExampleSelective(record, example) > 0;
    }
}
