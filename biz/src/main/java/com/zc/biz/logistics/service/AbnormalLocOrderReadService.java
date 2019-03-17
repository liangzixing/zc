package com.zc.biz.logistics.service;

import com.zc.biz.logistics.domain.model.AbnormalLocOrder;
import com.zc.biz.logistics.service.param.AbnormalLocOrderQueryParam;
import com.zc.result.PagedResult;

import java.util.List;

public interface AbnormalLocOrderReadService {

    PagedResult<AbnormalLocOrder> pagedQuery(AbnormalLocOrderQueryParam queryParam);

    List<AbnormalLocOrder> batchQuery(AbnormalLocOrderQueryParam queryParam);

}
