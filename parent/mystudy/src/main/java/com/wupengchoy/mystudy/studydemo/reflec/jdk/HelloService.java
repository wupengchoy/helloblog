package com.wupengchoy.mystudy.studydemo.reflec.jdk;

public class HelloService implements IHelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello Service");
    }
}
