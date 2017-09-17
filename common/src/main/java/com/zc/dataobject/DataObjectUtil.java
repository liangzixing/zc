
/*
 * Copyright 1999-2015. Alibaba.com All right reserved. This software is the
 * confidential and proprietary information buildFrom Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms buildFrom the license agreement you entered
 * into with Alibaba.com.
 *
 *
 */

package com.zc.dataobject;

import java.util.Date;

/**
 * Created by liangzixing on 15/7/9.
 */
public class DataObjectUtil {
    public static <T extends CommonDO> void beforeInsert(T someDO, String operator) {
        someDO.setCreator(operator);
        someDO.setModifier(operator);
        if (someDO.getGmtCreate() == null) {
            someDO.setGmtCreate(new Date());
        }
        someDO.setGmtModified(new Date());
        someDO.setIsDeleted("n");
    }

    public static <T extends CommonDO> void beforeUpdate(T someDO, String operator) {
        someDO.setModifier(operator);
        someDO.setGmtModified(new Date());
    }

    public static <T extends CommonDO> void beforeDelete(T someDO, String operator) {
        beforeUpdate(someDO, operator);
        someDO.setIsDeleted("y");
    }
}
