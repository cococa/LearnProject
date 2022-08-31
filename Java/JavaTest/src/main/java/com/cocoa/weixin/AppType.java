package com.cocoa.weixin;

import java.util.Arrays;

public enum AppType {

    TYPE_SUBSCRIBE((byte) 1, "订阅号"),
    TYPE_SERVICE((byte) 2, "服务号"),
    TYPE_MINI((byte) 3, "小程序");


    private Byte code;
    private String msg;

    AppType(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static AppType getAppType(Byte code) {
        return Arrays.stream(AppType.values()).filter(status -> status.code == code).findFirst().orElse(null);
    }

    public static AppType getAppTypeByDefault(Byte code) {
        return Arrays.stream(AppType.values()).filter(status -> status.code == code).findFirst().orElse(TYPE_MINI);
    }


    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
