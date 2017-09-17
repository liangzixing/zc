/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.acl.service;

import com.zc.acl.domain.model.User;
import com.zc.acl.service.param.UserQueryParam;
import com.zc.result.PagedResult;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/8/31 16:24 1.0.0
 */
public interface UserService{

    User getByName(String username);

    User getById(int id);

    int insert(User user, Integer[] roleIds, String operator);

    int update(User user, Integer[] roleIds, String operator);

    boolean resetPassword(int id, String oldPassword, String newPassword, String operator);

    boolean resetPasswordForAdmin(int id, String operator);

    PagedResult<User> pagedQuery(UserQueryParam userQueryParam);


}
