/*Copyright 1999-2017. Alibaba.com All right reserved. This software is the
confidential and proprietary information of Alibaba.com ("Confidential
Information"). You shall not disclose such Confidential Information and shall
use it only in accordance with the terms of the license agreement you entered
into with Alibaba.com.*/

package com.zc.controller.dto;

/**
 * @author zixing.liangzx@alibaba-inc.com
 * @version 17/9/13 14:40 1.0.0
 */
public class AjaxResult<T> {

    public T data;

    public boolean success;

    public String errorCode;

    public String errorMsg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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


    public static <C> AjaxResult<C> success(C c){
        AjaxResult<C> result = new AjaxResult<C>();

        result.setSuccess(true);
        result.setData(c);

        return result;
    }


    public static <C> AjaxResult<C> unSuccess(String errorMsg){
        AjaxResult<C> result = new AjaxResult<C>();

        result.setSuccess(false);
        result.setErrorMsg(errorMsg);

        return result;
    }

    public static <C> AjaxResult<C> unSuccess(String errorMsg, String errorCode){
        AjaxResult<C> result = unSuccess(errorMsg);

        result.setErrorCode(errorCode);

        return result;
    }
}
