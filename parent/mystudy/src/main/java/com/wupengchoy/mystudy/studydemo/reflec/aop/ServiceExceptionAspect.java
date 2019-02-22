package com.wupengchoy.mystudy.studydemo.reflec.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect(values = {ServiceB.class,ServiceA.class})
public class ServiceExceptionAspect {
    public static void exception(Object obj, Method method, Object[] args, Throwable e) {
        System.err.println("exception when calling: " + method.getName() + "," + Arrays.toString(args  ));
    }
}
