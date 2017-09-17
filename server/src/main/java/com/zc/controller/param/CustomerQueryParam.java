/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.param;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 15:22 1.0.0
 */
public class CustomerQueryParam extends PageQueryCondition{

    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
