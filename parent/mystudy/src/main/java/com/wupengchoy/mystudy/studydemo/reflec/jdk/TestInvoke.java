package com.wupengchoy.mystudy.studydemo.reflec.jdk;

import java.lang.reflect.Proxy;

/**
 * 通过JavaJDK实现动态代理
 */
public class TestInvoke {
    public static void main(String[] args) {
        IHelloService service = new HelloService();
        InvokeService invoke = new InvokeService(service);

        //必须转换成接口类型，与cglib不同，cglib可以代理类
        IHelloService proxy = (IHelloService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), invoke);
        proxy.sayHello();
    }
}
