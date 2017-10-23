/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.biz.customer.domain.service;

import java.util.List;
import com.zc.biz.customer.domain.model.CustomerTally;
import com.zc.biz.customer.domain.service.param.CustomerTallyQueryCondition;
import com.zc.result.PagedResult;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/17 14:10 1.0.0
 */
public interface CustomerTallyDomainService {

    PagedResult<CustomerTally> pagedQuery(CustomerTallyQueryCondition customerTallyQueryCondition);

    List<CustomerTally> query(CustomerTallyQueryCondition CustomerTallyQueryCondition);

    CustomerTally queryById(Integer id);

    int insert(CustomerTally customerTally, String operator);

    int update(CustomerTally customerTally, String operator);

    int hide(int id, String operator);

}
