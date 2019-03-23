package com.zc.biz.logistics.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zc.biz.logistics.domain.dao.AbnormalLocOrderDOMapper;
import com.zc.biz.logistics.domain.dataobject.AbnormalLocOrderDO;
import com.zc.biz.logistics.domain.dataobject.AbnormalLocOrderDOExample;
import com.zc.biz.logistics.domain.model.AbnormalLocOrder;
import com.zc.biz.logistics.service.param.AbnormalLocOrderQueryParam;
import com.zc.result.PagedResult;
import com.zc.utils.DateUtil;
import com.zc.utils.ListUtil;
import com.zc.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class AbnormalLocOrderReadServiceImpl implements AbnormalLocOrderReadService {

    @Resource
    private AbnormalLocOrderDOMapper abnormalLocOrderDOMapper;

    @Override
    public PagedResult<AbnormalLocOrder> pagedQuery(AbnormalLocOrderQueryParam queryParam) {

        AbnormalLocOrderDOExample example = buildQueryExample(queryParam);

        int currentPage = queryParam.getCurrentPage() < 1 ? 1 : queryParam.getCurrentPage();
        int pageSize = (queryParam.getPageSize() <= 1 || queryParam.getPageSize() >= 20) ? 20
            : queryParam.getPageSize();

        Page<AbnormalLocOrderDO> paged = PageHelper.startPage(currentPage, pageSize);

        List<AbnormalLocOrderDO> result = abnormalLocOrderDOMapper.selectByExample(example);

        return PagedResult.success(paged.getTotal(), ListUtil.convert(result, this::toModel));
    }

    private AbnormalLocOrder toModel(AbnormalLocOrderDO orderDO) {
        if (orderDO == null) {
            return null;
        }

        AbnormalLocOrder abnormalLocOrder = new AbnormalLocOrder();

        abnormalLocOrder.setId(orderDO.getId());
        abnormalLocOrder.setGmtCreate(orderDO.getGmtCreate());
        abnormalLocOrder.setGmtCreateStr(DateUtil.formatTime(orderDO.getGmtCreate()));
        abnormalLocOrder.setOutBizType(orderDO.getOutBizType());
        abnormalLocOrder.setOutBizOrderNO(orderDO.getOutBizOrderNo());
        abnormalLocOrder.setOutLocCompany(orderDO.getOutLocCompany());
        abnormalLocOrder.setOutLocOrderNO(orderDO.getOutLocOrderNo());
        abnormalLocOrder.setUrgencyLevel(orderDO.getUrgencyLevel());
        abnormalLocOrder.setConsumerReceiveInfo(orderDO.getConsumerReceiveInfo());
        abnormalLocOrder.setInputReporter(orderDO.getReporter());
        abnormalLocOrder.setAbnormalType(orderDO.getAbnormalType());
        abnormalLocOrder.setAbnormalInfo(orderDO.getAbnormalInfo());
        abnormalLocOrder.setProcessor(orderDO.getProcessor());
        abnormalLocOrder.setProcessResult(orderDO.getProcessResult());
        abnormalLocOrder.setOrderStatus(orderDO.getOrderStatus());
        abnormalLocOrder.setMemo(orderDO.getMemo());

        abnormalLocOrder.setAttachFileUrl(StringUtils.isNotBlank(orderDO.getAttachFileUrls())
            ? Arrays.asList(orderDO.getAttachFileUrls().split(";")) : new ArrayList<>());

        return abnormalLocOrder;
    }

    private AbnormalLocOrderDOExample buildQueryExample(AbnormalLocOrderQueryParam queryParam) {
        AbnormalLocOrderDOExample example = new AbnormalLocOrderDOExample();

        example.setOrderByClause("gmt_create desc");

        AbnormalLocOrderDOExample.Criteria criteria = example.createCriteria().andIsDeletedNotEqualTo("y");

        if (StringUtils.isNotBlank(queryParam.getOutBizOrderNO())) {
            criteria.andOutBizOrderNoEqualTo(queryParam.getOutBizOrderNO());
        }

        if (StringUtils.isNotBlank(queryParam.getOutLocOrderNO())) {
            criteria.andOutLocOrderNoEqualTo(queryParam.getOutLocOrderNO());
        }

        if (StringUtils.isNotBlank(queryParam.getUrgencyLevel())) {
            criteria.andUrgencyLevelEqualTo(queryParam.getUrgencyLevel());
        }

        if (StringUtils.isNotBlank(queryParam.getConsumerReceiveInfo())) {
            criteria.andConsumerReceiveInfoLike("%" + queryParam.getConsumerReceiveInfo() + "%");
        }

        if (StringUtils.isNotBlank(queryParam.getInputReporter())) {
            criteria.andReporterLike("%" + queryParam.getInputReporter() + "%");
        }

        if (StringUtils.isNotBlank(queryParam.getAbnormalType())) {
            criteria.andAbnormalTypeEqualTo(queryParam.getAbnormalType());
        }

        if (StringUtils.isNotBlank(queryParam.getAbnormalInfo())) {
            criteria.andAbnormalInfoLike("%" + queryParam.getAbnormalInfo() + "%");
        }

        if (StringUtils.isNotBlank(queryParam.getProcessor())) {
            criteria.andProcessorLike("%" + queryParam.getProcessor() + "%");
        }

        if (StringUtils.isNotBlank(queryParam.getProcessResult())) {
            criteria.andProcessResultLike("%" + queryParam.getProcessResult() + "%");
        }

        if (StringUtils.isNotBlank(queryParam.getMemo())) {
            criteria.andMemoLike("%" + queryParam.getMemo() + "%");
        }

        if (queryParam.getCreateDateBegin() != null) {
            criteria.andGmtCreateGreaterThanOrEqualTo(queryParam.getCreateDateBegin());
        }

        if (queryParam.getCreateDateEnd() != null) {
            criteria.andGmtCreateLessThanOrEqualTo(queryParam.getCreateDateEnd());
        }

        if (StringUtils.isNotBlank(queryParam.getOrderStatus())){
            criteria.andOrderStatusEqualTo(queryParam.getOrderStatus());
        }

        return example;
    }

    @Override
    public List<AbnormalLocOrder> batchQuery(AbnormalLocOrderQueryParam queryParam) {

        AbnormalLocOrderDOExample example = buildQueryExample(queryParam);

        List<AbnormalLocOrderDO> result = abnormalLocOrderDOMapper.selectByExample(example);

        return ListUtil.convert(result, this::toModel);
    }

    @Override
    public AbnormalLocOrder queryById(Long orderId) {
        if (NumberUtil.isNotPositive(orderId)){
            return null;
        }


        AbnormalLocOrderDO abnormalLocOrderDO = abnormalLocOrderDOMapper.selectByPrimaryKey(orderId);

        if (abnormalLocOrderDO == null){
            return null;
        }

        return toModel(abnormalLocOrderDO);
    }
}
