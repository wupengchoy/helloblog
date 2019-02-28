package com.wupengchoy.mystudy.studydemo.classloader;

import java.util.Properties;

public class ConfigClassLoaderDemo {
    public static void main(String[] args) {
        //通过配置文件动态实现接口--策略模式
        try {
            Properties properties = new Properties();
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("classloadservice.properties"));
            String fileName = properties.getProperty("service");
            IService service = (IService) Class.forName(fileName).newInstance();
            service.sayHello();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public interface IService {
        void sayHello();
    }


    public static class ServiceA implements IService {
        public void sayHello() {
            System.out.println(this.getClass());
        }
    }

    public static class ServiceB implements IService {
        static
        {
            System.out.println(11);
        }
        public void sayHello() {
            System.out.println(this.getClass());
        }
    }
}
