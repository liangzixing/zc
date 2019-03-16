package com.zc.biz.customer.service;

import java.util.List;
import com.zc.biz.customer.domain.model.Customer;
import com.zc.biz.customer.domain.service.param.CustomerQueryCondition;
import com.zc.result.PagedResult;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 17:03 1.0.0
 */
public interface CustomerService {

    PagedResult<Customer> pagedQuery(CustomerQueryCondition customerQueryCondition);

    List<Customer> query(CustomerQueryCondition customerQueryCondition);

    Customer queryById(long id);

    boolean updateManager(long customerId, Long[] managerId, String operator);

}
