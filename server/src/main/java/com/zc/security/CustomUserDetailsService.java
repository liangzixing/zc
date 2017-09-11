/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.security;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import com.zc.acl.model.User;
import com.zc.acl.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/8/31 16:37 1.0.0
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("UserName " + username + " not found");
        }

        // SecurityUser实现UserDetails并将SUser的Email映射为username
        SecurityUser securityUser = SecurityUser.from(user);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        securityUser.setGrantedAuthorities(authorities);

        return securityUser;
    }
}
