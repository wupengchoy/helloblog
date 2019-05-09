package com.wupengchoy.mystudy.concurrent;

import java.util.concurrent.Exchanger;

/**
 * 在两个线程之间交换数据，没有交换的时候第一个线程会阻塞
 */
public class ExchangerTest {
    public static void main(String[] args) {
//        Exchanger<String> exchanger = new Exchanger<>();
//        for (int i = 0; i < 4; i++) {
//            new Thread(() -> {
//                try {
//                    String threadName = Thread.currentThread().getName();
//                    System.out.println(threadName + "中获取线程exchanger交换的数据:" + exchanger.exchange(threadName));
//                    System.out.println("end " + threadName);
//                } catch (Exception e) {
//                    System.out.println(e.toString());
//                }
//            }).start();
//        }
        System.out.println("winexz".substring(0,2)+"winexz".substring(3));
    }
}
