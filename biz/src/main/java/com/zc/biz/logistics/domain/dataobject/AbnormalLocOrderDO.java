package com.zc.biz.logistics.domain.dataobject;

import com.zc.dataobject.CommonDO;

public class AbnormalLocOrderDO extends CommonDO {

    private String reporter;

    private String outBizType;

    private String outBizOrderNo;

    private String outLocCompany;

    private String outLocOrderNo;

    private String urgencyLevel;

    private String abnormalType;

    private String abnormalInfo;

    private String consumerReceiveInfo;

    private String processor;

    private String processResult;

    private String orderStatus;

    private String attachFileUrls;

    private String memo;

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter == null ? null : reporter.trim();
    }

    public String getOutBizType() {
        return outBizType;
    }

    public void setOutBizType(String outBizType) {
        this.outBizType = outBizType == null ? null : outBizType.trim();
    }

    public String getOutBizOrderNo() {
        return outBizOrderNo;
    }

    public void setOutBizOrderNo(String outBizOrderNo) {
        this.outBizOrderNo = outBizOrderNo == null ? null : outBizOrderNo.trim();
    }

    public String getOutLocCompany() {
        return outLocCompany;
    }

    public void setOutLocCompany(String outLocCompany) {
        this.outLocCompany = outLocCompany == null ? null : outLocCompany.trim();
    }

    public String getOutLocOrderNo() {
        return outLocOrderNo;
    }

    public void setOutLocOrderNo(String outLocOrderNo) {
        this.outLocOrderNo = outLocOrderNo == null ? null : outLocOrderNo.trim();
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel == null ? null : urgencyLevel.trim();
    }

    public String getAbnormalType() {
        return abnormalType;
    }

    public void setAbnormalType(String abnormalType) {
        this.abnormalType = abnormalType == null ? null : abnormalType.trim();
    }

    public String getAbnormalInfo() {
        return abnormalInfo;
    }

    public void setAbnormalInfo(String abnormalInfo) {
        this.abnormalInfo = abnormalInfo == null ? null : abnormalInfo.trim();
    }

    public String getConsumerReceiveInfo() {
        return consumerReceiveInfo;
    }

    public void setConsumerReceiveInfo(String consumerReceiveInfo) {
        this.consumerReceiveInfo = consumerReceiveInfo == null ? null : consumerReceiveInfo.trim();
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor == null ? null : processor.trim();
    }

    public String getProcessResult() {
        return processResult;
    }

    public void setProcessResult(String processResult) {
        this.processResult = processResult == null ? null : processResult.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getAttachFileUrls() {
        return attachFileUrls;
    }

    public void setAttachFileUrls(String attachFileUrls) {
        this.attachFileUrls = attachFileUrls == null ? null : attachFileUrls.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}