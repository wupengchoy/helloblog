package com.wupengchoy.mystudy.studydemo.reflec.aop;

public class TestCGLib {
    public static void main(String[] args) {
        ServiceA serviceA = CGLibContainer.getInstance(ServiceA.class);
        serviceA.callB();
        System.out.println("====================");
        serviceA.createException(1);
    }
}
