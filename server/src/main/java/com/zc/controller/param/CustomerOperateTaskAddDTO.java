/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.param;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/10/21 13:58 1.0.0
 */
public class CustomerOperateTaskAddDTO {

    private Integer[] customerIds = {};

    private String goal;

    public Integer[] getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(Integer[] customerIds) {
        this.customerIds = customerIds;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
