/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.biz.customer.domain.service.param;

import com.zc.param.PageParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/16 17:06 1.0.0
 */
public class CustomerQueryCondition extends PageParam{

    private String company;

    private Long userId;

    private List<Long> ids = new ArrayList<>();

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
