/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/18 13:54 1.0.0
 */
public class SecurityVelocity {
    public boolean hasAnyRole(String ...roles) {
        return isRole(roles);
    }

    /***
     * 前端传入数组参数
     * @param viewRole 可变数组 1个或者多个
     * @return 是否有权限
     */
    private boolean isRole(String ...roles){
        /** 前端数组为空 */
        if(null == roles || roles.length <= 0){
            return false;
        }

        System.out.println(Arrays.toString(roles));

        /** 获取当前用户登录对象 */
        UserDetails userDetails = null;
        try {
            userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return false;
        }
        if(null == userDetails){
            return false;
        }
        /** 获取当前用户登录对象所有权限 */
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        if(null == authorities){
            return false;
        }
        boolean flag = false;
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        while (iter.hasNext()) {
            GrantedAuthority grantedAuthority = iter.next();
            /**遍历前端列表的所有角色*/
            for (String vr : roles) {
                if(vr.equals(grantedAuthority.getAuthority())){
                    flag = true;
                    break;
                }
            }
            if (flag) break; // 已经匹配上角色了则不再需要匹配其它角色。
        }
        return flag;
    }

    public SecurityUser getUser(){
        try {
           return (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }

    public String getUserName(){
        return getUser() == null ? "" : getUser().getUsername();
    }

    public int getUserId(){
        return getUser() == null ? 0 : getUser().getId();
    }
}
