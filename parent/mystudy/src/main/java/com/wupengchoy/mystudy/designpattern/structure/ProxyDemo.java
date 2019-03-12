package com.wupengchoy.mystudy.designpattern.structure;

/**
 * 代理模式：抽象主题，真实主题，代理类
 */
public class ProxyDemo {
    public static void main(String[] args) {
        ProxyObject proxy = new ProxyObject();
        proxy.say();
    }
}

interface ProxyInterface {
    void say();
}

class RealObject implements ProxyInterface {
    @Override
    public void say() {
        System.out.println("hello");
    }
}

class ProxyObject implements ProxyInterface {
    RealObject obj;
    @Override
    public void say() {
        if (obj == null) obj = new RealObject();
        preSay();
        obj.say();
        afterSay();
    }
    private void preSay() {
        System.out.println("proxy in...");
    }
    private void afterSay() {
        System.out.println("proxy out...");
    }
}
