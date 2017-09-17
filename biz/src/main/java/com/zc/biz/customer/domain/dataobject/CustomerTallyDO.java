package com.zc.biz.customer.domain.dataobject;

import java.util.Date;

import com.zc.dataobject.CommonDO;

public class CustomerTallyDO extends CommonDO {

    private String customerId;

    private String type;

    private String fromAccountType;

    private String fromAccount;

    private String toAccountType;

    private String toAccount;

    private Integer amount;

    private Integer customerBalance;

    private String description;

    private String credentialsImgUrl;

    private Integer reporterId;

    private String reporterName;

    private Date reportDate;

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
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFromAccountType() {
        return fromAccountType;
    }

    public void setFromAccountType(String fromAccountType) {
        this.fromAccountType = fromAccountType == null ? null : fromAccountType.trim();
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount == null ? null : fromAccount.trim();
    }

    public String getToAccountType() {
        return toAccountType;
    }

    public void setToAccountType(String toAccountType) {
        this.toAccountType = toAccountType == null ? null : toAccountType.trim();
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount == null ? null : toAccount.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
        this.description = description == null ? null : description.trim();
    }

    public String getCredentialsImgUrl() {
        return credentialsImgUrl;
    }

    public void setCredentialsImgUrl(String credentialsImgUrl) {
        this.credentialsImgUrl = credentialsImgUrl == null ? null : credentialsImgUrl.trim();
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
        this.reporterName = reporterName == null ? null : reporterName.trim();
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

}