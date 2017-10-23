/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.param;

import java.util.Date;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/10/21 13:36 1.0.0
 */
public class CustomerOperateTaskQueryParam extends PageQueryCondition {

    private Date taskCreateBegin;

    private Date taskCreateEnd;

    private int customerId;

    private int userId;

    public Date getTaskCreateBegin() {
        return taskCreateBegin;
    }

    public void setTaskCreateBegin(Date taskCreateBegin) {
        this.taskCreateBegin = taskCreateBegin;
    }

    public Date getTaskCreateEnd() {
        return taskCreateEnd;
    }

    public void setTaskCreateEnd(Date taskCreateEnd) {
        this.taskCreateEnd = taskCreateEnd;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
