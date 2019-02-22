package com.wupengchoy.mystudy.studydemo.reflec.aop;

import lombok.Data;

@SimpleSingleton
@Data
public class ServiceB {
    public String name = "B";
    public void sayHello()
    {
        System.out.println("hello I am serviceB");
    }
}
