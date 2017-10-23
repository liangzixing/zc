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

import com.zc.biz.customer.domain.dataobject.CustomerTallyDO;
import com.zc.biz.customer.domain.model.CustomerTally;
import com.zc.utils.ListUtil;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/17 14:12 1.0.0
 */
public class CustomerTallyConverter {

    public static List<CustomerTally> toDomainModels(List<CustomerTallyDO> customerTallyDOS) {

        if (ListUtil.isBlank(customerTallyDOS)){
            return Collections.emptyList();
        }

        return customerTallyDOS.parallelStream()
            .map(CustomerTallyConverter::toDomainModel)
            .collect(Collectors.toList());
    }

    public static CustomerTally toDomainModel(CustomerTallyDO customerTallyDO) {

        if (customerTallyDO == null){
            return null;
        }

        CustomerTally customerTally = new CustomerTally();

        try {
            BeanUtils.copyProperties(customerTally, customerTallyDO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return customerTally;
    }

    public static CustomerTallyDO toDO(CustomerTally customerTally){

        if (customerTally == null){
            return null;
        }

        CustomerTallyDO customerTallyDO = new CustomerTallyDO();

        try {
            BeanUtils.copyProperties(customerTallyDO, customerTally);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return customerTallyDO;
    }
}
