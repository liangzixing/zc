/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.acl.service.impl;

import com.zc.acl.model.User;
import com.zc.acl.service.UserService;
import com.zc.utils.MD5Util;
import org.springframework.stereotype.Service;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/8/31 16:36 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getByName(String username) {

        User user = new User();

        user.setUsername(username);
        user.setPassword(MD5Util.getMD5to16("123456"));

        return user;
    }
}
