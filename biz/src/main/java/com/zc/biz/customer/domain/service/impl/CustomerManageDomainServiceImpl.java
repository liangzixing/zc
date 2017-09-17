/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.biz.customer.domain.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.zc.biz.customer.domain.dao.CustomerManageDOMapper;
import com.zc.biz.customer.domain.dataobject.CustomerManageDO;
import com.zc.biz.customer.domain.dataobject.CustomerManageDOExample;
import com.zc.biz.customer.domain.model.Customer;
import com.zc.biz.customer.domain.service.CustomerManageDomainService;
import com.zc.dataobject.DataObjectUtil;
import com.zc.utils.ListUtil;
import com.zc.utils.NumberUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 19:33 1.0.0
 */

@Service
public class CustomerManageDomainServiceImpl implements CustomerManageDomainService {

    @Resource
    private CustomerManageDOMapper customerManageDOMapper;

    @Override
    public List<Integer> queryManagerIdsByCustomerId(Integer customerId) {

        if (NumberUtil.isNotPositive(customerId)){
            return Collections.emptyList();
        }

        CustomerManageDOExample example = new CustomerManageDOExample();

        example.createCriteria().andCustomerIdEqualTo(customerId);

        return ListUtil.collect(customerManageDOMapper.selectByExample(example), CustomerManageDO::getUserId);
    }

    @Override
    public Map<Integer, List<Integer>> queryManagersByCustomerIds(List<Integer> customerIds) {

        if (ListUtil.isBlank(customerIds)){
            return Collections.emptyMap();
        }

        CustomerManageDOExample example = new CustomerManageDOExample();

        example.createCriteria().andCustomerIdIn(customerIds);

        List<CustomerManageDO> customerManageDOS = customerManageDOMapper.selectByExample(example);

        Map<Integer, List<CustomerManageDO>> map = ListUtil.splitByKey(customerManageDOS, CustomerManageDO::getCustomerId);

        Map<Integer, List<Integer>> result = new HashMap<>();

        map.keySet().forEach(k -> result.put(k, ListUtil.collect(map.get(k), CustomerManageDO::getUserId)));

        return result;
    }

    @Override
    public boolean deletedBy(int customerId, List<Integer> userIds, String operator) {
        if (ListUtil.isBlank(userIds) || NumberUtil.isNotPositive(customerId)){
            return false;
        }

        CustomerManageDOExample example = new CustomerManageDOExample();

        example.createCriteria().andCustomerIdEqualTo(customerId).andUserIdIn(userIds);

        return customerManageDOMapper.deleteByExample(example) > 0;
    }

    @Override
    public boolean addBy(Customer customer, String operator) {

        if (customer == null || ListUtil.isBlank(customer.getManager())){
            return false;
        }

        List<CustomerManageDO> customerManageDOS = toDOs(customer);

        customerManageDOS.parallelStream().forEach(x -> DataObjectUtil.beforeInsert(x, operator));

        customerManageDOMapper.insertBatch(customerManageDOS);

        return true;
    }

    private List<CustomerManageDO> toDOs(Customer customer) {

       return customer.getManager().stream().map(m -> {

           CustomerManageDO customerManageDO = new CustomerManageDO();

           customerManageDO.setCustomerId(customer.getId());
           customerManageDO.setUserGroupId(m.getGroupId());
           customerManageDO.setUserGroupName(m.getGroupName());
           customerManageDO.setUserId(m.getId());
           customerManageDO.setUserName(m.getUsername());

           return customerManageDO;
        }).collect(Collectors.toList());
    }
}
