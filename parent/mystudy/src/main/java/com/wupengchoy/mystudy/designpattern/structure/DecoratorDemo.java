package com.wupengchoy.mystudy.designpattern.structure;

/**
 * 装饰模式-抽象构件，具体构件，抽象装饰，具体装饰（注意与代理模式的区别）
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        Car truck = new Truck(new MyCar());
        truck.create();
        Car bus = new Bus(new MyCar());
        bus.create();
    }
}

//抽象构件
interface Car {
    void create();
}

//具体构件
class MyCar implements Car {
    @Override
    public void create() {
        System.out.print("it's a car.");
    }
}

//抽象装饰
abstract class DecoratorCar implements Car {
    private Car car;

    public DecoratorCar(Car car) {
        this.car = car;
    }

    @Override
    public void create() {
        car.create();
    }

    abstract void change();
}

//具体装饰
class Truck extends DecoratorCar {
    public Truck(Car car) {
        super(car);
    }

    public void create() {
        super.create();
        change();
    }

    @Override
    protected void change() {
        System.out.println("it's a truck.");
    }
}

//具体装饰
class Bus extends DecoratorCar {
    public Bus(Car car) {
        super(car);
    }

    @Override
    public void create() {
        super.create();
        change();
    }

    @Override
    void change() {
        System.out.println("it's a bus.");
    }
}

