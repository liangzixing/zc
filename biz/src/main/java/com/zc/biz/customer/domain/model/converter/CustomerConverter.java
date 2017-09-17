/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.biz.customer.domain.model.converter;

import java.lang.reflect.InvocationTargetException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.zc.biz.customer.domain.dataobject.CustomerDO;
import com.zc.biz.customer.domain.model.Customer;
import com.zc.utils.ListUtil;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 17:19 1.0.0
 */
public class CustomerConverter {

    public static CustomerDO toDO(Customer customer){

        if (customer == null){
            return null;
        }

        CustomerDO customerDO = new CustomerDO();

        customerDO.setId(customer.getId());
        customerDO.setCompany(customer.getCompany());
        customerDO.setCompanyCode(customer.getCompanyCode());
        customerDO.setContactName(customer.getContactName());
        customerDO.setContactMobile(customer.getContactMobile());
        customerDO.setContactEmail(customer.getContactEmail());
        customerDO.setAccount(customer.getAccount());
        customerDO.setAccountType(customer.getAccountType());
        customerDO.setBalance(customer.getBalance());
        customerDO.setStatus(customer.getStatus());

        return customerDO;
    }


    public static List<Customer> toDomainModels(List<CustomerDO> dos){

        if (ListUtil.isBlank(dos)){
            return Collections.emptyList();
        }

        return dos.parallelStream().map(CustomerConverter::toDomainModel).collect(Collectors.toList());
    }


    public static Customer toDomainModel(CustomerDO customerDO) {

        if (customerDO == null){
            return null;
        }

        Customer customer = new Customer();

        try {
            BeanUtils.copyProperties(customer, customerDO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return customer;
    }
}
