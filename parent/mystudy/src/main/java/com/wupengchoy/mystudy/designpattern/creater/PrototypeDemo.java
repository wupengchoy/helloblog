package com.wupengchoy.mystudy.designpattern.creater;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 原型模式
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        //简单原型
        System.out.println(Circle.circle());
        //原型管理器
        Circle circle = (Circle) PrototypeManagement.getObject(Circle.class, 2);
        System.out.println(circle.area());
    }
}

interface Pic {
    double area();
}

class Circle implements Cloneable, Pic {
    private static Circle cirlce = new Circle();
    private int r = 0;

    private Circle() {
    }

    public static Circle circle() {
        try {
            return (Circle) cirlce.clone();
        } catch (Exception e) {
        }
        return cirlce;
    }

    public static Circle getInstance(int r) {
        try {
            Circle newCircle = (Circle) cirlce.clone();
            newCircle.r = r;
            return newCircle;
        } catch (Exception e) {
        }
        return cirlce;
    }

    @Override
    public double area() {
        return 3.14 * r * r;
    }
}

class PrototypeManagement {
    private static Map<Class<?>, Object> map = new HashMap<>();

    public static Object getObject(Class<?> clz, int r) {
        try {
            Method instanceMethod = clz.getMethod("getInstance", new Class[]{int.class});
            map.put(clz, instanceMethod.invoke(null, new Object[]{r}));
            return map.get(clz);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
