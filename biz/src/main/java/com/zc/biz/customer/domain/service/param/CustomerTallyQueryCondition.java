/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.biz.customer.domain.service.param;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import com.zc.param.PageParam;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/17 14:19 1.0.0
 */
public class CustomerTallyQueryCondition extends PageParam {


    private List<Long> ids = new ArrayList<>();

    private Long reporterId;

    private String description;

    private Date reportDateBegin;

    private Date reportDateEnd;

    private List<Long> customerIds = new ArrayList<>();

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Long getReporterId() {
        return reporterId;
    }

    public void setReporterId(Long reporterId) {
        this.reporterId = reporterId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReportDateBegin() {
        return reportDateBegin;
    }

    public void setReportDateBegin(Date reportDateBegin) {
        this.reportDateBegin = reportDateBegin;
    }

    public Date getReportDateEnd() {
        return reportDateEnd;
    }

    public void setReportDateEnd(Date reportDateEnd) {
        this.reportDateEnd = reportDateEnd;
    }

    public List<Long> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<Long> customerIds) {
        this.customerIds = customerIds;
    }
}
