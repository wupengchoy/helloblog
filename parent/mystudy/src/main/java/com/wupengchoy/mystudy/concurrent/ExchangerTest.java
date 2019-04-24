package com.wupengchoy.mystudy.concurrent;

import java.util.concurrent.Exchanger;

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
