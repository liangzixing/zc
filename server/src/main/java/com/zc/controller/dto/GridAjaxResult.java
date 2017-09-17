/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.dto;

import java.util.List;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/14 10:40 1.0.0
 */
public class GridAjaxResult<T> {

    protected boolean success;

    protected String errorCode;

    protected String errorMsg;

    protected long total;

    protected List<T> rows;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public static <C> GridAjaxResult<C> success(long total, List<C> rows) {
        GridAjaxResult<C> result = new GridAjaxResult<C>();

        result.setSuccess(true);
        result.setTotal(total);
        result.setRows(rows);

        return result;
    }

    public static <C> GridAjaxResult<C> unSuccess(String errorMsg) {
        GridAjaxResult<C> result = new GridAjaxResult<C>();
        result.setSuccess(false);
        result.setErrorMsg(errorMsg);
        return result;
    }

    public static <C> GridAjaxResult<C> unSuccess(String errorMsg, String errorCode) {
        GridAjaxResult<C> result = unSuccess(errorMsg);
        result.setErrorCode(errorCode);
        return result;
    }
}
