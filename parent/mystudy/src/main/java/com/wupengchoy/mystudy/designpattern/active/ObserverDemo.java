package com.wupengchoy.mystudy.designpattern.active;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式：抽象主题，具体主题，抽象观察者，具体观察者
 * JDK中自带Observer,Observable等观察者模式要使用的抽象类和接口
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        subject.regiest(new ObserverA());
        subject.regiest(new ObserverB());
        subject.notifyObservers();
    }
}

//抽象观察者
interface IObserver {
    void execute();
}

//具体观察者
class ObserverA implements IObserver {
    @Override
    public void execute() {
        System.out.println("observerA get...");
    }
}

//具体观察者
class ObserverB implements IObserver {
    @Override
    public void execute() {
        System.out.println("observerB get...");
    }
}

//抽象主题
abstract class Subject {
    protected List<IObserver> observers = new ArrayList<>();

    public void regiest(IObserver observer) {
        observers.add(observer);
    }

    public void remove(IObserver observer) {
        observers.remove(observer);
    }

    abstract void notifyObservers();
}
//具体主题
class ConcreteSubject extends Subject {
    @Override
    void notifyObservers() {
        for (IObserver observer : observers) {
            observer.execute();
        }
    }
}
