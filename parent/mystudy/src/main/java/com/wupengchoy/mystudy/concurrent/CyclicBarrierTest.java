package com.wupengchoy.mystudy.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * 倒数计数并阻塞线程，达到计数的时候唤醒被阻塞的线程--可以重复使用
 */
public class CyclicBarrierTest {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i <7 ; i++) {
            new Thread(()->{
                try{
                    cyclicBarrier.await();
                }catch (Exception e){}
                System.out.println(Thread.currentThread().getName()+" run...");
            }).start();
            System.out.println("thread started...");
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }
}
