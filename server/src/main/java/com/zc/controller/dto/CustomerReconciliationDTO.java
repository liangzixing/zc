/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.dto;

import java.util.List;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/10/25 21:07 1.0.0
 */
public class CustomerReconciliationDTO {

    private boolean isTotal;

    private int customerId;

    private String company;

    // 账期前所有客户的余额总和
    public long lastBalanceTotal;

    // 账期后所有客户的余额总和
    public long balanceTotal;

    // 所有出账总和
    public long outTotal;

    // 所有入账总和
    public long inTotal;

    public long getLastBalanceTotal() {
        return lastBalanceTotal;
    }

    public void setLastBalanceTotal(long lastBalanceTotal) {
        this.lastBalanceTotal = lastBalanceTotal;
    }

    public long getBalanceTotal() {
        return balanceTotal;
    }

    public void setBalanceTotal(long balanceTotal) {
        this.balanceTotal = balanceTotal;
    }

    public long getOutTotal() {
        return outTotal;
    }

    public void setOutTotal(long outTotal) {
        this.outTotal = outTotal;
    }

    public long getInTotal() {
        return inTotal;
    }

    public void setInTotal(long inTotal) {
        this.inTotal = inTotal;
    }

    public boolean isTotal() {
        return isTotal;
    }

    public void setTotal(boolean total) {
        isTotal = total;
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
}
