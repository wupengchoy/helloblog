package com.wupengchoy.mystudy.designpattern.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式：抽象构件，树叶构件，树枝构件
 */
public class CompositeDemo {
    public static void main(String[] args) {
        //超市购物袋子为例，大袋子里有小袋子，还有其他商品，小袋子里还有其他商品
        Bags bigBag = new Bags();
        bigBag.add(new Milk());
        Bags milddleBag = new Bags();
        milddleBag.add(new Apple());
        milddleBag.add(new Apple());
        bigBag.add(milddleBag);

        bigBag.show();
    }
}

//抽象构件
abstract class BagAndGoods {
    abstract void show();
}

//树叶构件
class Milk extends BagAndGoods {
    public void show() {
        System.out.println("i am milk.");
    }
}

//树叶构件
class Apple extends BagAndGoods {
    public void show() {
        System.out.println("i am apple.");
    }
}

//树枝结构
class Bags extends BagAndGoods {
    private List<BagAndGoods> goods = new ArrayList<>();

    public void add(BagAndGoods good) {
        goods.add(good);
    }

    @Override
    public void show() {
        for (BagAndGoods good : goods) {
            good.show();
        }
    }
}

