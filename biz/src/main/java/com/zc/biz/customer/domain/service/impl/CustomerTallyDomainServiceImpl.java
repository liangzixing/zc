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
import com.zc.biz.customer.domain.dao.CustomerTallyDOMapper;
import com.zc.biz.customer.domain.dataobject.CustomerTallyDO;
import com.zc.biz.customer.domain.dataobject.CustomerTallyDOExample;
import com.zc.biz.customer.domain.model.CustomerTally;
import com.zc.biz.customer.domain.model.converter.CustomerTallyConverter;
import com.zc.biz.customer.domain.service.CustomerTallyDomainService;
import com.zc.biz.customer.domain.service.param.CustomerTallyQueryCondition;
import com.zc.dataobject.DataObjectUtil;
import com.zc.result.PagedResult;
import com.zc.utils.ListUtil;
import com.zc.utils.NumberUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/17 14:27 1.0.0
 */

@Service
public class CustomerTallyDomainServiceImpl implements CustomerTallyDomainService {

    @Resource
    private CustomerTallyDOMapper customerTallyDOMapper;

    @Override
    public PagedResult<CustomerTally> pagedQuery(CustomerTallyQueryCondition condition) {

        CustomerTallyDOExample example = initSearchExample(condition);

        Page<CustomerTallyDO> page = PageHelper.startPage(condition.getCurrentPage(), condition.getPageSize(), true);

        List<CustomerTallyDO> customerTallyDOS = customerTallyDOMapper.selectByExample(example);

        return PagedResult.success(page.getTotal(), CustomerTallyConverter.toDomainModels(customerTallyDOS));
    }

    private CustomerTallyDOExample initSearchExample(CustomerTallyQueryCondition condition) {

        CustomerTallyDOExample customerTallyDOExample = new CustomerTallyDOExample();

        customerTallyDOExample.setOrderByClause("gmt_create desc");

        customerTallyDOExample.createCriteria().andIsDeletedEqualTo("n");

        if (ListUtil.isNotBlank(condition.getCustomerIds())) {
            customerTallyDOExample.getOredCriteria().get(0).andCustomerIdIn(condition.getCustomerIds());
        }

        if (ListUtil.isNotBlank(condition.getIds())) {
            customerTallyDOExample.getOredCriteria().get(0).andIdIn(condition.getIds());
        }

        if (StringUtils.isNotBlank(condition.getDescription())) {
            customerTallyDOExample.getOredCriteria().get(0).andDescriptionLike("%" + condition.getDescription() + "%");
        }

        if (NumberUtil.isPositive(condition.getReporterId())) {
            customerTallyDOExample.getOredCriteria().get(0).andReporterIdEqualTo(condition.getReporterId());
        }

        if (condition.getReportDateBegin() != null) {
            customerTallyDOExample.getOredCriteria().get(0).andReportDateGreaterThan(condition.getReportDateBegin());
        }

        if (condition.getReportDateEnd() != null) {
            customerTallyDOExample.getOredCriteria().get(0).andReportDateLessThan(condition.getReportDateEnd());
        }

        return customerTallyDOExample;
    }

    @Override
    public List<CustomerTally> query(CustomerTallyQueryCondition condition) {

        CustomerTallyDOExample example = initSearchExample(condition);

        return CustomerTallyConverter.toDomainModels(customerTallyDOMapper.selectByExample(example));
    }

    @Override
    public CustomerTally queryById(Long id) {
        if (NumberUtil.isNotPositive(id)) {
            return null;
        }

        return CustomerTallyConverter.toDomainModel(customerTallyDOMapper.selectByPrimaryKey(id));
    }

    @Override
    public long insert(CustomerTally customerTally, String operator) {
        if (customerTally == null) {
            return 0;
        }

        CustomerTallyDO customerTallyDO = CustomerTallyConverter.toDO(customerTally);

        DataObjectUtil.beforeInsert(customerTallyDO, operator);

        customerTallyDOMapper.insert(customerTallyDO);

        return customerTallyDO.getId();
    }

    @Override
    public int update(CustomerTally customerTally, String operator) {
        if (customerTally == null || NumberUtil.isNotPositive(customerTally.getId())) {
            return 0;
        }

        CustomerTallyDOExample example = new CustomerTallyDOExample();

        example.createCriteria().andIdEqualTo(customerTally.getId());

        CustomerTallyDO customerTallyDO = new CustomerTallyDO();

        customerTallyDO.setId(customerTally.getId());
        customerTallyDO.setFromAccountType(customerTally.getFromAccountType());
        customerTallyDO.setFromAccount(customerTally.getFromAccount());
        customerTallyDO.setToAccountType(customerTally.getToAccountType());
        customerTallyDO.setToAccount(customerTally.getToAccount());

        customerTallyDO.setDescription(customerTally.getDescription());

        customerTallyDO.setCredentialsImgUrl(customerTally.getCredentialsImgUrl());

        DataObjectUtil.beforeUpdate(customerTallyDO, operator);

        return customerTallyDOMapper.updateByExampleSelective(customerTallyDO, example);
    }

    @Override
    public int hide(long id, String operator) {
        if (NumberUtil.isNotPositive(id)) {
            return 0;
        }
        CustomerTallyDOExample example = new CustomerTallyDOExample();

        example.createCriteria().andIdEqualTo(id);

        CustomerTallyDO customerTallyDO = new CustomerTallyDO();

        customerTallyDO.setId(id);
        customerTallyDO.setDisplay("none");

        DataObjectUtil.beforeUpdate(customerTallyDO, operator);

        return customerTallyDOMapper.updateByExampleSelective(customerTallyDO, example);
    }
}
