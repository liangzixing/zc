/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.acl.domain.model.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.zc.acl.domain.dataobject.RoleDO;
import com.zc.acl.domain.model.Role;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/15 10:51 1.0.0
 */
public class RoleConverter {

    public static List<Role> toDomainModels(List<RoleDO> roleDOS){
        return roleDOS.parallelStream().map(RoleConverter::toDomainModel).collect(Collectors.toList());
    }

    public static Role toDomainModel(RoleDO roleDO) {

        if (roleDO == null) {
            return null;
        }

        Role role = new Role();
        role.setId(roleDO.getId());
        role.setCode(roleDO.getCode());
        role.setDesc(roleDO.getDesc());
        role.setName(roleDO.getName());

        return role;
    }
}
