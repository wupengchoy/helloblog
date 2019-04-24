package com.wupengchoy.mystudy.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args){
        CountDownLatch down = new CountDownLatch(2);
        //只能使用一次，当全部到达之后，后面再来的线程不会阻塞
        for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                try{
                    System.out.println(Thread.currentThread().getName()+"in...");
                    down.await();
                    System.out.println(Thread.currentThread().getName()+"out...");
                }catch (Exception e){}
            }).start();
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
            down.countDown();
        }
    }
}
