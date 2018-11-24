package com.wupengchoy.enumeration;

/**
 * 请求返回信息枚举类型
 * Created by Jeremy on 11/22/18.
 */
public enum ResponseEnum {
    SUCCESS(0, "success"),//成功
    FAILED(1, "failed");//失败


    private int code;
    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
