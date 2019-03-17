package com.zc.biz.logistics.service.param;

import com.zc.param.PageParam;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AbnormalLocOrderQueryParam extends PageParam {

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

    private Date createDateBegin;

    private Date createDateEnd;
}
