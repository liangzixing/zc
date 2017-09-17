package com.zc.biz.customer.domain.service;

import java.util.List;
import java.util.Map;

import com.zc.biz.customer.domain.model.Customer;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 19:32 1.0.0
 */
public interface CustomerManageDomainService {

    List<Integer> queryManagerIdsByCustomerId(Integer customerId);


    Map<Integer, List<Integer>> queryManagersByCustomerIds(List<Integer> customerIds);

    boolean deletedBy(int customerId, List<Integer> userId, String operator);

    boolean addBy(Customer customer, String operator);
}
