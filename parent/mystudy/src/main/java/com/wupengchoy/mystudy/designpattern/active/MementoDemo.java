package com.wupengchoy.mystudy.designpattern.active;

import java.util.Stack;

/**
 * 备忘录模式：发起人，备忘录，管理者
 */
public class MementoDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());
        System.out.println("------set------");
        originator.setState("1");
        System.out.println(originator.getState());
        caretaker.getMemento().pushState("1");
        originator.setState("2");
        System.out.println(originator.getState());
        caretaker.getMemento().pushState("2");
        originator.setState("3");
        System.out.println(originator.getState());
        caretaker.getMemento().pushState("3");
        System.out.println("------restore------");
        originator.restoreState(caretaker.getMemento());
        System.out.println(originator.getState());
        originator.restoreState(caretaker.getMemento());
        System.out.println(originator.getState());
        originator.restoreState(caretaker.getMemento());
        System.out.println(originator.getState());


    }
}

//备忘录
class Memento {
    private Stack<String> states = new Stack<>();

    public void pushState(String state) {
        states.push(state);
    }

    public String popState() {
        return states.peek() != null ? states.pop() : "";
    }
}

//管理者
class Caretaker {
    private Memento memento;

    public void setMemento(Memento m) {
        this.memento = m;
    }

    public Memento getMemento() {
        return this.memento;
    }
}

//发起人
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public Memento createMemento() {
        Memento m = new Memento();
        m.pushState(this.state);
        return m;
    }

    public void restoreState(Memento m) {
        this.state = m.popState();
    }
}