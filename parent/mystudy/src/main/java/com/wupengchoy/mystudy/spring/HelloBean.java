package com.wupengchoy.mystudy.spring;

import lombok.Data;

@Data
public class HelloBean {
    private String message;
    public void setMessage(String message)
    {
        this.message = message;
    }
    public String getMessage()
    {
        return this.message;
    }
}
