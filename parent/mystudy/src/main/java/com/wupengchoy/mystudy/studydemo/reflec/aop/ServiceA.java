package com.wupengchoy.mystudy.studydemo.reflec.aop;

import lombok.Data;

@Data
@SimpleSingleton
public class ServiceA {
    @SimpleInject
    private ServiceB serviceB;

    public String name = "A";

    public void sayHello() {
        System.out.println("hello I am serviceA");
    }

    public void callB() {
        serviceB.sayHello();
    }

    public void createException( int i)
    {
        int a = 1/0;
    }
}
