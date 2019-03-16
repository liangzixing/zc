/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.workflow.service.param;

import java.util.Date;
import java.util.Map;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/10/17 22:35 1.0.0
 */
public class TaskQueryCondition {

    private String processFlowId;

    private Long userId;

    private int pageStart;

    private int pageSize;

    private Date createDateBegin;

    private Date createDateEnd;

    private Map<String, Object> bizDataSearchCondition;

    private Map<String, Object> localBizDataSearchCondition;

    public String getProcessFlowId() {
        return processFlowId;
    }

    public void setProcessFlowId(String processFlowId) {
        this.processFlowId = processFlowId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Date getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(Date createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public Map<String, Object> getBizDataSearchCondition() {
        return bizDataSearchCondition;
    }

    public void setBizDataSearchCondition(Map<String, Object> bizDataSearchCondition) {
        this.bizDataSearchCondition = bizDataSearchCondition;
    }

    public Map<String, Object> getLocalBizDataSearchCondition() {
        return localBizDataSearchCondition;
    }

    public void setLocalBizDataSearchCondition(Map<String, Object> localBizDataSearchCondition) {
        this.localBizDataSearchCondition = localBizDataSearchCondition;
    }
}
