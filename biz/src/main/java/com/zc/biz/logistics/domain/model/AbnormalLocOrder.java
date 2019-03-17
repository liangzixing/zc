package com.zc.biz.logistics.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

// 异常的物流单
@Getter
@Setter
public class AbnormalLocOrder {

    private Long id;

    private Date gmtCreate;

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

    // 等待物流公司确认 -- 废弃 --- 等待TP确认--- TP 已确认 --- 物流公司已确认
    private String orderStatus;

    // 附件--文件url
    private List<String> attachFileUrl;

    private String memo;
}
