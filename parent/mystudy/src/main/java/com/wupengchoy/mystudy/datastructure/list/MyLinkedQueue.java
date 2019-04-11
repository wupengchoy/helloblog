package com.wupengchoy.mystudy.datastructure.list;

import java.util.NoSuchElementException;

/**
 * 链表形式实现
 *
 * @param <T>
 */
public class MyLinkedQueue<T> {
    private class Node<T> {
        Node<T> pre;
        T data;

        public Node(Node<T> pre, T t) {
            this.data = t;
            this.pre = pre;
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MyLinkedQueue() {
        doClear();
    }

    public void doClear() {
        this.size = 0;
        head = null;
        this.tail = null;
    }

    public void enqueue(T t) {
        Node<T> node = new Node<>(tail, t);
        if (head == null) {
            head = node;
        }
        tail = node;

        this.size++;
    }

    public T dequeue() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        //不是双向链表，需要一个个找
        T t;
        Node<T> node = tail;
        Node<T> pre = tail;
        while (true) {
            if (node.pre == null) {
                t = head.data;
                pre.pre = null;
                head = pre;
                break;
            }
            pre = node;
            node = node.pre;
        }
        this.size--;
        return t;
    }

    public int size() {
        return this.size;
    }
}
