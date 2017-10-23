/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.dto;

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

    private int status;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
