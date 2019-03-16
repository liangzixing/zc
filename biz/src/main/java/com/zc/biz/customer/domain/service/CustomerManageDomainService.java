package com.zc.biz.customer.domain.service;

import java.util.List;
import java.util.Map;

import com.zc.biz.customer.domain.model.Customer;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 19:32 1.0.0
 */
public interface CustomerManageDomainService {

    List<Long> queryManagerIdsByCustomerId(Long customerId);

    Map<Long, List<Long>> queryManagersByCustomerIds(List<Long> customerIds);

    boolean deletedBy(long customerId, List<Long> userId, String operator);

    boolean addBy(Customer customer, String operator);

    List<Long> queryCustomerIdsByManagerId(Long userId);
}
