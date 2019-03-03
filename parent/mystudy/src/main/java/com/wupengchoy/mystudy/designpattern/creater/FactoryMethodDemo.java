package com.wupengchoy.mystudy.designpattern.creater;

import org.apache.commons.lang.StringUtils;

/**
 * 工厂模式组成：抽象工厂，工厂，抽象产品，产品
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        //简单工厂模式，产品单一，工厂单一
        Factory factory = new FactoryA();
        factory.getFruit(Apple.class).say();
        //抽象工厂模式--多个工厂，多种产品
        Factory factoryB = new FactoryB();
        factoryB.getAnimal(Cow.class).say();
        factoryB.getFruit(Apple.class).say();

    }

}

interface Factory {
    Fruit getFruit(Class<?> clz);

    Animal getAnimal(Class<?> clz);
}

class FactoryA implements Factory {

    @Override
    public Fruit getFruit(Class<?> clz) {
        try {
            return (Fruit) clz.getConstructor(new Class[]{String.class}).newInstance(new Object[]{this.getClass().getSimpleName()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Animal getAnimal(Class<?> clz) {
        try {
            return (Animal) clz.getConstructor(new Class[]{String.class}).newInstance(new Object[]{this.getClass().getSimpleName()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

class FactoryB implements Factory {

    @Override
    public Fruit getFruit(Class<?> clz) {
        try {
            return (Fruit) clz.getConstructor(new Class[]{String.class}).newInstance(new Object[]{this.getClass().getSimpleName()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Animal getAnimal(Class<?> clz) {
        try {
            return (Animal) clz.getConstructor(new Class[]{String.class}).newInstance(new Object[]{this.getClass().getSimpleName()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


interface Fruit {
    void say();
}

class Apple implements Fruit {
    private String source = "";

    public Apple(String source) {
        this.source = source;
    }

    public Apple() {
    }

    @Override
    public void say() {
        System.out.println("i am apple " + (StringUtils.isNotBlank(this.source) ? "from " + source : ""));
    }
}

interface Animal {
    void say();
}

class Cow implements Animal {
    private String source = "";

    public Cow() {
    }

    public Cow(String source) {
        this.source = source;
    }

    @Override
    public void say() {
        System.out.println("i am cow " + (StringUtils.isNotBlank(this.source) ? "from " + source : ""));
    }
}
