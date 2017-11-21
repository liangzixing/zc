/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import com.zc.security.SecurityUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/8/31 16:12 1.0.0
 */
@Controller
public class Home {

    @RequestMapping(value={"/","/home"})
    public String home() {
        return "home";
    }

}
