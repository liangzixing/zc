/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.acl.domain.model.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.zc.acl.domain.dataobject.UserDO;
import com.zc.acl.domain.model.User;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/13 15:08 1.0.0
 */
public class UserConverter {

    public static List<User> toDomainModels(List<UserDO> userDOS) {
        return userDOS.parallelStream().map(UserConverter::toDomainModel).collect(Collectors.toList());
    }

    public static UserDO toDO(User user){
        if (user == null){
            return null;
        }

        UserDO userDO = new UserDO();

        userDO.setName(user.getUsername());
        userDO.setPassword(user.getPassword());
        userDO.setMobile(user.getMobile());

        if (user.getId() != null){
            userDO.setId(user.getId());
        }

        return userDO;
    }

    public static User toDomainModel(UserDO userDO){

        if (userDO == null){
            return null;
        }

        User user = new User();
        user.setId(userDO.getId());
        user.setUsername(userDO.getName());
        user.setMobile(userDO.getMobile());
        user.setPassword(userDO.getPassword());
        user.setGmtCreate(userDO.getGmtCreate());

        return user;
    }


}
