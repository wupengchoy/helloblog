package com.wupengchoy.mystudy.studydemo.reflec.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect(values = {ServiceA.class, ServiceB.class})
public class ServiceLogAspect {
    public static void before(Object obj, Method method, Object[] args) {
        System.out.println("entering " + method.getDeclaringClass().getSimpleName() + "::" + method.getName() + "," + "args:" + Arrays.toString(args
        ));
    }

    public static void after(Object obj, Method method, Object[] args, Object result) {
        System.out.println("leaving " + method.getDeclaringClass().getSimpleName() + "::" + method.getName() + "," + "result:" +
                result);
    }
}
