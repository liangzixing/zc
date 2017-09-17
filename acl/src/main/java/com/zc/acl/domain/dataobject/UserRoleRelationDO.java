package com.zc.acl.domain.dataobject;

import java.util.Date;

import com.zc.dataobject.CommonDO;

public class UserRoleRelationDO extends CommonDO {

    private Integer userId;

    private Integer roleId;

    private String roleCode;

    private Date effectStartDate;

    private Date effectEndDate;

    private String isLongEffect;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public Date getEffectStartDate() {
        return effectStartDate;
    }

    public void setEffectStartDate(Date effectStartDate) {
        this.effectStartDate = effectStartDate;
    }

    public Date getEffectEndDate() {
        return effectEndDate;
    }

    public void setEffectEndDate(Date effectEndDate) {
        this.effectEndDate = effectEndDate;
    }

    public String getIsLongEffect() {
        return isLongEffect;
    }

    public void setIsLongEffect(String isLongEffect) {
        this.isLongEffect = isLongEffect == null ? null : isLongEffect.trim();
    }
}