/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller;

import javax.servlet.http.HttpServletRequest;

import com.zc.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;

import java.util.List;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/13 14:36 1.0.0
 */
public class BaseController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    //@Autowired
    //private SessionRegistry sessionRegistry;

    protected SecurityContext getSecurityContext() {
        return (SecurityContextImpl) httpServletRequest
            .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
    }

    protected String getLoginUserName(){
        return getSecurityContext().getAuthentication().getName();
    }

    protected SecurityUser getLoginUser(){
        return (SecurityUser)getSecurityContext().getAuthentication().getPrincipal();
    }

    protected int getLoginUserId(){
        return getLoginUser().getId();
    }

    //protected void expireNow(){
    //    List<SessionInformation> sessionInformations = sessionRegistry
    //        .getAllSessions(getSecurityContext().getAuthentication().getPrincipal(), false);
    //
    //    for (SessionInformation sessionInformation : sessionInformations) {
    //        sessionInformation.expireNow();
    //    }
    //}
    //
    //protected void expireBuyUserName(){
    //
    //}
}
