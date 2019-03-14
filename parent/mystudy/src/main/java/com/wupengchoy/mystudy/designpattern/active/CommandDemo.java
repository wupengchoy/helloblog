package com.wupengchoy.mystudy.designpattern.active;

/**
 * 命令模式：抽象命令类，具体命令角色，接受者角色，请求者角色
 */
public class CommandDemo {
    public static void main(String[] args) {
        new Invoker(new CommandA()).call();
        new Invoker(new CommandB()).call();
    }
}

//接受者
class ReceiverA {
    public void action() {
        System.out.println("receiverA do...");
    }
}

//接受者
class ReceiverB {
    public void action() {
        System.out.println("receiverB do...");
    }
}

//抽象命令角色
interface ICommand {
    void execute();
}

//具体命令角色
class CommandA implements ICommand {
    private ReceiverA receiver;

    public CommandA() {
        receiver = new ReceiverA();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

//具体命令角色
class CommandB implements ICommand {
    private ReceiverB receiver;

    public CommandB() {
        receiver = new ReceiverB();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

//请求者
class Invoker {
    private ICommand cmd;

    public Invoker(ICommand cmd) {
        this.cmd = cmd;
    }

    public void call() {
        cmd.execute();
    }
}