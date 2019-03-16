/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller;

import java.util.List;

import javax.annotation.Resource;

import com.zc.biz.customer.domain.model.Customer;
import com.zc.biz.customer.domain.service.CustomerDomainService;
import com.zc.biz.customer.domain.service.param.CustomerQueryCondition;
import com.zc.biz.customer.service.CustomerService;
import com.zc.controller.dto.AjaxResult;
import com.zc.controller.dto.CustomerDTO;
import com.zc.controller.dto.GridAjaxResult;
import com.zc.controller.dto.converter.CustomerDTOConverter;
import com.zc.controller.param.CustomerEditDTO;
import com.zc.controller.param.CustomerQueryParam;
import com.zc.result.PagedResult;
import com.zc.utils.NumberUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 15:18 1.0.0
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    @Resource
    private CustomerService customerService;

    @Resource
    private CustomerDomainService customerDomainService;

    @RequestMapping("/listPage")
    public String listPage() {
        return "customer/listPage";
    }


    @RequestMapping("/my")
    public String myCustomer(){
        return "customer/my";
    }

    @ResponseBody
    @RequestMapping("/getById")
    public AjaxResult<CustomerDTO> getById(Integer id) {
        return AjaxResult.success(CustomerDTOConverter.toDTO(customerService.queryById(id)));
    }

    @ResponseBody
    @RequestMapping("/pagedQuery")
    public GridAjaxResult<CustomerDTO> pagedQuery(CustomerQueryParam param) {

        CustomerQueryCondition customerQueryCondition = new CustomerQueryCondition();

        customerQueryCondition.setCompany(param.getCompany());
        customerQueryCondition.setCurrentPage(param.getCurrentPage());
        customerQueryCondition.setPageSize(param.getPageSize());
        customerQueryCondition.setUserId(param.getUserId());

        PagedResult<Customer> customers = customerService.pagedQuery(customerQueryCondition);

        return GridAjaxResult.success(customers.getTotal(), CustomerDTOConverter.toDTOs(customers.getData()));
    }

    @ResponseBody
    @RequestMapping("/pagedSearch")
    public List<CustomerDTO> pagedSearch(CustomerQueryParam param) {
        return pagedQuery(param).getRows();
    }

    @ResponseBody
    @RequestMapping("/add")
    public AjaxResult<Boolean> add(CustomerEditDTO customerEditDTO) {
        try {

            Customer customer = new Customer();

            BeanUtils.copyProperties(customer, customerEditDTO);

            customerDomainService.insert(customer, getLoginUserName());

            return AjaxResult.success(true);

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.unSuccess(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/edit")
    public AjaxResult<Boolean> edit(CustomerEditDTO customerEditDTO) {

        if (NumberUtil.isNotPositive(customerEditDTO.getId())) {
            return AjaxResult.unSuccess("illegal param");
        }

        try {

            Customer customer = new Customer();

            BeanUtils.copyProperties(customer, customerEditDTO);

            customerDomainService.update(customer, getLoginUserName());

            return AjaxResult.success(true);

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.unSuccess(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/setManagers")
    public AjaxResult<Boolean> setManagers(Long customerId, Long[] choose) {

        if (NumberUtil.isNotPositive(customerId)
            || choose == null || choose.length == 0) {
            return AjaxResult.unSuccess("illegal param");
        }

        customerService.updateManager(customerId, choose, getLoginUserName());

        return AjaxResult.success(true);
    }

}
