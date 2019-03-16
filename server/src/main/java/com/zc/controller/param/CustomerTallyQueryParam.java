/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.param;

import java.util.Date;

import com.sun.tools.javac.util.List;
import com.zc.param.PageParam;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/17 20:07 1.0.0
 */
public class CustomerTallyQueryParam extends PageParam {

    private Long customerId;

    private Date reportDateBegin;

    private Date reportDateEnd;

    private Long[] ids ;

    private Long userId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
