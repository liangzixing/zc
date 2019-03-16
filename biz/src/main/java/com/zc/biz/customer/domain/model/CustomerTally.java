/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.biz.customer.domain.model;

import java.util.Date;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 15:16 1.0.0
 */
public class CustomerTally {

    private Long id;

    private Long customerId;

    private String company;

    private String type;

    private String fromAccountType;

    private String fromAccount;

    private String toAccountType;

    private String toAccount;

    private Long amount;

    private Long customerLastBalance;

    private Long customerBalance;

    private String description;

    private String credentialsImgUrl;

    private Long reporterId;

    private String reporterName;

    private Date reportDate;

    private String display;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getCustomerLastBalance() {
        return customerLastBalance;
    }

    public void setCustomerLastBalance(Long customerLastBalance) {
        this.customerLastBalance = customerLastBalance;
    }

    public Long getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(Long customerBalance) {
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

    public Long getReporterId() {
        return reporterId;
    }

    public void setReporterId(Long reporterId) {
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
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
