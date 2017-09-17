/*Copyright 1999-2015. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 15/9/7 1.0.0
 */
public class MapUtils {

    public static boolean isBlank(Map<?, ?> map){
        return map == null || map.isEmpty();
    }

    public static boolean isNotBlank(Map<?, ?> map){
        return !isBlank(map);
    }

    public static <K, V> HashMap<K,V> newHashMap(){
        return new HashMap<K,V>();
    }

    public static boolean isSizeEqual(Map<?, ?> map, int size){

        if (isBlank(map) || size < 0) {
            return false;
        }

        return map.size() == size;
    }


}
