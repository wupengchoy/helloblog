package com.wupengchoy.mystudy.studydemo.classloader;

import java.io.File;

public class HotDeployTest {
    static IHotDeployBean hotDeployBean;

    public static void main(String[] args) {
        //创建一个client
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    hotDeployBean = getInstance();
                    while (true) {
                        hotDeployBean.sayHello();
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    System.out.println("出错啦！！");
                }
            }
        });
        t1.start();
        //检测文件是否修改
        Thread t2 = new Thread() {
            private String fileName = "/Users/Jeremy/Documents/Code/parent/mystudy/target/classes/com/wupengchoy/mystudy/studydemo/classloader/HotDeployBean.class";
            private long lastModified = new File(fileName).lastModified();

            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        long now = new File(fileName).lastModified();
                        System.out.println(now);
                        if (now != lastModified) {
                            reload();
                        }
                        lastModified = now;
                    }
                } catch (Exception e) {
                    System.out.println("出错啦！！");
                }
            }
        };
        t2.start();
    }

    public static void reload() {
        try {
            hotDeployBean = (IHotDeployBean) new MyClassLoader().findClass("com.wupengchoy.mystudy.studydemo.classloader.HotDeployBean").newInstance();
        } catch (Exception e) {
            System.out.println("出错啦！！");
        }
    }

    public static IHotDeployBean getInstance() {
        if (hotDeployBean == null) {
            synchronized (HotDeployBean.class) {
                if (hotDeployBean == null) {
                    try {
                        hotDeployBean = (IHotDeployBean) new MyClassLoader().findClass(HotDeployBean.class.getName()).newInstance();
                    } catch (Exception e) {
                        System.out.println("出错啦！！");
                    }
                }
            }
        }
        return hotDeployBean;
    }
}
