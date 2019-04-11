package com.wupengchoy.mystudy.datastructure.list;

import java.util.NoSuchElementException;

public class MyLinkedStack<T> {
    private int size = 0;
    private Node<T> top;

    public MyLinkedStack() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        this.size = 0;
        top = null;
    }

    public void push(T t) {
        top = new Node(top, t);
        this.size++;
    }

    public T peek() {
        if (this.size <= 0) {
            throw new NoSuchElementException();
        }
        return top.data;
    }

    public T pop() {
        if (this.size <= 0) {
            throw new NoSuchElementException();
        }
        this.size--;
        T t = top.data;
        top = top.pre;
        return t;
    }

    public int size() {
        return this.size;
    }


    private class Node<T> {
        Node<T> pre;
        T data;

        Node(Node<T> pre, T t) {
            this.pre = pre;
            this.data = t;
        }
    }
}
