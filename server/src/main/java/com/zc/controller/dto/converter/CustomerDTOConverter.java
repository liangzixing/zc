/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.dto.converter;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.zc.biz.customer.domain.model.Customer;
import com.zc.controller.dto.CustomerDTO;
import com.zc.utils.ListUtil;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 20:14 1.0.0
 */
public class CustomerDTOConverter {

    public static List<CustomerDTO> toDTOs(List<Customer> customerList){
        if (ListUtil.isBlank(customerList)){
            return Collections.emptyList();
        }

        return customerList.parallelStream().map(CustomerDTOConverter::toDTO).collect(Collectors.toList());
    }

    public static CustomerDTO toDTO(Customer customer){
        if (customer == null){
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        try {
            BeanUtils.copyProperties(customerDTO, customer);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        customerDTO.setManagers(UserDTOConverter.toDTOs(customer.getManager()));

        return customerDTO;
    }
}
