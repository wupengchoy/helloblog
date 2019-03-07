package com.wupengchoy.mystudy.designpattern.structure;

/**
 * 桥接模式--抽象化角色，扩展抽象化角色，实现化角色接口，具体实现化角色
 * 适用多种组合的产品
 */
public class BridgeDemo {
    public static void main(String[] args) {
        Bag handBag = new HandBag(new Red());
        handBag.say();
        Bag wallet = new Wallet(new Yellow());
        wallet.say();
    }
}

//抽象化角色
abstract class Bag {
    public Color color;

    public Bag(Color color) {
        this.color = color;
    }

    abstract String getName();

    public void say() {
        System.out.println("i am " + getName() + ";my color is " + color.getColor());
    }
}

//扩展角色
class HandBag extends Bag {
    @Override
    String getName() {
        return "handBag";
    }

    public HandBag(Color color) {
        super(color);
    }
}
//扩展角色
class Wallet extends Bag {
    @Override
    String getName() {
        return "wallet";
    }

    public Wallet(Color color) {
        super(color);
    }
}
//实现化角色接口
interface Color {
    String getColor();
}
//具体实现化
class Red implements Color {
    @Override
    public String getColor() {
        return "red";
    }
}
//具体实现化
class Yellow implements Color {
    @Override
    public String getColor() {
        return "yellow";
    }
}
