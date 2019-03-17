package com.zc.biz.logistics.service;

import com.zc.biz.logistics.service.param.AbnormalLocOrderCreateParam;
import com.zc.biz.logistics.service.param.AbnormalLocOrderUpdateParam;

public interface AbnormalLocOrderWriteService {

    Long createOrder(AbnormalLocOrderCreateParam createParam);

    boolean updateCreateOrder(AbnormalLocOrderUpdateParam updateParam);

    boolean deleteUpdateOrder(Long orderId, String operator);

}
