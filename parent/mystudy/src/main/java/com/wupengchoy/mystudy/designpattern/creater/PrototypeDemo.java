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
//        System.out.println(Circle.circle());
        //原型管理器
        Circle circle = (Circle) PrototypeManagement.getObject(Circle.class);
        circle.setR(2);
        System.out.println(circle.area());
    }
}

interface Pic extends Cloneable {
    double area();

    Pic getInstance();
}

class Circle implements Pic {
    private static Circle cirlce = new Circle();
    private int r = 0;

    private Circle() {
    }

    public void setR(int r) {
        this.r = r;
    }

    public static Circle circle() {
        try {
            return (Circle) cirlce.clone();
        } catch (Exception e) {
        }
        return cirlce;
    }

    public static Circle circle(int r) {
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

    @Override
    public Pic getInstance() {
        return circle();
    }
}

class PrototypeManagement {
    private static Map<Class<?>, Pic> map = new HashMap<>();

    public static Pic getObject(Class<?> clz) {
        try {
            if (!map.containsKey(clz)) {
                Method instanceMethod = clz.getMethod("circle", new Class[]{});
                map.put(clz, (Pic) instanceMethod.invoke(null, new Object[]{}));
            }
            Pic pic = map.get(clz);
            return pic.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
