package com.zc.biz.customer.domain.service;

import java.util.List;
import com.zc.biz.customer.domain.model.Customer;
import com.zc.biz.customer.domain.service.param.CustomerQueryCondition;
import com.zc.result.PagedResult;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 17:12 1.0.0
 */
public interface CustomerDomainService {

    int insert(Customer customer, String operator);

    PagedResult<Customer> pagedQuery(CustomerQueryCondition customerQueryCondition);

    List<Customer> query(CustomerQueryCondition customerQueryCondition);

    Customer queryById(int id);

    int update(Customer customer, String operator);

}
