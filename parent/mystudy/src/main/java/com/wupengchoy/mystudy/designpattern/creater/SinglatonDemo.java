package com.wupengchoy.mystudy.designpattern.creater;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SinglatonDemo {
    public static void main(String[] args) {
        //懒汉模式
//        Arrays.stream(new int[]{1, 2, 3, 4}).forEach(i -> new Thread(() ->
//                System.out.println(LazySinglaton.getInstance())
//        ).start());

        //饿汉模式
//        Arrays.stream(new int[]{1, 2, 3, 4}).forEach(i ->
//                new Thread(() ->
//                        System.out.println(HungrySinglaton.getInstance())
//                ).start()
//        );

        //多例模式
        Set<MultiSinglaton> singlatons = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            singlatons.add(MultiSinglaton.getInstance());
        }
        System.out.println(singlatons.size());
    }
}

class LazySinglaton {
    private static LazySinglaton instance;

    //私有空实现，避免外界自己new
    private LazySinglaton() {
    }

    public static LazySinglaton getInstance() {
        if (instance == null) {
            synchronized (LazySinglaton.class) {
                if (instance == null) {
                    instance = new LazySinglaton();
                }
            }
        }
        return instance;
    }

}

class HungrySinglaton {
    private static HungrySinglaton instance = new HungrySinglaton();

    private HungrySinglaton() {
    }

    public static HungrySinglaton getInstance() {
        return instance;
    }
}

class MultiSinglaton {
    private static int MAX_LENGTH = 4;
    private static List<MultiSinglaton> instances = new ArrayList<>(MAX_LENGTH);

    private MultiSinglaton() {
    }

    public static MultiSinglaton getInstance() {
        if (instances.size() == 0) {
            for (int i = 1; i <= 4; i++) {
                instances.add(new MultiSinglaton());
            }
        }
        return instances.get((int) (Math.random() * MAX_LENGTH));
    }
}