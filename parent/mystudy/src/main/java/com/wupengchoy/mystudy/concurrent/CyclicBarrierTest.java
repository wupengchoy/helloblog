package com.wupengchoy.mystudy.concurrent;

import java.util.concurrent.CyclicBarrier;

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
