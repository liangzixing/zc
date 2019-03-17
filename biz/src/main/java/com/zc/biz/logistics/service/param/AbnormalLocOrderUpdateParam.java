package com.zc.biz.logistics.service.param;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AbnormalLocOrderUpdateParam {

    private Long id;

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

    private Long currentUserId;

    private String currentUserName;

}
