/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.dto.converter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.zc.acl.domain.model.Role;
import com.zc.acl.domain.model.User;
import com.zc.controller.dto.RoleDTO;
import com.zc.controller.dto.UserDTO;
import com.zc.utils.DateUtil;
import com.zc.utils.ListUtil;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/14 14:20 1.0.0
 */
public class UserDTOConverter {

    public static List<UserDTO> toDTOs(List<User> users){
        if (ListUtil.isBlank(users)){
            return Collections.emptyList();
        }

        return users.parallelStream().map(UserDTOConverter::toDTO)
            .filter(x -> x!= null)
            .collect(Collectors.toList());
    }

    public static UserDTO toDTO(User user) {
        if (user == null){
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserName(user.getUsername());
        userDTO.setMobile(user.getMobile());
        userDTO.setId(user.getId());
        userDTO.setGmtCreate(user.getGmtCreate());
        userDTO.setGmtCreateStr(DateUtil.formatTime(user.getGmtCreate()));

        userDTO.setRoles(toRoleDTOs(user.getRoles()));

        return userDTO;
    }

    public static List<RoleDTO> toRoleDTOs(List<Role> roles) {
        if (ListUtil.isBlank(roles)){
            return Collections.emptyList();
        }

        return roles.parallelStream().map(UserDTOConverter::toRoleDTO)
            .filter(x -> x!= null)
            .collect(Collectors.toList());
    }

    public static RoleDTO toRoleDTO(Role role) {
        if (role == null){
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId(role.getId());
        roleDTO.setCode(role.getCode());
        roleDTO.setDesc(role.getDesc());
        roleDTO.setName(role.getName());

        return roleDTO;
    }
}
