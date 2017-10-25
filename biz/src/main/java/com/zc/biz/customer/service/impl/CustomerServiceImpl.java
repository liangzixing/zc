/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.biz.customer.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.zc.acl.domain.model.User;
import com.zc.acl.domain.service.UserDomainService;
import com.zc.biz.customer.domain.model.Customer;
import com.zc.biz.customer.domain.service.CustomerDomainService;
import com.zc.biz.customer.domain.service.CustomerManageDomainService;
import com.zc.biz.customer.domain.service.param.CustomerQueryCondition;
import com.zc.biz.customer.service.CustomerService;
import com.zc.result.PagedResult;
import com.zc.utils.ListUtil;
import com.zc.utils.MapUtils;
import com.zc.utils.NumberUtil;
import org.springframework.stereotype.Service;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 17:04 1.0.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerDomainService customerDomainService;

    @Resource
    private CustomerManageDomainService customerManageDomainService;

    @Resource
    private UserDomainService userDomainService;

    @Override
    public PagedResult<Customer> pagedQuery(CustomerQueryCondition customerQueryCondition) {

        if (NumberUtil.isPositive(customerQueryCondition.getUserId())){

            List<Integer> customerIds = queryCompanyIdsByManagerId(customerQueryCondition.getUserId());

            if (ListUtil.isBlank(customerIds)){
                return PagedResult.success(0, new ArrayList<>());
            }

            customerQueryCondition.getIds().addAll(customerIds);
        }

        PagedResult<Customer> customers = customerDomainService.pagedQuery(customerQueryCondition);

        if (customers == null || ListUtil.isBlank(customers.getData())) {
            return customers;
        }

        fillManagers(customers.getData());

        return customers;
    }

    private List<Integer> queryCompanyIdsByManagerId(Integer userId) {
        return customerManageDomainService.queryCustomerIdsByManagerId(userId);
    }

    private void fillManagers(List<Customer> customers) {

        Map<Integer, List<Integer>> customerIdTOUserIds = customerManageDomainService
            .queryManagersByCustomerIds(ListUtil.collect(customers, Customer::getId));

        if(MapUtils.isBlank(customerIdTOUserIds)){
            return;
        }

        Set<Integer> userIds = new HashSet<>();

        customerIdTOUserIds.values().stream().forEach(l -> userIds.addAll(l));

        List<User> users = userDomainService.getSimpleUserByIds(new ArrayList<>(userIds));

        Map<Integer, User> userIdToUser = ListUtil.toMap(users, User::getId);

        customers.stream().forEach(c -> {

            List<Integer> managerIds = customerIdTOUserIds.get(c.getId());

            if (ListUtil.isBlank(managerIds)){
                return;
            }

            List<User> managers = managerIds.stream().map(userIdToUser::get).collect(Collectors.toList());

            c.getManager().addAll(managers);
        });
    }

    @Override
    public List<Customer> query(CustomerQueryCondition customerQueryCondition) {

        if (NumberUtil.isPositive(customerQueryCondition.getUserId())){

            List<Integer> customerIds = queryCompanyIdsByManagerId(customerQueryCondition.getUserId());

            if (ListUtil.isBlank(customerIds)){
                return Collections.emptyList();
            }

            customerQueryCondition.getIds().addAll(customerIds);
        }

        List <Customer> customers = customerDomainService.query(customerQueryCondition);

        if (ListUtil.isBlank(customers)) {
            return customers;
        }

        fillManagers(customers);

        return customers;
    }

    @Override
    public Customer queryById(int id) {

        Customer customer = customerDomainService.queryById(id);

        if (customer == null){
            return null;
        }

        fillManagers(Arrays.asList(customer));

        return customer;
    }

    @Override
    public boolean updateManager(int customerId, Integer[] managerId, String operator) {

        List<Integer> oldManagerIds = customerManageDomainService.queryManagerIdsByCustomerId(customerId);

        List<Integer> newManagerIds = new ArrayList<>(Arrays.asList(managerId)) ;

        List<Integer> ignore = new ArrayList<>();

        for(Integer userId : newManagerIds){
            if (oldManagerIds.contains(userId)){
                ignore.add(userId);
            }
        }

        // needDelete
        oldManagerIds.removeAll(ignore);
        if (ListUtil.isNotBlank(oldManagerIds)){
            customerManageDomainService.deletedBy(customerId, oldManagerIds, operator);
        }

        // needAdd
        newManagerIds.removeAll(ignore);
        if (ListUtil.isNotBlank(newManagerIds)){
            Customer customer = customerDomainService.queryById(customerId);
            customer.setManager(userDomainService.getSimpleUserByIds(newManagerIds));
            customerManageDomainService.addBy(customer, operator);
        }

        return true;
    }
}
