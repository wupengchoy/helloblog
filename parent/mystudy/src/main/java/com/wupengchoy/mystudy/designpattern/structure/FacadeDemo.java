package com.wupengchoy.mystudy.designpattern.structure;

/**
 * 外观模式：客户角色，外观角色，子系统角色--使用于多个复杂子系统的程序
 */
public class FacadeDemo {
    public static void main(String[] args) {
        //京东购买流程包含下单，付款，打包等子系统支持
        new User().buy();
    }
}

//客户角色
class User {
    private JDShopping jd = new JDShopping();

    public void buy() {
        jd.shooping();
    }
}

//外观角色
class JDShopping {
    private ChooseSystem chooseSystem = new ChooseSystem();
    private PaySystem paySystem = new PaySystem();
    private PackageSystem packageSystem = new PackageSystem();

    public void shooping() {
        chooseSystem.choose();
        paySystem.pay();
        packageSystem.packageGoods();
    }
}

//子系统角色
class ChooseSystem {
    public void choose() {
        System.out.println("下单中...");
    }
}

//子系统角色
class PaySystem {
    public void pay() {
        System.out.println("付款中...");
    }
}

//子系统角色
class PackageSystem {
    public void packageGoods() {
        System.out.println("打包中...");
    }
}


