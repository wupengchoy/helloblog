package com.wupengchoy.mystudy.studydemo.classloader;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        //双亲委派
//        try {
//            System.out.println("双亲委派机制");
//            Foo foo = Foo.class.newInstance();
//            ClassLoader cl = foo.getClass().getClassLoader();
//            while (true) {
//                if (cl != null) {
//                    System.out.println(cl.getClass().getName());
//                    cl = cl.getParent();
//                    continue;
//                }
//                System.out.println(cl);
//                break;
//            }
//        } catch (Exception e1) {
//            System.out.println("出错啦");
//        }
//
//        //默认加载器
//        try {
//            System.out.println("默认加载器");
//            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//            System.out.println(classLoader);
//            Class clz = classLoader.loadClass("java.lang.String");
//            System.out.println(clz.getClassLoader());
//        } catch (Exception e) {
//            System.out.println("出错啦");
//        }

        //forName方法
//        System.out.println("forName()方法");
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            Class clz = classLoader.loadClass("com.wupengchoy.mystudy.studydemo.classloader.Foo");

//            Class.forName("com.wupengchoy.mystudy.studydemo.classloader.Foo");
//            Class.forName("com.wupengchoy.mystudy.studydemo.classloader.Foo", true, ClassLoader.getSystemClassLoader());
//            Class.forName("com.wupengchoy.mystudy.studydemo.classloader.Foo", false, ClassLoader.getSystemClassLoader());
        } catch (Exception e) {
            System.out.println("出错啦");
        }
    }
}
