package com.zc.controller.ablocorder.param;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AbLocOrderCreateParamVO {

    private String outBizOrderNO;

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

    private String orderStatus;

}
