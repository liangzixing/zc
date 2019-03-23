package com.zc.biz.logistics.domain.consts;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

public enum AbLocOrderStatusEnum {

    WAIT_LOC_COMPANY_PROCESS("等待物流公司处理"),

    WAIT_LOC_COMPANY_CONFIRM("等待物流公司确认"),

    WAIT_TP_CONFIRM("等待TP确认"),

    TP_CONFIRM_DONE("TP确认完成"),

    LOC_COMPANY_CONFIRM_DONE("物流公司确认完成");

    private String desc;

    AbLocOrderStatusEnum(String desc) {
        this.desc = desc;
    }

    public String desc() {
        return this.desc;
    }

    public static String getDesc(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        return Arrays.stream(AbLocOrderStatusEnum.values()).filter(s -> s.name().equalsIgnoreCase(code))
            .findFirst().map(AbLocOrderStatusEnum::desc).orElse(null);
    }

}
