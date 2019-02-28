package com.wupengchoy.mystudy.studydemo.classloader;

public class MyClassLoaderTest {
    public static void main(String[] args) {
        try {
            MyClassLoader loader1 = new MyClassLoader();
            Class f1 = loader1.findClass(Foo.class.getName());
            System.out.println(f1);

            MyClassLoader loader2 = new MyClassLoader();
            Class f2 = loader2.findClass(Foo.class.getName());
            System.out.println(f2);
            System.out.println(f1 == f2);

        } catch (Exception e) {
            System.out.println("出错啦");
        }
    }
}
