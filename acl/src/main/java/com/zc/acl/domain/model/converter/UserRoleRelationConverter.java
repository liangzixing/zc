/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.acl.domain.model.converter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.zc.acl.domain.dataobject.RoleDO;
import com.zc.acl.domain.dataobject.UserRoleRelationDO;
import com.zc.acl.domain.model.Role;
import com.zc.utils.ListUtil;
import com.zc.utils.MapUtils;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/13 15:22 1.0.0
 */
public class UserRoleRelationConverter {

    public static List<UserRoleRelationDO> toDOS(long userId, List<Role> roles) {
        return roles.stream().map(r -> toDO(userId, r)).collect(Collectors.toList());
    }

    private static UserRoleRelationDO toDO(long userId, Role r) {
        UserRoleRelationDO userRoleRelationDO = new UserRoleRelationDO();

        userRoleRelationDO.setIsLongEffect("y");
        userRoleRelationDO.setRoleCode(r.getCode());
        userRoleRelationDO.setRoleId(r.getId());
        userRoleRelationDO.setUserId(userId);

        return userRoleRelationDO;
    }

    public static List<Role> toRole(List<UserRoleRelationDO> dos, Map<Long, RoleDO> roles) {

        if (ListUtil.isBlank(dos) || MapUtils.isBlank(roles)){
            return Collections.emptyList();
        }

        return dos.parallelStream().map(r -> RoleConverter.toDomainModel(roles.get(r.getRoleId())))
            .filter(x -> x != null)
            .collect(Collectors.toList());
    }


}
