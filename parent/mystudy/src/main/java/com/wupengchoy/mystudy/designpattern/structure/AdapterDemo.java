package com.wupengchoy.mystudy.designpattern.structure;

/**
 * 适配器模式：目标接口，适配器，适配者
 */
public class AdapterDemo {
    public static void main(String[] args) {
        //用户不能直接调用目标，需要使用适配器去调用源适配者--feign
        //用户->适配器（Adapter）->适配者（Adapdee）
        //类适配方器模式
        Adapter classAdapter = new ClassAdapter();
        classAdapter.request();
        //对象适配模式
        Adapter objectAdapter = new ObjectAdapter(new Adaptee());
        objectAdapter.request();

        //扩展-双向适配器（可以将适配器转为适配者，也可以将适配者转为适配器目标）-需要适配者也添加接口
        System.out.println("--------");
        TwoWayAdapter twoWayAdapter = new TwoWayAdapter(new ObjectAdapter(new Adaptee()));
        twoWayAdapter.say();
        System.out.println("--------");
        TwoWayAdapter twoWayAdapter1 = new TwoWayAdapter(new Adaptee());
        twoWayAdapter1.request();

    }
}

interface Adapter {
    void request();
}

/**
 * 适配器-类适配模式
 */
class ClassAdapter extends Adaptee implements Adapter {
    @Override
    public void request() {
        say();
    }
}

/**
 * 适配器-对象适配模式
 */
class ObjectAdapter implements Adapter {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        this.adaptee.say();
    }
}

interface IAdaptee {
    void say();
}

/**
 * 适配者-源
 */
class Adaptee implements IAdaptee {
    public void say() {
        System.out.println("hello from adapdee");
    }
}

/**
 * 双向适配器
 */
class TwoWayAdapter implements Adapter, IAdaptee {
    private IAdaptee adaptee;
    private Adapter adapter;

    public TwoWayAdapter(IAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    public TwoWayAdapter(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void request() {
        System.out.println("适配器调用适配者...");
        adaptee.say();
    }

    @Override
    public void say() {
        System.out.println("适配者调用适配器");
        adapter.request();
    }
}
