package com.wupengchoy.mystudy.designpattern.active;

/**
 * 模板方法模式：抽象类和具体子类
 * 抽象类中包含：模板方法和基本方法
 * 基本方法分为：具体方法，抽象方法，钩子方法
 */
public class TemplateMethodDemo {
    public static void main(String[] args) {
        Travel beijing = new Beijing("beijing");
        beijing.travel();
        Travel shanghai = new Shanghai("shanghai");
        shanghai.travel();
    }
}

//抽象类
abstract class Travel {
    protected String destinate;

    //模板方法
    protected Travel(String destinate) {
        System.out.println("去"+destinate+"...");
        this.destinate = destinate;
    }

    public void travel() {
        plan();
        if (travelHook()) {
            byTicket();
        } else {
            byCar();
        }
    }

    //具体方法
    protected void plan() {
        System.out.println("预定计划...");
    }

    //钩子方法
    protected boolean travelHook() {
        return "beijing".equals(this.destinate);
    }

    //抽象方法
     abstract void byTicket();

    protected void byCar() {
        System.out.println("自驾游...");
    }
}

//具体子类
class Beijing extends Travel {
    public Beijing(String destinate) {
        super(destinate);
    }

    @Override
    void byTicket() {
        System.out.println("买飞机票...");
    }
}

//具体子类
class Shanghai extends Travel{
    public Shanghai(String destinate)
    {
        super(destinate);
    }

    @Override
    void byTicket() {

    }
}


