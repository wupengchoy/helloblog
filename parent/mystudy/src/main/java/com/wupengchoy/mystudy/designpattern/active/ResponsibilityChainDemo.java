package com.wupengchoy.mystudy.designpattern.active;

/**
 * 职责链模式：抽象处理者，具体处理着，客户类
 */
public class ResponsibilityChainDemo {
    public static void main(String[] args) {
        IHandler handlerA = new HandlerA();
        IHandler handlerB = new HandlerB();
        handlerA.setNext(handlerB);
        handlerA.execute("a");
        handlerA.execute("b");
        handlerA.execute("c");
    }
}

//抽象处理着
abstract class IHandler {
    private IHandler next;

    abstract void execute(String key);

    public void setNext(IHandler next) {
        this.next = next;
    }

    public IHandler getNext() {
        return this.next;
    }
}

//具体处理者
class HandlerA extends IHandler {
    @Override
    void execute(String key) {
        if ("a".equals(key)) {
            System.out.println("handlerA do....");
            return;
        }

        if (this.getNext() != null) {
            this.getNext().execute(key);
            return;
        }

        System.out.println("请求未处理...");
    }
}

//具体处理者
class HandlerB extends IHandler {
    @Override
    void execute(String key) {
        if ("b".equals(key)) {
            System.out.println("handlerB do....");
            return;
        }

        if (this.getNext() != null) {
            this.getNext().execute(key);
            return;
        }

        System.out.println("请求未处理...");
    }
}
