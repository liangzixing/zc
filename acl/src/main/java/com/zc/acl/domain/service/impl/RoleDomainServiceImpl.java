/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.acl.domain.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zc.acl.domain.dao.RoleDOMapper;
import com.zc.acl.domain.dataobject.RoleDOExample;
import com.zc.acl.domain.model.Role;
import com.zc.acl.domain.model.converter.RoleConverter;
import com.zc.acl.domain.service.RoleDomainService;
import org.springframework.stereotype.Service;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/15 10:48 1.0.0
 */
@Service
public class RoleDomainServiceImpl implements RoleDomainService {

    @Resource
    private RoleDOMapper roleDOMapper;

    @Override
    public List<Role> queryAll() {
        RoleDOExample roleDOExample = new RoleDOExample();

        return RoleConverter.toDomainModels(roleDOMapper.selectByExample(roleDOExample));
    }

    @Override
    public List<Role> queryByIds(List<Long> roleIds) {
        RoleDOExample roleDOExample = new RoleDOExample();

        roleDOExample.createCriteria().andIdIn(roleIds);

        return RoleConverter.toDomainModels(roleDOMapper.selectByExample(roleDOExample));
    }
}
