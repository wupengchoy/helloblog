package com.wupengchoy.mystudy.studydemo.reflec.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvokeService implements InvocationHandler {
    private Object realObj;
    public InvokeService(Object obj)
    {
        this.realObj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("InvocationHandler in....");

        //需要时真是的对象realObject
        method.invoke(realObj,args);

        System.out.println("InvocationHandler out...");
        return method;
    }
}
