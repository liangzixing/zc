/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.biz.customer.service.impl;

import javax.annotation.Resource;

import com.zc.biz.customer.domain.model.Customer;
import com.zc.biz.customer.domain.model.CustomerTally;
import com.zc.biz.customer.domain.service.CustomerDomainService;
import com.zc.biz.customer.domain.service.CustomerTallyDomainService;
import com.zc.biz.customer.service.CustomerTallyService;
import com.zc.utils.NumberUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/17 15:03 1.0.0
 */

@Service
public class CustomerTallyServiceImpl implements CustomerTallyService {

    @Resource
    private CustomerTallyDomainService customerTallyDomainService;

    @Resource
    private CustomerDomainService customerDomainService;

    @Transactional
    @Override
    public int insert(CustomerTally customerTally, String operator) {
        if (customerTally == null){
            return 0;
        }

        Customer customer = customerDomainService.queryById(customerTally.getCustomerId());

        if (customer == null){
            return 0;
        }

        int customerLastBalance = customer.getBalance() == null? 0 : customer.getBalance();

        int customerBalance = 0;

        if ("in".equalsIgnoreCase(customerTally.getType())){
            customerBalance = customerLastBalance + customerTally.getAmount();
        }

        if ("out".equalsIgnoreCase(customerTally.getType())){
            customerBalance = customerLastBalance - customerTally.getAmount();
        }

        customerTally.setCustomerLastBalance(customerLastBalance);
        customerTally.setCustomerBalance(customerBalance);
        customerTally.setCompany(customer.getCompany());

        customerDomainService.updateBalance(customer.getId(), customerBalance, operator);

        return customerTallyDomainService.insert(customerTally, operator);
    }
}
