package com.wupengchoy.mystudy.datastructure.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
    //节点类-包含node双端节点previous和next
    private static class Node<E> {
        public E data;
        public Node<E> pre;
        public Node<E> next;

        public Node(Node<E> pre, E data, Node<E> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    //基本属性
    private int size;
    private int modCount = 0;//链表修改次数统计，用来与迭代器中的modCount做比较判断是否发生线程冲突
    //头节点
    private Node<E> head;
    //尾节点
    private Node<E> tail;

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        //默认初始化一个空的头结点和尾节点，避免了遍历头尾时候的特殊性，空头尾不计算在size内
        head = new Node(null, null, null);
        tail = new Node(head, null, null);
        this.size = 0;
        this.modCount++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    //添加
    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    public void add(int index, E e) {
        addBefore(getNode(index), e);
    }

    public E get(int index) {
        return getNode(index).data;
    }

    private Node<E> getNode(int index) {
        return getNode(index, 0, size());
    }

    private Node<E> getNode(int index, int lower, int upper) {
        Node<E> p;
        if (index < lower || index > upper) {
            throw new IndexOutOfBoundsException();
        }
        //2分法查找
        if (index >= size() / 2) {
            p = tail;
            for (int i = size(); i > index; i--)//从tail开始的，初始值不需要-1
            {
                p = p.pre;
            }
        } else {
            p = head;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        }
        return p;
    }

    private void addBefore(Node<E> node, E e) {
        Node<E> newNode = new Node<>(node.pre, e, node);
        node.pre.next = newNode;
        node.pre = newNode;
        this.size++;
        this.modCount++;
    }

    //移除-返回被移除的对象
    public E remove(int index) {
        return remove(getNode(index));
    }

    private E remove(Node<E> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
        modCount++;
        return node.data;
    }

    //迭代器
    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    class MyLinkedListIterator implements Iterator<E> {
        private Node<E> current = head.next;
        private int expectModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public E next() {
            if (modCount != expectModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            okToRemove = true;
            return data;
        }

        public void remove() {
            if (modCount != expectModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.pre);
            expectModCount++;
            okToRemove = false;
        }
    }

//    @Override
//    public String toString() {
//        String result = "[";
//        Node<E> current = head.next;
//        while (current != tail) {
//            result = result + current.data + ",";
//        }
//        result += "]";
//        return result;
//    }
}

