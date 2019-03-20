package com.wupengchoy.mystudy.designpattern.active;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式：抽象中介者，具体中介者，抽象同事类，具体同事类
 * 注意---中介者模式和观察者模式的区别和关联
 */
public class MediatorDemo {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague a = new ColleagueA();
        Colleague b = new ColleagueB();
        mediator.register(a);
        mediator.register(b);
        a.send();
        b.send();
    }
}

//抽象中介者
interface Mediator {
    void register(Colleague colleague);
    void relay(Colleague colleague);
}

//抽象同事类
abstract class Colleague {
    protected Mediator mediator;
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    abstract void receive();
    abstract void send();
}

//具体同事类
class ColleagueA extends Colleague {
    @Override
    void receive() {
        System.out.println("colleagueA received...");
    }

    @Override
    void send() {
        System.out.println("colleagueA send...");
        mediator.relay(this);//请求中介者转发
    }
}

//具体同事类
class ColleagueB extends Colleague {
    @Override
    void receive() {
        System.out.println("colleagueB received...");
    }

    @Override
    void send() {
        System.out.println("colleagueB send...");
        mediator.relay(this);//请求中介者转发
    }
}

//具体中介者
class ConcreteMediator implements Mediator {
    private List<Colleague> colleagus = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        colleagus.add(colleague);
        colleague.setMediator(this);
    }

    @Override
    public void relay(Colleague colleague) {
        for (Colleague co : colleagus) {
            if (!co.equals(colleague)) {
                co.receive();
            }
        }
    }
}
