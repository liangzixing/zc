/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.acl.domain.service;

import java.util.List;
import com.zc.acl.domain.model.User;
import com.zc.result.PagedResult;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/12 17:17 1.0.0
 */
public interface UserDomainService {

    User getByUserName(String userName);

    User getById(int id);

    List<User> getByIds(List<Integer> ids);

    List<User> getSimpleUserByIds(List<Integer> ids);

    List<User> querySimpleBy(User user, int currentPage, int pageSize);

    PagedResult<User> pagedQuery(User user, int currentPage, int pageSize);

    int insert(User user, String operator);

    int update(User user, String operator);

    int resetPassword(int userId, String oldPassword, String newPassword, String operator);

    boolean delete(int id, String operator);
}
