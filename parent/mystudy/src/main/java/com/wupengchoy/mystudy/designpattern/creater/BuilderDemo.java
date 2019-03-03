package com.wupengchoy.mystudy.designpattern.creater;

/**
 * 建造者模式
 */
public class BuilderDemo {
    public static void main(String[] args) {
        Director director = new Director(BuilerA.class);
        Product product = director.getProduct();
        System.out.println(product.getPartA().name + ":" + product.getPartB().name);
    }
}

/**
 * 管理者，负责管理builder
 */
class Director {
    private MyBuilder builer;

    public void creatBuilder(Class<?> clz) {
        try {
            this.builer = (MyBuilder) clz.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Director(Class<?> clz) {
        creatBuilder(clz);
    }

    public Product getProduct() {
        Product product = new Product();
        product.setPartA(builer.buildPartA());
        product.setPartB(builer.buildPartB());
        return product;
    }
}

interface MyBuilder {
    PartA buildPartA();

    PartB buildPartB();
}

class PartA {
    String name = "partA";
}

class PartB {
    String name = "partB";
}

class Product {
    private PartA partA;
    private PartB partB;

    public void setPartA(PartA partA) {
        this.partA = partA;
    }

    public PartA getPartA() {
        return partA;
    }

    public void setPartB(PartB partB) {
        this.partB = partB;
    }

    public PartB getPartB() {
        return partB;
    }
}

class BuilerA implements MyBuilder {
    public BuilerA(){}
    @Override
    public PartA buildPartA() {
        return new PartA();
    }

    @Override
    public PartB buildPartB() {
        return new PartB();
    }
}
