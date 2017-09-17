/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.acl.domain.service;

import com.zc.acl.domain.model.Role;
import java.util.List;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/15 10:48 1.0.0
 */
public interface RoleDomainService {

    List<Role> queryAll();

    List<Role> queryByIds(List<Integer> roleIds);
}
