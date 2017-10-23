/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.dto.converter;

import com.zc.biz.customer.domain.model.CustomerTally;
import com.zc.controller.dto.CustomerTallyDTO;
import com.zc.utils.ListUtil;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/17 15:17 1.0.0
 */
public class CustomerTallyDTOConverter {

    public static CustomerTallyDTO toDTO(CustomerTally customerTally){

        CustomerTallyDTO customerTallyDTO = new CustomerTallyDTO();

        try {
            BeanUtils.copyProperties(customerTallyDTO, customerTally);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return customerTallyDTO;
    }

    public static List<CustomerTallyDTO> toDTOs(List<CustomerTally> customerTallyList){
        if (ListUtil.isBlank(customerTallyList)){
            return Collections.emptyList();
        }

        return customerTallyList.parallelStream()
            .map(CustomerTallyDTOConverter::toDTO).collect(Collectors.toList());
    }
}
