/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.acl.domain.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.zc.acl.domain.dao.RoleDOMapper;
import com.zc.acl.domain.dao.UserDOMapper;
import com.zc.acl.domain.dao.UserRoleRelationDOMapper;
import com.zc.acl.domain.dataobject.RoleDO;
import com.zc.acl.domain.dataobject.RoleDOExample;
import com.zc.acl.domain.dataobject.UserDO;
import com.zc.acl.domain.dataobject.UserDOExample;
import com.zc.acl.domain.dataobject.UserRoleRelationDO;
import com.zc.acl.domain.dataobject.UserRoleRelationDOExample;
import com.zc.acl.domain.model.Role;
import com.zc.acl.domain.model.User;
import com.zc.acl.domain.model.converter.UserConverter;
import com.zc.acl.domain.model.converter.UserRoleRelationConverter;
import com.zc.acl.domain.service.UserDomainService;
import com.zc.dataobject.DataObjectUtil;
import com.zc.exception.BusinessException;
import com.zc.result.PagedResult;
import com.zc.utils.ListUtil;
import com.zc.utils.NumberUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/12 17:20 1.0.0
 */
@Service
public class UserDomainServiceImpl implements UserDomainService {

    @Resource
    private UserDOMapper userDOMapper;

    @Resource
    private RoleDOMapper roleDOMapper;

    @Resource
    private UserRoleRelationDOMapper userRoleRelationDOMapper;

    @Override
    public User getByUserName(String userName) {
        if (StringUtil.isEmpty(userName)){
            return null;
        }

        UserDOExample userDOExample = new UserDOExample();

        userDOExample.createCriteria().andNameEqualTo(userName).andIsDeletedEqualTo("n");

        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);

        User user = UserConverter.toDomainModel(ListUtil.first(userDOS));

        fillRoleInfo(user);

        return user;
    }

    @Override
    public User getById(int id) {

        if (NumberUtil.isNotPositive(id)){
            return null;
        }

        UserDOExample userDOExample = new UserDOExample();

        userDOExample.createCriteria().andIdEqualTo(id).andIsDeletedEqualTo("n");

        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);

        User user = UserConverter.toDomainModel(ListUtil.first(userDOS));

        fillRoleInfo(user);

        return user;
    }

    @Override
    public List<User> getByIds(List<Integer> ids) {

        if(ListUtil.isBlank(ids)){
            return Collections.emptyList();
        }

        List<User> users =  getSimpleUserByIds(ids);

        fillRoleInfo(users);

        return users;
    }

    @Override
    public List<User> getSimpleUserByIds(List<Integer> ids) {

        if(ListUtil.isBlank(ids)){
            return Collections.emptyList();
        }

        UserDOExample userDOExample = new UserDOExample();

        userDOExample.createCriteria().andIdIn(ids).andIsDeletedEqualTo("n");

        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);

        List<User> users =  UserConverter.toDomainModels(userDOS);

        return users;
    }

    public void fillRoleInfo(User user) {
        if (user == null || NumberUtil.isNotPositive(user.getId())) {
            return;
        }

        fillRoleInfo(Arrays.asList(user));
    }

    public void fillRoleInfo(List<User> users) {
        if (ListUtil.isBlank(users)) {
            return;
        }

        UserRoleRelationDOExample userRoleRelationDOExample = new UserRoleRelationDOExample();

        userRoleRelationDOExample.createCriteria()
            .andUserIdIn(ListUtil.collect(users, User::getId))
            .andIsDeletedEqualTo("n");

        List<UserRoleRelationDO> userRoleRelationDOS = userRoleRelationDOMapper
            .selectByExample(userRoleRelationDOExample);

        if (ListUtil.isBlank(userRoleRelationDOS)) {
            return;
        }

        List<Integer> roleIds = ListUtil.collectWithOutRepeat(userRoleRelationDOS, o -> o.getRoleId());

        if (ListUtil.isBlank(roleIds)) {
            return;
        }

        RoleDOExample roleDOExample = new RoleDOExample();
        roleDOExample.createCriteria().andIdIn(roleIds).andIsDeletedEqualTo("n");

        List<RoleDO> roleDOS = roleDOMapper.selectByExample(roleDOExample);

        if (ListUtil.isBlank(roleDOS)) {
            return;
        }

        Map<Integer, List<UserRoleRelationDO>> userIdToRelations = ListUtil
            .splitByKey(userRoleRelationDOS, r -> r.getUserId());

        Map<Integer, RoleDO> roleIdToRole = ListUtil.toMap(roleDOS, r -> r.getId());

        users.parallelStream().forEach(x -> fillRoleInfo(x, userIdToRelations.get(x.getId()), roleIdToRole));

    }

    private void fillRoleInfo(User user, List<UserRoleRelationDO> userRoleRelationDOS,
                              Map<Integer, RoleDO> roleIdToRole) {
        user.setRoles(UserRoleRelationConverter.toRole(userRoleRelationDOS, roleIdToRole));
    }

    @Override
    public List<User> querySimpleBy(User user, int currentPage, int pageSize) {

        UserDOExample userDOExample = new UserDOExample();

        userDOExample.setOrderByClause("gmt_create desc");

        userDOExample.createCriteria().andIsDeletedEqualTo("n");

        if (!StringUtils.isEmpty(user.getUsername())) {
            userDOExample.getOredCriteria().get(0).andNameLike("%" + user.getUsername() + "%");
        }

        if (!StringUtils.isEmpty(user.getMobile())) {
            userDOExample.getOredCriteria().get(0).andMobileLike(user.getMobile() + "%");
        }

        PageHelper.startPage(currentPage, pageSize, false);

        Page<UserDO> userDOS = userDOMapper.findByPage(userDOExample);

        List<User> users = UserConverter.toDomainModels(userDOS);

        return users;
    }

    @Override
    public PagedResult<User> pagedQuery(User user, int currentPage, int pageSize) {

        UserDOExample userDOExample = new UserDOExample();

        userDOExample.setOrderByClause("gmt_create desc");

        userDOExample.createCriteria().andIsDeletedEqualTo("n");

        if (!StringUtils.isEmpty(user.getUsername())) {
            userDOExample.createCriteria().andNameLike("%" + user.getUsername() + "%");
        }

        if (!StringUtils.isEmpty(user.getMobile())) {
            userDOExample.createCriteria().andMobileLike(user.getMobile() + "%");
        }

        PageHelper.startPage(currentPage, pageSize, true);

        Page<UserDO> userDOS = userDOMapper.findByPage(userDOExample);

        List<User> users = UserConverter.toDomainModels(userDOS);

        fillRoleInfo(users);

        return PagedResult.success(userDOS.getTotal(), users);
    }

    @Override
    public int insert(User user, String operator) {

        if (getByUserName(user.getUsername()) != null) {
            throw new BusinessException("101", "the user with same name already exist");
        }

        UserDO userDO = UserConverter.toDO(user);

        DataObjectUtil.beforeInsert(userDO, operator);

        userDOMapper.insert(userDO);

        int userId = userDO.getId();

        if (ListUtil.isNotBlank(user.getRoles())) {
            insertUserRoleRelations(userId, user.getRoles(), operator);
        }

        return userId;
    }

    private void insertUserRoleRelations(int userId, List<Role> roles, String operator) {

        List<UserRoleRelationDO> userRoleRelationDOS = UserRoleRelationConverter.toDOS(userId, roles);

        if (ListUtil.isBlank(userRoleRelationDOS)) {
            return;
        }

        userRoleRelationDOS.parallelStream().forEach(ur -> DataObjectUtil.beforeInsert(ur, operator));

        userRoleRelationDOMapper.insertBatch(userRoleRelationDOS);
    }

    @Override
    public int update(User user, String operator) {
        if (NumberUtil.isNotPositive(user.getId())) {
            return 0;
        }

        UserDOExample updateExample = new UserDOExample();

        updateExample.createCriteria().andIdEqualTo(user.getId());

        updateRoles(user, operator);

        UserDO userDO = UserConverter.toDO(user);

        DataObjectUtil.beforeUpdate(userDO, operator);

        return userDOMapper.updateByExampleSelective(userDO, updateExample);
    }

    private void updateRoles(User user, String operator) {
        if (user.getRoles() == null) {
            return;
        }

        UserRoleRelationDOExample userRoleRelationDOExample = new UserRoleRelationDOExample();

        userRoleRelationDOExample.createCriteria()
            .andUserIdEqualTo(user.getId());

        List<UserRoleRelationDO> oldRelations = userRoleRelationDOMapper
            .selectByExample(userRoleRelationDOExample);

        List<UserRoleRelationDO> newRelations = UserRoleRelationConverter
            .toDOS(user.getId(), user.getRoles());

        List<UserRoleRelationDO> oldIgnoreRelations = new ArrayList<>();
        List<UserRoleRelationDO> newIgnoreRelations = new ArrayList<>();

        if (ListUtil.isNotBlank(oldRelations)){
            oldRelations.forEach(or -> {
                newRelations.forEach(nr -> {
                    if (or.getRoleId().equals(nr.getRoleId())) {
                        oldIgnoreRelations.add(or);
                        newIgnoreRelations.add(nr);
                    }
                });
            });
        }

        // need insert
        newRelations.removeAll(newIgnoreRelations);
        if (ListUtil.isNotBlank(newRelations)) {
            newRelations.forEach(x -> DataObjectUtil.beforeInsert(x, operator));
            userRoleRelationDOMapper.insertBatch(newRelations);
        }

        // need delete
        oldRelations.removeAll(oldIgnoreRelations);
        if (ListUtil.isNotBlank(oldRelations)) {
            UserRoleRelationDOExample deleteExample = new UserRoleRelationDOExample();
            deleteExample.createCriteria().andIdIn(ListUtil.collect(oldRelations, UserRoleRelationDO::getId));
            userRoleRelationDOMapper.deleteByExample(deleteExample);
        }
    }

    @Override
    public int resetPassword(int userId, String oldPassword, String newPassword, String operator) {
        if (NumberUtil.isNotPositive(userId)) {
            return 0;
        }

        return updateByExample(
            s -> s.createCriteria()
                .andIdEqualTo(userId)
                .andPasswordEqualTo(oldPassword),
            o -> o.setPassword(newPassword),
            operator);
    }

    public int updateByExample(Consumer<UserDOExample> searcher, Consumer<UserDO> updater, String operator) {

        UserDOExample updateExample = new UserDOExample();

        searcher.accept(updateExample);

        UserDO userDO = new UserDO();

        updater.accept(userDO);

        DataObjectUtil.beforeUpdate(userDO, operator);

        return userDOMapper.updateByExampleSelective(userDO, updateExample);
    }

    @Override
    public boolean delete(int id, String operator) {
        if (NumberUtil.isNotPositive(id)) {
            return false;
        }

        boolean deleteResult = updateByExample(
            s -> s.createCriteria()
                .andIdEqualTo(id),
            o -> o.setIsDeleted("y"),
            operator) > 0;

        UserRoleRelationDOExample example = new UserRoleRelationDOExample();

        example.createCriteria().andUserIdEqualTo(id);

        UserRoleRelationDO updateParam = new UserRoleRelationDO();

        updateParam.setIsDeleted("y");
        DataObjectUtil.beforeUpdate(updateParam, operator);

        userRoleRelationDOMapper.updateByExampleSelective(updateParam, example);

        return deleteResult;
    }
}
