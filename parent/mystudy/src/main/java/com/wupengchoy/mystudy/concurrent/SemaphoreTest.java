package com.wupengchoy.mystudy.concurrent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 信号量--获取给定的信号量，如果获取不到则阻塞
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1, false);
        List<Thread> threadList = new ArrayList<>();
        Object lock = new Object();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(() -> {
                try {
                    synchronized (lock)
                    {
                        Thread.sleep((int) (Math.random() * 100));
                        semaphore.acquire(1);
                        System.out.println(Thread.currentThread().getName() + " acquire time：" + LocalDateTime.now());
                    }
                } catch (Exception e) {
                    System.out.println("error");
                } finally {
                    semaphore.release(1);
//                    System.out.println(Thread.currentThread().getName() + " availablePermits:" + semaphore.availablePermits());
                }

            }));
        }
        threadList.forEach(thread -> {
            thread.start();
//            System.out.println(thread.getName() + " started");
        });

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    semaphore.acquireUninterruptibly();
////                    semaphore.acquire();
//                    System.out.println(Thread.currentThread().getName() + " start time：" + LocalDateTime.now());
////                    Thread.sleep(5000);
//                    for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
//
//                        String str = new String();Math.random();
//                    }
//                    System.out.println(Thread.currentThread().getName() + " end time：" + LocalDateTime.now());
//                    semaphore.release();
//                } catch (Exception e) {
//                    System.out.println(e.toString());
//                }
//            }
//        });
//
//        t1.start();
//        try {
//            t1.interrupt();
//            System.out.println(t1.getName() + " interrupt");
//        } catch (Exception e) {
//            System.out.println("error2");
//        }
    }
}
