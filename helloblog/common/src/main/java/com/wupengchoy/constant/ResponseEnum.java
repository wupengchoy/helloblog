package com.wupengchoy.constant;

/**
 * Created by Jeremy on 11/15/18.
 */
public enum ResponseEnum {
    SUCCESS(0, "SUCCESS"),
    UNKOWN_FAILED(1, "Unkown Failed");

    private Integer code;
    private String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
