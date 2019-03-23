package com.zc.biz.logistics.domain.consts;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

public enum AbLocOrderTypeEnum {

    OVER_AREA("超区"),
    URGE_SEND("催派"),
    CHANGE_ADDRESS("改址"),
    CALL_BACK("退回/召回"),
    GOODS_LOST("丢失"),
    GOODS_NO_ENOUGH("少发/错发"),
    CONSUMER_ABNORMAL("收货客户异常"),
    UN_RECEIVE_BUT_RECORD("签收未收"),
    OTHER("其他");

    private String desc;

    AbLocOrderTypeEnum(String desc) {
        this.desc = desc;
    }

    public String desc() {
        return this.desc;
    }

    public static String getDesc(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        return Arrays.stream(AbLocOrderTypeEnum.values()).filter(s -> s.name().equalsIgnoreCase(code))
            .findFirst().map(AbLocOrderTypeEnum::desc).orElse(null);
    }

}
