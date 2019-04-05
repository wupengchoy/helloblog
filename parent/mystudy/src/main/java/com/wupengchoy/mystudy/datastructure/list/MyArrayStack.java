package com.wupengchoy.mystudy.datastructure.list;

import java.util.NoSuchElementException;

/**
 * 栈--可以用数组和链表的形式实现
 * 使用限定长度栈的时候使用数组形式实现比较好，因为读取快，但是扩容的时候慢
 * 链表形式实现的栈不限定长度
 * 栈不管用什么形式实现，因为push,peek,pop操作只涉及顶层元素，所以复杂度都是O(N)
 */
public class MyArrayStack<T> {
    private int currentIndex = -1;
    private static int CAPACITY = 16;
    private static double EXPAND_MULTIPLE = 0.75;
    T[] data;

    public MyArrayStack() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        this.currentIndex = -1;
        enSureCapacity(CAPACITY);
    }

    /**
     * 扩容
     */
    private void enSureCapacity(int newCapacity) {
        if (this.currentIndex + 1 >= newCapacity) {
            return;
        }
        T[] old = data;
        data = (T[]) new Object[newCapacity];
        for (int i = 0; i < currentIndex + 1; i++) {
            data[i] = old[i];
        }
    }

    public int size() {
        return currentIndex + 1;
    }

    public T peek() {
        if (currentIndex == -1) {
            throw new NoSuchElementException();
        }
        return data[currentIndex];
    }

    public T pop() {
        if (currentIndex == -1) {
            throw new NoSuchElementException();
        }
        return data[currentIndex--];
    }

    public void push(T t) {
        if (currentIndex >= EXPAND_MULTIPLE * data.length) {
            enSureCapacity(data.length * 2);
        }
        data[++currentIndex] = t;
    }

}
