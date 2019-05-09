package com.wupengchoy.mystudy.concurrent;

import java.util.concurrent.Phaser;

/**
 * create by wupengchoy
 * 2019-04-24
 */
public class PhaserTest {
    public static void main(String[] args) {
//        Phaser phaser = new Phaser(3);
//     for (int i = 0; i < 3; i++) {
//         new Thread(()-> {
//             System.out.println(Thread.currentThread().getName()+" started...");
//             //多段使用-与CountDownLatch的await方法类似，但是await()方法不能多段使用
//             phaser.arriveAndAwaitAdvance();
//             //获取到达的第几个屏障--一个屏障表示所有线程调用的arriveAndAwaitAdvance的次数
////             System.out.println("getPhase():"+phaser.getPhase());
//             System.out.println(Thread.currentThread().getName()+" runnung...");
//             //中途退赛
//             if("Thread-2".equals(Thread.currentThread().getName()))
//             {
//                 //中途退出，如果不使用，后面的线程会阻塞。
//                 phaser.arriveAndDeregister();
//                 return;
//             }
//             phaser.arriveAndAwaitAdvance();
////             System.out.println("getPhase():"+phaser.getPhase());
//             System.out.println(Thread.currentThread().getName()+" ended...");
//         }).start();
//     }
//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> {
//                phaser.arriveAndAwaitAdvance();
//                System.out.println("phase count1:" + phaser.getPhase());
//                phaser.arriveAndAwaitAdvance();
//                System.out.println("phase count2:" + phaser.getPhase());
//                phaser.arriveAndAwaitAdvance();
//                System.out.println("phase count3:" + phaser.getPhase());
//            }).start();
//        }

        Phaser phaser = new Phaser(3){
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("onAdvance()");
                return super.onAdvance(phase, registeredParties);
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                phaser.arriveAndAwaitAdvance();
                System.out.println("phase count1:" + phaser.getPhase());
                phaser.arriveAndAwaitAdvance();
                System.out.println("phase count2:" + phaser.getPhase());
                phaser.arriveAndAwaitAdvance();
                System.out.println("phase count3:" + phaser.getPhase());
            }).start();
        }
    }
}