/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.dto;

import java.util.Date;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/10/21 13:30 1.0.0
 */
public class CustomerOperateTaskDTO {

    private String taskId;

    private String goal;

    private int customerId;

    private String company;

    private long customerAmountWhenTaskCreate;

    private long customerAmountWhenTaskComplete;

    private Date gmtCreate;

    private String gmtCreateStr;

    private Date completeDate;

    private String completeDateStr;

    private String status;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public long getCustomerAmountWhenTaskCreate() {
        return customerAmountWhenTaskCreate;
    }

    public void setCustomerAmountWhenTaskCreate(long customerAmountWhenTaskCreate) {
        this.customerAmountWhenTaskCreate = customerAmountWhenTaskCreate;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtCreateStr() {
        return gmtCreateStr;
    }

    public void setGmtCreateStr(String gmtCreateStr) {
        this.gmtCreateStr = gmtCreateStr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCustomerAmountWhenTaskComplete() {
        return customerAmountWhenTaskComplete;
    }

    public void setCustomerAmountWhenTaskComplete(long customerAmountWhenTaskComplete) {
        this.customerAmountWhenTaskComplete = customerAmountWhenTaskComplete;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public String getCompleteDateStr() {
        return completeDateStr;
    }

    public void setCompleteDateStr(String completeDateStr) {
        this.completeDateStr = completeDateStr;
    }
}
