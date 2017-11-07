/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.workflow.model;

import java.util.Date;
import java.util.Map;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/10/17 22:32 1.0.0
 */
public class UserTask {

    private String taskId;

    private Map<String, Object> bizData;

    private Map<String, Object> localBizData;

    private Date createDate;

    private Date completeDate;

    private String status;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Map<String, Object> getBizData() {
        return bizData;
    }

    public void setBizData(Map<String, Object> bizData) {
        this.bizData = bizData;
    }

    public Map<String, Object> getLocalBizData() {
        return localBizData;
    }

    public void setLocalBizData(Map<String, Object> localBizData) {
        this.localBizData = localBizData;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }
}
