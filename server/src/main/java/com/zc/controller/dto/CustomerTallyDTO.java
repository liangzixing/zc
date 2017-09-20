/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.dto;

import java.util.Date;

import com.zc.utils.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 15:21 1.0.0
 */
@ExcelTarget("customerTally")
public class CustomerTallyDTO {

    private Integer id;


    private String customerId;

    @Excel(name = "公司名称", orderNum = "1", width = 40)
    private String company;

    @Excel(name = "支出账户类型", orderNum = "2", width = 20)
    private String fromAccountType;

    @Excel(name = "支出账户号", orderNum = "3", width = 20)
    private String fromAccount;

    @Excel(name = "收入账户类型", orderNum = "4", width = 20)
    private String toAccountType;

    @Excel(name = "收入账户号", orderNum = "5",width = 20)
    private String toAccount;

    @Excel(name = "类型", orderNum = "6", replace = {"入账_in", "出账_out"})
    private String type;

    @Excel(name = "金额(分)", orderNum = "7")
    private Integer amount;

    @Excel(name = "记录前账户余额(分)", orderNum = "8")
    private Integer customerLastBalance;

    @Excel(name = "记录后账户余额(分)", orderNum = "9")
    private Integer customerBalance;

    @Excel(name = "描述", orderNum = "10", width = 50)
    private String description;

    private String credentialsImgUrl;

    private Integer reporterId;

    private String reporterName;

    @Excel(name = "记录时间", orderNum = "11", exportFormat = "yyyy-MM-dd HH:mm:ss", width = 30)
    private Date reportDate;

    private String reportDateStr;

    private String display;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFromAccountType() {
        return fromAccountType;
    }

    public void setFromAccountType(String fromAccountType) {
        this.fromAccountType = fromAccountType;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccountType() {
        return toAccountType;
    }

    public void setToAccountType(String toAccountType) {
        this.toAccountType = toAccountType;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCustomerLastBalance() {
        return customerLastBalance;
    }

    public void setCustomerLastBalance(Integer customerLastBalance) {
        this.customerLastBalance = customerLastBalance;
    }

    public Integer getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(Integer customerBalance) {
        this.customerBalance = customerBalance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCredentialsImgUrl() {
        return credentialsImgUrl;
    }

    public void setCredentialsImgUrl(String credentialsImgUrl) {
        this.credentialsImgUrl = credentialsImgUrl;
    }

    public Integer getReporterId() {
        return reporterId;
    }

    public void setReporterId(Integer reporterId) {
        this.reporterId = reporterId;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
        this.reportDateStr = DateUtil.formatTime(reportDate);
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getReportDateStr() {
        return StringUtils.isBlank(reportDateStr) ? DateUtil.formatTime(reportDate) : reportDateStr ;
    }
}
