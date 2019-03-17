package com.zc.biz.logistics.domain.dataobject;

import com.zc.dataobject.CommonDO;

public class AbLocOrderOPLogDO extends CommonDO {

    private Long abLocOrderId;

    private Long userId;

    private String userName;

    private String statusBefore;

    private String statusAfter;

    public Long getAbLocOrderId() {
        return abLocOrderId;
    }

    public void setAbLocOrderId(Long abLocOrderId) {
        this.abLocOrderId = abLocOrderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getStatusBefore() {
        return statusBefore;
    }

    public void setStatusBefore(String statusBefore) {
        this.statusBefore = statusBefore == null ? null : statusBefore.trim();
    }

    public String getStatusAfter() {
        return statusAfter;
    }

    public void setStatusAfter(String statusAfter) {
        this.statusAfter = statusAfter == null ? null : statusAfter.trim();
    }
}