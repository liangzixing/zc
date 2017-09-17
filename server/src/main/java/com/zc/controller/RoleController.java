/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller;

import java.util.List;

import javax.annotation.Resource;

import com.zc.acl.domain.model.Role;
import com.zc.acl.domain.service.RoleDomainService;
import com.zc.controller.dto.RoleDTO;
import com.zc.controller.dto.converter.UserDTOConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/13 14:39 1.0.0
 */
@Controller
public class RoleController {

    @Resource
    private RoleDomainService roleDomainService;

    @ResponseBody
    @RequestMapping("/role/list")
    public List<RoleDTO> list(){

        List<Role> roles = roleDomainService.queryAll();

        return UserDTOConverter.toRoleDTOs(roles);
    }
}
