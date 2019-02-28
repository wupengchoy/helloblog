package com.wupengchoy.mystudy.studydemo.thread.basic;

public class ThreadTalk {
    static int index = 0;

    public static void main(String[] args) {
        try {
            //创建线程
//            Thread t = new MyThread();
//            System.out.println("start....");
//            t.start();
//            Thread.sleep(1000);
//            System.out.println("run.....");
//            t.run();
//
//
//            Thread t3 = new Thread(new MyRunable());
//            t3.start();
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("匿名runable...");
//                }
//            }).start();

            //状态--多次执行输出结果不一样--NEW,RUNNABLE,BLOCKED,WATING,TIMED_WATING,TERMINATED
//            Thread t4 = new MyThread();
//            System.out.println(t4.getState());
//            t4.start();
//            System.out.println(t4.isAlive());
//            System.out.println(t4.getState());
//            Thread.sleep(1500);
//            System.out.println(t4.getState());
//            System.out.println(t4.isAlive());

            //daemon
//            t4.setDaemon(false);
//            t4.isDaemon();
            //sleep
            //yield
            //join
//            Thread t5 = new Thread(new MyRunable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(1000);
//                        System.out.println("t5...");
//                    } catch (Exception e) {
//                    }
//                }
//            });
//            t5.start();
//            t5.join();
//            Thread t6 = new Thread(new MyRunable() {
//                @Override
//                public void run() {
//                    System.out.println("t6...");
//                }
//            });
//            t6.start();

            //线程问题
            //竞争
//            new Thread(() -> {
//                while (index <= 1000) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    index++;
//                }
//            }).start();
//
//            new Thread(() -> {
//                while (index <= 1000) {
//                    try {
//                        Thread.sleep(50);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(index++);
//                }
//            }).start();
            //内存可见性

        } catch (Exception e) {
            System.out.println("出错啦1！！");
        }


    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);

            } catch (Exception e) {

            }
            System.out.println(Thread.currentThread().getState());
//            System.out.println(Thread.currentThread().getName());
//            throw new RuntimeException("");
        }
    }

    static class MyRunable implements Runnable {
        @Override
        public void run() {
            System.out.println("runable...");
        }
    }
}
