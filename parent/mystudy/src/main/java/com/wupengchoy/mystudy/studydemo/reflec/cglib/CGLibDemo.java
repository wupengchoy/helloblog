package com.wupengchoy.mystudy.studydemo.reflec.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 通过cglib实现动态代理
 */
public class CGLibDemo {
    /**
     * 被代理的真实对象
     */
    static class RealService {
        int j = 0;

        public void sayHello(int i) {
            System.out.println("hello realservice!" + i + j);
        }
    }

    static class SimpleInterceptor implements MethodInterceptor {

        public Object getProxy(Class cl) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(cl);
            //代理对象
            enhancer.setCallback(this);

            return enhancer.create();
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("MethodInterceptor in....");

            Object result = methodProxy.invokeSuper(o, objects);

            System.out.println("MethodInterceptor out...");
            return result;
        }
    }

    public static void main(String[] args) {

        RealService service = (RealService) new SimpleInterceptor().getProxy(RealService.class);
        //创建对象后可以设置代理对象属性，用来代替原对象
        service.j = 99;
        service.sayHello(22);
    }
}
