package com.wupengchoy.mystudy.studydemo.reflec.aop;

public class TestInject {
    public static void main(String[] args) {
        ServiceA serviceA = SimpleInjectContainer.getInstance(ServiceA.class);
        serviceA.callB();

        //单例
        ServiceA a = SimpleInjectContainer.getSingleton(ServiceA.class);
        System.out.println(a.name);
        a.name = "a++";
        System.out.println(a.name);
        ServiceA a1 = SimpleInjectContainer.getSingleton(ServiceA.class);
        System.out.println(a1.name);
    }
}
