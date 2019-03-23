package com.zc.controller.ablocorder.param;

import com.zc.param.PageParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbLocOrderQueryParamVO extends PageParam {

    private String outBizOrderNO;

    private String outLocOrderNO;

    private String urgencyLevel;

    private String consumerReceiveInfo;

    private String inputReporter;

    private String abnormalType;

    private String abnormalInfo;

    private String processor;

    private String processResult;

    private String memo;

    private Long createDateBegin;

    private Long createDateEnd;

    private String orderStatus;
}
