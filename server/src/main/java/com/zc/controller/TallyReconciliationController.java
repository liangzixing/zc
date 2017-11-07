/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.zc.biz.customer.domain.model.Customer;
import com.zc.biz.customer.domain.model.CustomerTally;
import com.zc.biz.customer.domain.service.CustomerTallyDomainService;
import com.zc.biz.customer.domain.service.param.CustomerTallyQueryCondition;
import com.zc.biz.customer.service.CustomerService;
import com.zc.controller.dto.CustomerReconciliationDTO;
import com.zc.controller.dto.GridAjaxResult;
import com.zc.result.PagedResult;
import com.zc.utils.ListUtil;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/11/6 21:48 1.0.0
 */
@Controller
@RequestMapping("/tallyRecon")
public class TallyReconciliationController extends BaseController{

    @Resource
    private CustomerTallyDomainService customerTallyDomainService;



    @Resource
    private CustomerService customerService;

    private static final long _30_days = 1000*3600*24*30l;

    @RequestMapping("/reconciliationPage")
    public String reconciliationPage(){
        return "/customerTally/reconciliationPage";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @ResponseBody
    @RequestMapping("/reconciliation")
    public GridAjaxResult<CustomerReconciliationDTO> reconciliation(@RequestParam(value = "customerIds[]")Integer[] customerIds,
                                                                    Date begin, Date end){

        if (end == null){
            end = new Date();
        }

        if (customerIds == null || begin == null || end.getTime()- begin.getTime() > _30_days){
            return GridAjaxResult.unSuccess("ILLEGAL PARAM: 请选定客户并设定账期时间(不能超过30天)");
        }

        CustomerTallyQueryCondition customerTallyQueryCondition = new CustomerTallyQueryCondition();
        customerTallyQueryCondition.getCustomerIds().addAll(Arrays.asList(customerIds));
        customerTallyQueryCondition.setReportDateBegin(begin);
        customerTallyQueryCondition.setReportDateEnd(end);

        List<CustomerTally> customerTallies = customerTallyDomainService.query(customerTallyQueryCondition);

        if (ListUtil.isBlank(customerTallies)){
            return GridAjaxResult.success(0, new ArrayList<>());
        }

        Map<Integer, List<CustomerTally>> customerIdTOTally = ListUtil.splitByKey(customerTallies, CustomerTally::getCustomerId);

        List<CustomerReconciliationDTO> list = Collections.synchronizedList(new ArrayList<>(customerIds.length + 1));

        final Date beginCopy = new Date(begin.getTime());

        Arrays.stream(customerIds).parallel().forEach( customerId -> {

            List<CustomerTally> tallies = customerIdTOTally.get(customerId);

            if (ListUtil.isBlank(tallies)){
                buildReconForNOTallyCustomer(beginCopy, customerId);
            } else {
                list.add(toCustomerReconciliationDTO(tallies));
            }
        });

        // cal total
        long lastBalanceTotal = 0;
        long balanceTotal = 0;
        long inTotal = 0;
        long outTotal = 0;

        for (CustomerReconciliationDTO cr : list){
            lastBalanceTotal += cr.getLastBalanceTotal();
            balanceTotal += cr.getBalanceTotal();
            inTotal += cr.getInTotal();
            outTotal += cr.getOutTotal();
        }

        CustomerReconciliationDTO total = new CustomerReconciliationDTO();
        total.setBalanceTotal(balanceTotal);
        total.setLastBalanceTotal(lastBalanceTotal);
        total.setInTotal(inTotal);
        total.setOutTotal(outTotal);
        total.setTotal(true);

        list.add(total);

        return GridAjaxResult.success(list.size(), list);
    }

    private CustomerReconciliationDTO buildReconForNOTallyCustomer(Date beginCopy, Integer customerId) {

        // find last Tally
        CustomerTally customerTally = findLastCustomerTally(customerId, beginCopy);

        CustomerReconciliationDTO customerReconciliationDTO = new CustomerReconciliationDTO();

        if (customerTally != null){

            customerReconciliationDTO.setCustomerId(customerTally.getCustomerId());
            customerReconciliationDTO.setCompany(customerTally.getCompany());
            customerReconciliationDTO.setLastBalanceTotal(customerTally.getCustomerBalance());
            customerReconciliationDTO.setBalanceTotal(customerTally.getCustomerBalance());

            return customerReconciliationDTO;
        }

        Customer customer = customerService.queryById(customerId);
        if (customer != null){
            customerReconciliationDTO.setCustomerId(customer.getId());
            customerReconciliationDTO.setCompany(customer.getCompany());
            customerReconciliationDTO.setLastBalanceTotal(customer.getBalance());
            customerReconciliationDTO.setBalanceTotal(customer.getBalance());
            return customerReconciliationDTO;
        }

        return null;
    }

    private CustomerTally findLastCustomerTally(Integer customerId, Date date) {

        CustomerTallyQueryCondition customerTallyQueryCondition = new CustomerTallyQueryCondition();
        customerTallyQueryCondition.getCustomerIds().addAll(Arrays.asList(customerId));
        customerTallyQueryCondition.setReportDateEnd(date);
        customerTallyQueryCondition.setCurrentPage(0);
        customerTallyQueryCondition.setPageSize(1);

        PagedResult<CustomerTally> customerTallies = customerTallyDomainService.pagedQuery(customerTallyQueryCondition);

        return customerTallies.getData().get(0);
    }

    private CustomerReconciliationDTO toCustomerReconciliationDTO(List<CustomerTally> customerTallies) {

        customerTallies.sort(Comparator.comparing(x -> x.getReportDate()));

        CustomerReconciliationDTO customerReconciliationDTO = new CustomerReconciliationDTO();

        customerReconciliationDTO.setCustomerId(customerTallies.get(0).getCustomerId());
        customerReconciliationDTO.setCompany(customerTallies.get(0).getCompany());

        long lastBalanceTotal = 0;
        long balanceTotal = 0;
        long inTotal = 0;
        long outTotal = 0;

        for (CustomerTally ct : customerTallies){

            lastBalanceTotal += ct.getCustomerLastBalance();
            balanceTotal += ct.getCustomerBalance();

            if ("in".equalsIgnoreCase(ct.getType())){
                inTotal += ct.getAmount();
            }

            if ("out".equalsIgnoreCase(ct.getType())){
                outTotal += ct.getAmount();
            }
        }

        customerReconciliationDTO.setLastBalanceTotal(lastBalanceTotal);
        customerReconciliationDTO.setBalanceTotal(balanceTotal);
        customerReconciliationDTO.setInTotal(inTotal);
        customerReconciliationDTO.setOutTotal(outTotal);

        return customerReconciliationDTO;
    }
}
