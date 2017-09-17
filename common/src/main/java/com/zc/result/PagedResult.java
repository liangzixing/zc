/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.result;

import java.util.List;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/14 14:16 1.0.0
 */
public class PagedResult<T> {

    protected List<T> data;

    protected long total;

    protected boolean isSuccess = true;

    protected String errorCode;

    protected String errorMsg;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
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

    public static <C> PagedResult<C> success(long total, List<C> data){
        PagedResult<C> result = new PagedResult<C>();

        result.setSuccess(true);
        result.setTotal(total);
        result.setData(data);

        return result;
    }
}
