package com.wupengchoy.mystudy.designpattern.active;

/**
 * 状态模式：环境角色，抽象状态角色，具体状态角色
 */
public class StateDemo {
    public static void main(String[] args) {
        //线程执行中的状态替换
        ThreadContext context = new ThreadContext();
        context.start();
        context.runnable();
        context.runnung();
        context.stop();
    }
}

//环境角色
class ThreadContext {
    private IThreadState state;

    public void start() {
        this.state = new New();
        this.state.execute();
    }

    public void runnable() {
        this.state = new Runnable();
        this.state.execute();
    }

    public void runnung() {
        this.state = new Running();
        this.state.execute();
    }

    public void stop() {
        this.state = new Dead();
        this.state.execute();
    }
}

//抽象状态
interface IThreadState {
    void execute();
}

//具体状态
class New implements IThreadState {
    @Override
    public void execute() {
        System.out.println("thread new...");
    }
}

//具体状态
class Runnable implements IThreadState {
    @Override
    public void execute() {
        System.out.println("thread runnable...");
    }
}

//具体状态
class Running implements IThreadState {
    @Override
    public void execute() {
        System.out.println("thread running...");
    }
}

//具体状态
class Dead implements IThreadState {
    @Override
    public void execute() {
        System.out.println("thread dead...");
    }
}

