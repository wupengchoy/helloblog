package com.wupengchoy.mystudy.designpattern.active;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式：抽象聚合角色，具体聚合角色，抽象迭代器，具体迭代器
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("a");
        aggregate.add("b");
        aggregate.add("c");
        aggregate.add("d");
        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

//抽象聚合角色
abstract class Aggregate<T> {
    protected List<T> list;

    public void add(T t) {
        list.add(t);
    }

    abstract Iterator getIterator();
}

//抽象迭代器
interface Iterator<T> {
    boolean hasNext();

    T next();
}

//具体聚合角色
class ConcreteAggregate extends Aggregate {
    public ConcreteAggregate() {
        list = new ArrayList();
    }

    @Override
    Iterator getIterator() {
        return new ConcreteIterator(list);
    }
}

//具体迭代器
class ConcreteIterator<T> implements Iterator {
    private List<T> list;
    private int index = 0;

    public ConcreteIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.size() > index;

    }

    @Override
    public T next() {
        return list.get(index++);
    }
}