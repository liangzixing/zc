package com.zc.biz.logistics.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zc.biz.logistics.domain.dao.AbLocOrderOPLogDOMapper;
import com.zc.biz.logistics.domain.dataobject.AbLocOrderOPLogDO;
import com.zc.biz.logistics.domain.dataobject.AbLocOrderOPLogDOExample;
import com.zc.biz.logistics.domain.model.AblLocOrderOperateLog;
import com.zc.biz.logistics.service.param.AbLocOrderOPLogQueryParam;
import com.zc.result.PagedResult;
import com.zc.utils.DateUtil;
import com.zc.utils.ListUtil;
import com.zc.utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class AbLocOrderOperateLogReadServiceImpl implements AbLocOrderOperateLogReadService {

    @Resource
    private AbLocOrderOPLogDOMapper abLocOrderOPLogDOMapper;

    @Override
    public PagedResult<AblLocOrderOperateLog> pagedQuery(AbLocOrderOPLogQueryParam queryParam) {
        if (queryParam == null || NumberUtil.isNotPositive(queryParam.getAbLocOrderId())) {
            return PagedResult.success(0, new ArrayList<>());
        }

        AbLocOrderOPLogDOExample example = new AbLocOrderOPLogDOExample();
        example.setOrderByClause("gmt_create desc");
        example.createCriteria().andAbLocOrderIdEqualTo(queryParam.getAbLocOrderId()).andIsDeletedNotEqualTo("y");

        int currentPage = queryParam.getCurrentPage() < 1 ? 1 : queryParam.getCurrentPage();
        int pageSize = (queryParam.getPageSize() <= 1 || queryParam.getPageSize() >= 20) ? 20
            : queryParam.getPageSize();

        Page<AbLocOrderOPLogDO> paged = PageHelper.startPage(currentPage, pageSize);

        List<AbLocOrderOPLogDO> dos = abLocOrderOPLogDOMapper.selectByExample(example);

        return PagedResult.success(paged.getTotal(), ListUtil.convert(dos, this::toMode));
    }

    private AblLocOrderOperateLog toMode(AbLocOrderOPLogDO logDO) {
        if (logDO == null) {
            return null;
        }

        AblLocOrderOperateLog log = new AblLocOrderOperateLog();

        log.setId(logDO.getId());
        log.setAbnormalOrderId(logDO.getAbLocOrderId());
        log.setGmtCreate(logDO.getGmtCreate());
        log.setUserId(logDO.getUserId());
        log.setUserName(logDO.getUserName());
        log.setStatusBefore(logDO.getStatusBefore());
        log.setStatusAfter(logDO.getStatusAfter());
        log.setGmtCreateStr(DateUtil.formatTime(logDO.getGmtCreate()));

        return log;
    }

    @Override
    public List<AblLocOrderOperateLog> batchQuery(AbLocOrderOPLogQueryParam queryParam) {
        if (queryParam == null || NumberUtil.isNotPositive(queryParam.getAbLocOrderId())) {
            return Collections.emptyList();
        }

        AbLocOrderOPLogDOExample example = new AbLocOrderOPLogDOExample();
        example.setOrderByClause("gmt_create desc");
        example.createCriteria().andAbLocOrderIdEqualTo(queryParam.getAbLocOrderId()).andIsDeletedNotEqualTo("y");

        List<AbLocOrderOPLogDO> dos = abLocOrderOPLogDOMapper.selectByExample(example);

        return ListUtil.convert(dos, this::toMode);
    }
}
