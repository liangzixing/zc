/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.acl.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import com.zc.acl.domain.model.Role;
import com.zc.acl.domain.model.User;
import com.zc.acl.domain.service.RoleDomainService;
import com.zc.acl.domain.service.UserDomainService;
import com.zc.acl.service.UserService;
import com.zc.acl.service.param.UserQueryParam;
import com.zc.result.PagedResult;
import com.zc.utils.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/8/31 16:36 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDomainService userDomainService;

    @Resource
    private RoleDomainService roleDomainService;

    @Override
    public User getByName(String username) {
        return userDomainService.getByUserName(username);
    }

    @Override
    public User getById(long id) {
        return userDomainService.getById(id);
    }

    @Override
    public long insert(User user, Long[] roleIds, String operator) {

        if (roleIds != null) {
            List<Role> roles = roleDomainService.queryByIds(Arrays.asList(roleIds));
            user.setRoles(roles);
        }

        user.setPassword(MD5Util.getMD5to16("123456"));

        return userDomainService.insert(user, operator);
    }

    @Override
    public int update(User user, Long[] roleIds, String operator) {

        if (roleIds != null) {
            List<Role> roles = roleDomainService.queryByIds(Arrays.asList(roleIds));
            user.setRoles(roles);
        }

        return userDomainService.update(user, operator);
    }

    @Override
    public boolean resetPassword(long id, String oldPassword, String newPassword, String operator) {

        if (StringUtils.isBlank(newPassword)) {
            newPassword = "123456";
        }

        oldPassword = MD5Util.getMD5to16(oldPassword);
        newPassword = MD5Util.getMD5to16(newPassword);

        return userDomainService.resetPassword(id, oldPassword, newPassword, operator) > 0;
    }

    @Override
    public boolean resetPasswordForAdmin(long id, String operator) {
        User user = getById(id);

        if (user == null) {
            return false;
        }

        return userDomainService.resetPassword(user.getId(),
            user.getPassword(), MD5Util.getMD5to16("123456"), operator) > 0;
    }

    @Override
    public PagedResult<User> pagedQuery(UserQueryParam userQueryParam) {

        User user = new User();
        user.setUsername(userQueryParam.getUsername());
        user.setMobile(userQueryParam.getMobile());

        return userDomainService.pagedQuery(user, userQueryParam.getCurrentPage(), userQueryParam.getPageSize());
    }

}
