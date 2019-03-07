package com.wupengchoy.mystudy.designpattern.creater;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 */
public class BuilderDemo {
    public static void main(String[] args) {
        List<Class<?>> clzs = new ArrayList<>();
        clzs.add(BuilerA.class);
        clzs.add(BuilerB.class);
        Director director = new Director(clzs);
        Product product = director.getProduct();
        System.out.println(product.getPartA().name + ":" + product.getPartB().name);
    }
}

/**
 * 管理者，负责管理builder
 */
class Director {
    private List<MyBuilder> builers = new ArrayList<>();

    public void creatBuilder(Class<?> clz) {
        try {
            this.builers.add((MyBuilder) clz.getConstructor(new Class[]{}).newInstance(new Object[]{}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Director(List<Class<?>> clzs) {
        clzs.forEach(this::creatBuilder);
    }

    public Product getProduct() {
        Product product = new Product();
        builers.forEach(builder -> {
            if (builder instanceof BuilerA) {
                product.setPartA(((BuilerA) builder).buildPart());
            } else {

                product.setPartB(((BuilerB) builder).buildPart());
            }
        });
        return product;
    }
}

interface MyBuilder {
    Part buildPart();
}

interface Part {
}

class PartA implements Part {
    String name = "partA";
}

class PartB implements Part {
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
    public BuilerA() {
    }

    @Override
    public PartA buildPart() {
        return new PartA();
    }
}

class BuilerB implements MyBuilder {
    public BuilerB() {
    }

    @Override
    public PartB buildPart() {
        return new PartB();
    }
}
