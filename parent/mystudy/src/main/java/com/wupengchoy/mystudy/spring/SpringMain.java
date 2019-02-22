package com.wupengchoy.mystudy.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("resource.xml");
        HelloBean helloBean = (HelloBean) context.getBean("helloBean");
        System.out.println(helloBean.getMessage());
    }
}
