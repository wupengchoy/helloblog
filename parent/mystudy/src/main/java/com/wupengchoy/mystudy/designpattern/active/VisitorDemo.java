package com.wupengchoy.mystudy.designpattern.active;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式；抽象访问者，具体访问者，抽象元素，具体元素，对象结构
 */
public class VisitorDemo {
    public static void main(String[] args) {
        Structure structure = new Structure();
        structure.add(new ElementA());
        structure.add(new ElementB());
        structure.accept(new VisitorA());
        System.out.println("-------------");
        structure.accept(new VisitorB());
    }
}

//抽象元素
interface Element {
    void sayHello();
}

//具体元素
class ElementA implements Element {
    @Override
    public void sayHello() {
        System.out.println("hi,i am elementA...");
    }
}

class ElementB implements Element {
    @Override
    public void sayHello() {
        System.out.println("hi,i am elementB...");
    }
}

//抽象访问者
interface Visitor {
    void visit(Element el);
}

//具体访问者
class VisitorA implements Visitor {
    @Override
    public void visit(Element el) {
        System.out.print("visitorA Knock knock...");
        el.sayHello();
    }
}

class VisitorB implements Visitor {
    @Override
    public void visit(Element el) {
        System.out.print("visitorB Knock knock...");
        el.sayHello();
    }
}

//结构类
class Structure {
    private List<Element> elements = new ArrayList<>();

    public void add(Element el) {
        this.elements.add(el);
    }

    public void accept(Visitor visitor) {
        elements.forEach(el -> visitor.visit(el));
    }
}