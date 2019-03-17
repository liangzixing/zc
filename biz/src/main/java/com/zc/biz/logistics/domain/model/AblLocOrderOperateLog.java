package com.zc.biz.logistics.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AblLocOrderOperateLog {

    private Long id;

    private Long abnormalOrderId;

    private Date gmtCreate;

    private Long userId;

    private String userName;

    private String statusBefore;

    private String statusAfter;

}
