package com.zc.biz.logistics.service;

import com.zc.biz.logistics.domain.model.AblLocOrderOperateLog;
import com.zc.biz.logistics.service.param.AbLocOrderOPLogQueryParam;
import com.zc.result.PagedResult;

import java.util.List;

public interface AbLocOrderOperateLogReadService {

    PagedResult<AblLocOrderOperateLog> pagedQuery(AbLocOrderOPLogQueryParam queryParam);

    List<AblLocOrderOperateLog> batchQuery(AbLocOrderOPLogQueryParam queryParam);
}
