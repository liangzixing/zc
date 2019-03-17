package com.zc.biz.logistics.service.param;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AbnormalLocOrderCreateParam {

    private String outBizType;

    private String outBizOrderNO;

    private String outLocCompany;

    private String outLocOrderNO;

    private String urgencyLevel;

    private String consumerReceiveInfo;

    private String inputReporter;

    private String abnormalType;

    private String abnormalInfo;

    private String processor;

    private String processResult;

    // 附件--文件url
    private List<String> attachFileUrl;

    private String memo;

    private Long operatorId;

    private String operatorName;

    private String orderStatus;

}
