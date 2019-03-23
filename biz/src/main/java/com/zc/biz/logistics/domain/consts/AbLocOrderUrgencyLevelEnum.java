package com.zc.biz.logistics.domain.consts;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

public enum AbLocOrderUrgencyLevelEnum {

    NORMAL("一般"),
    URGENCY("紧急"),
    VERY_URGENCY("非常紧急");

    private String desc;

    AbLocOrderUrgencyLevelEnum(String desc) {
        this.desc = desc;
    }

    public String desc() {
        return this.desc;
    }

    public static String getDesc(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        return Arrays.stream(AbLocOrderUrgencyLevelEnum.values()).filter(s -> s.name().equalsIgnoreCase(code))
            .findFirst().map(AbLocOrderUrgencyLevelEnum::desc).orElse(null);
    }

}
