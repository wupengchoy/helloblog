package com.wupengchoy.mystudy.studydemo.classloader;

public class Foo {
    static {
        System.out.println("static...");
    }

    public void sayHello() {
        System.out.println(this.getClass());
    }
}
