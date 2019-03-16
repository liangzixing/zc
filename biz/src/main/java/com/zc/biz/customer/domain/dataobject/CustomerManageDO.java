package com.zc.biz.customer.domain.dataobject;

import com.zc.dataobject.CommonDO;

import java.util.Date;

public class CustomerManageDO extends CommonDO {

    private Long customerId;

    private Long userId;

    private String userName;

    private Long userGroupId;

    private String userGroupName;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public Long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName == null ? null : userGroupName.trim();
    }
}