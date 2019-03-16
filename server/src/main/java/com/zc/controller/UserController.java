/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.zc.acl.domain.model.User;
import com.zc.acl.domain.service.UserDomainService;
import com.zc.acl.service.UserService;
import com.zc.acl.service.param.UserQueryParam;
import com.zc.controller.dto.AjaxResult;
import com.zc.controller.dto.GridAjaxResult;
import com.zc.controller.dto.UserDTO;
import com.zc.controller.dto.converter.UserDTOConverter;
import com.zc.controller.param.UserEditDTO;
import com.zc.controller.param.UserQueryCondition;
import com.zc.result.PagedResult;
import com.zc.utils.NumberUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/13 14:36 1.0.0
 */
@Controller
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @Resource
    private UserDomainService userDomainService;

    @RequestMapping("/user/list")
    public String list() {
        return "user/list";
    }

    @ResponseBody
    @RequestMapping("/user/queryById")
    public UserDTO queryById(Integer id) {
        return UserDTOConverter.toDTO(userService.getById(id));
    }

    @ResponseBody
    @RequestMapping("/user/queryUsers")
    public GridAjaxResult<UserDTO> queryUsers(UserQueryCondition userQueryCondition) {

        UserQueryParam userQueryParam = new UserQueryParam();

        if (userQueryCondition != null) {

            if (StringUtils.isNotBlank(userQueryCondition.getQueryString())) {
                if (NumberUtils.isNumber(userQueryCondition.getQueryString())) {
                    userQueryParam.setMobile(userQueryCondition.getQueryString());
                } else {
                    userQueryParam.setUsername(userQueryCondition.getQueryString());
                }
            }

            userQueryParam.setCurrentPage(NumberUtil.toPositive(userQueryCondition.getCurrentPage()));
            userQueryParam.setPageSize(NumberUtil.toPositive(userQueryCondition.getPageSize(), 10));
        }

        PagedResult<User> users = userService.pagedQuery(userQueryParam);

        List<UserDTO> userDTOS = UserDTOConverter.toDTOs(users.getData());

        return GridAjaxResult.success(users.getTotal(), userDTOS);
    }

    @ResponseBody
    @RequestMapping("/user/querySimple")
    public List<UserDTO> querySimple(UserQueryCondition userQueryCondition) {

        User user = new User();

        if (StringUtils.isNotBlank(userQueryCondition.getQueryString())) {
            if (NumberUtils.isNumber(userQueryCondition.getQueryString())) {
                user.setMobile(userQueryCondition.getQueryString());
            } else {
                user.setUsername(userQueryCondition.getQueryString());
            }
        }

        List<User> users = userDomainService.querySimpleBy(user,
            userQueryCondition.getCurrentPage(), userQueryCondition.getPageSize());

        List<UserDTO> userDTOS = UserDTOConverter.toDTOs(users);

        return userDTOS;
    }

    @ResponseBody
    @RequestMapping("/user/add")
    public AjaxResult<Boolean> add(@Valid UserEditDTO userEditDTO, BindingResult bindingResult) {
        User user = new User();

        user.setUsername(userEditDTO.getUserName());
        user.setMobile(userEditDTO.getMobile());

        long id = userService.insert(user, userEditDTO.getRoleIds(), getLoginUserName());

        if (id > 0) {
            return AjaxResult.success(true);
        }

        return AjaxResult.unSuccess("system busy! try again!");
    }

    @ResponseBody
    @RequestMapping("/user/edit")
    public AjaxResult<Boolean> edit(@Valid UserEditDTO userEditDTO, BindingResult bindingResult) {
        if (userEditDTO == null || NumberUtil.isNotPositive(userEditDTO.getId())) {
            return AjaxResult.unSuccess("ILLEGAL PARAM");
        }

        User user = new User();

        user.setId(userEditDTO.getId());
        user.setUsername(userEditDTO.getUserName());
        user.setMobile(userEditDTO.getMobile());

        int updateRecordNum = userService.update(user, userEditDTO.getRoleIds(), getLoginUserName());

        if (updateRecordNum > 0) {
            return AjaxResult.success(true);
        }

        return AjaxResult.unSuccess("system busy! try again!");
    }

    @ResponseBody
    @RequestMapping("/user/resetPassWord")
    public AjaxResult<Boolean> resetPassWord(Integer id, String oldPassword, String newPassword) {
        if (NumberUtil.isNotPositive(id) || StringUtils.isBlank(oldPassword)) {
            return AjaxResult.unSuccess("ILLEGAL PARAM");
        }

        boolean result = userService.resetPassword(id, oldPassword, newPassword, getLoginUserName());

        //expireNow();

        return AjaxResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/user/resetPassWordForAdmin")
    public AjaxResult<Boolean> resetPassWordForAdmin(Integer id) {
        if (NumberUtil.isNotPositive(id)) {
            return AjaxResult.unSuccess("ILLEGAL PARAM");
        }

        boolean result = userService.resetPasswordForAdmin(id, getLoginUserName());

        return AjaxResult.success(result);
    }

    @ResponseBody
    @RequestMapping("/user/delete")
    public AjaxResult<Boolean> deleteUser(Integer id) {
        if (NumberUtil.isNotPositive(id)) {
            return AjaxResult.unSuccess("ILLEGAL PARAM");
        }

        boolean result = userDomainService.delete(id, getLoginUserName());

        return AjaxResult.success(result);

    }
}
