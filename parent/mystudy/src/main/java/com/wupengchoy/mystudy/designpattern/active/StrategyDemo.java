package com.wupengchoy.mystudy.designpattern.active;

/**
 * 策略模式：抽象策略类，具体策略类，环境类
 */
public class StrategyDemo {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new StrategyA());
        context.executeMethod();
        context.setStrategy(new StrategyB());
        context.executeMethod();
    }
}

//抽象策略类
interface Strategy {
    void execute();
}

//具体策略类
class StrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("do as strategyA...");
    }
}

//具体策略类
class StrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("do as strategyB...");
    }
}

//环境类
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeMethod() {
        this.strategy.execute();
    }
}


