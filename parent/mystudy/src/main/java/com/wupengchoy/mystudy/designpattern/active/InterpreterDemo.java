package com.wupengchoy.mystudy.designpattern.active;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 解释器模式：抽象表达式，终结符表达式，非终结符表达式，环境
 */
public class InterpreterDemo {
    //环境
    public static void main(String[] args) {
        Expression city = new TerminalExpression(new String[]{"深圳", "广州"});
        Expression person = new TerminalExpression(new String[]{"老年人", "小学生"});
        Expression bus = new AndExpression(city, person);
        //排队上车
        for (String p : new String[]{"深圳的老人", "广州的小学生", "深圳的年轻人", "广州的妇女", "深圳的小学生"}) {
            if (bus.interpret(p)) {
                System.out.println(p + "乘车免费...");
                continue;
            }
            System.out.println(p + "刷卡2元...");
        }
    }
}

//抽象表达式
interface Expression {
    boolean interpret(String info);
}

//终结符表达式
class TerminalExpression implements Expression {
    private Set<String> set;

    public TerminalExpression(String[] data) {
        this.set = new HashSet<>(Arrays.asList(data));
    }

    @Override
    public boolean interpret(String info) {
        return set.contains(info);
    }
}

//非终结符表达式
class AndExpression implements Expression {
    private Expression city;
    private Expression person;

    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interpret(String info) {
        String[] infos = info.split("的");
        return city.interpret(infos[0]) && person.interpret(infos[1]);
    }
}