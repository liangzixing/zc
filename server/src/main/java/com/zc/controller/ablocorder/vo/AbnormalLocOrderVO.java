package com.zc.controller.ablocorder.vo;

import lombok.Getter;
import lombok.Setter;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import java.util.Date;

@Getter
@Setter
@ExcelTarget("AbnormalLocOrder")
public class AbnormalLocOrderVO {

    @Excel(name = "记录时间", orderNum = "1", exportFormat = "yyyy-MM-dd HH:mm:ss", width = 30)
    private Date gmtCreate;

    @Excel(name = "业务类型", orderNum = "2", width = 40)
    private String outBizType;

    @Excel(name = "订单号", orderNum = "3", width = 40)
    private String outBizOrderNO;

    @Excel(name = "物流公司", orderNum = "4", width = 40)
    private String outLocCompany;

    @Excel(name = "物流单号", orderNum = "5", width = 40)
    private String outLocOrderNO;

    @Excel(name = "紧急级别", orderNum = "6", width = 40)
    private String urgencyLevel;

    @Excel(name = "客户收件信息", orderNum = "7", width = 40)
    private String consumerReceiveInfo;

    @Excel(name = "录入人", orderNum = "8", width = 40)
    private String inputReporter;

    @Excel(name = "异常类型", orderNum = "9", width = 40)
    private String abnormalType;

    @Excel(name = "异常信息", orderNum = "10", width = 40)
    private String abnormalInfo;

    @Excel(name = "处理人", orderNum = "11", width = 40)
    private String processor;

    @Excel(name = "处理结果", orderNum = "12", width = 40)
    private String processResult;

    // 等待物流公司确认 -- 废弃 --- 等待TP确认--- TP 已确认 --- 物流公司已确认
    @Excel(name = "单据状态", orderNum = "13", width = 40)
    private String orderStatus;

    @Excel(name = "备注", orderNum = "14", width = 40)
    private String memo;

}
