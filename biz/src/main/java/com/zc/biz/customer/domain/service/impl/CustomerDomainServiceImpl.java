/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.biz.customer.domain.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.zc.biz.customer.domain.dao.CustomerDOMapper;
import com.zc.biz.customer.domain.dao.CustomerManageDOMapper;
import com.zc.biz.customer.domain.dataobject.CustomerDO;
import com.zc.biz.customer.domain.dataobject.CustomerDOExample;
import com.zc.biz.customer.domain.model.Customer;
import com.zc.biz.customer.domain.model.converter.CustomerConverter;
import com.zc.biz.customer.domain.service.CustomerDomainService;
import com.zc.biz.customer.domain.service.param.CustomerQueryCondition;
import com.zc.dataobject.DataObjectUtil;
import com.zc.result.PagedResult;
import com.zc.utils.NumberUtil;
import org.springframework.stereotype.Service;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 17:13 1.0.0
 */
@Service
public class CustomerDomainServiceImpl implements CustomerDomainService {

    @Resource
    private CustomerDOMapper customerDOMapper;

    @Resource
    private CustomerManageDOMapper customerManageDOMapper;

    @Override
    public int insert(Customer customer, String operator) {

        CustomerDO customerDO = CustomerConverter.toDO(customer);

        DataObjectUtil.beforeInsert(customerDO, operator);

        customerDOMapper.insert(customerDO);

        return customerDO.getId();
    }

    @Override
    public PagedResult<Customer> pagedQuery(CustomerQueryCondition customerQueryCondition) {

        CustomerDOExample customerDOExample = new CustomerDOExample();

        customerDOExample.setOrderByClause("gmt_create desc");

        if (StringUtil.isNotEmpty(customerQueryCondition.getCompany())) {
            customerDOExample.createCriteria().andCompanyLike("%" + customerQueryCondition.getCompany() + "%");
        }

        Page<CustomerDO> page = PageHelper.startPage(customerQueryCondition.getCurrentPage(),
            customerQueryCondition.getPageSize(), true);

        List<CustomerDO> customerDOS = customerDOMapper.selectByExample(customerDOExample);

        return PagedResult.success(page.getTotal(), CustomerConverter.toDomainModels(customerDOS));
    }

    @Override
    public List<Customer> query(CustomerQueryCondition customerQueryCondition) {

        CustomerDOExample customerDOExample = new CustomerDOExample();

        customerDOExample.setOrderByClause("gmt_create desc");

        if (StringUtil.isNotEmpty(customerQueryCondition.getCompany())) {
            customerDOExample.createCriteria().andCompanyLike("%" + customerQueryCondition.getCompany() + "%");
        }

        List<CustomerDO> customerDOS = customerDOMapper.selectByExample(customerDOExample);

        return CustomerConverter.toDomainModels(customerDOS);
    }

    @Override
    public Customer queryById(int id) {
        return CustomerConverter.toDomainModel(customerDOMapper.selectByPrimaryKey(id));
    }

    @Override
    public int update(Customer customer, String operator) {
        if (NumberUtil.isNotPositive(customer.getId())) {
            return 0;
        }

        CustomerDO customerDO = CustomerConverter.toDO(customer);

        DataObjectUtil.beforeUpdate(customerDO, operator);

        CustomerDOExample customerDOExample = new CustomerDOExample();

        customerDOExample.createCriteria().andIdEqualTo(customer.getId());

        return customerDOMapper.updateByExampleSelective(customerDO, customerDOExample);
    }

    @Override
    public int updateBalance(int id, int balance, String operator) {
        if (NumberUtil.isNotPositive(id)) {
            return 0;
        }

        CustomerDO customerDO = new CustomerDO();
        customerDO.setId(id);
        customerDO.setBalance(balance);

        DataObjectUtil.beforeUpdate(customerDO, operator);

        CustomerDOExample customerDOExample = new CustomerDOExample();
        customerDOExample.createCriteria().andIdEqualTo(id);

        return customerDOMapper.updateByExampleSelective(customerDO, customerDOExample);
    }
}
