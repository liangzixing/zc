/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/13 14:36 1.0.0
 */
public class BaseController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    protected SecurityContext getSecurityContext() {
        return (SecurityContextImpl) httpServletRequest
            .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
    }

    protected String getLoginUserName(){
        return getSecurityContext().getAuthentication().getName();
    }
}
