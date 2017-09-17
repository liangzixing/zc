/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.param;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/14 10:51 1.0.0
 */
public class PageQueryCondition {

    /**
     * 从 1 开始
     */
    protected int currentPage = 1;


    protected int pageSize = 20;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
