/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.biz.customer.service;

import com.zc.biz.customer.domain.model.CustomerTally;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/17 14:11 1.0.0
 */
public interface CustomerTallyService {

    long insert(CustomerTally customerTally, String operator);

}
