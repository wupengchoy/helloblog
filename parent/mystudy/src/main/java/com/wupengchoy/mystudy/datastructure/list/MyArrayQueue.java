package com.wupengchoy.mystudy.datastructure.list;

import java.util.NoSuchElementException;

/**
 * 数组实现，模拟循环数组，注意队列长度和数组长度的对比，以及头尾位置的比较
 *
 * @param <T>
 */
public class MyArrayQueue<T> {
    private int headIndex;
    private int tailIndex;
    private T[] data;
    private int size = 0;
    private static int CAPACITY = 16;
    private static double EXPAND_MULTIPLE = 0.75;

    public MyArrayQueue() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        headIndex = 0;
        tailIndex = 0;
        this.size = 0;
        data = (T[]) new Object[CAPACITY];
    }

    public int size() {
        return this.size;
    }

    //入队
    public void enqueue(T t) {
        if (this.size >= EXPAND_MULTIPLE * data.length) {
            enSureCapacity(data.length);
        }
        tailIndex = (tailIndex) % data.length;//模拟环形数组
        data[tailIndex] = t;
        tailIndex++;
        this.size++;
    }

    //出队
    public T dequeue() {
        if (this.size <= 0) {
            throw new NoSuchElementException();
        }
        T t = data[headIndex];
        data[headIndex] = null;
        //考虑环形情况tail>head    t t t tail - - - - head t t t t
        headIndex = Math.abs(++headIndex % data.length);
        this.size--;
        return t;
    }

    //扩容
    private void enSureCapacity(int capacity) {
        if (this.size > capacity) {
            return;
        }
        T[] old = data;
        data = (T[]) new Object[capacity * 2];
        //考虑环形数组，tail<head的情况
        if (tailIndex <= headIndex)//t t t tail - - - - head t t t t
        {
            //从后向前复制
            for (int i = old.length - 1; i >= headIndex; i--) {
                data[i + capacity] = old[i];
            }
            headIndex += capacity;
            //从前向后复制
            for (int i = 0; i <= tailIndex; i++) {
                data[i] = old[i];
            }
        } else {//- - - head t t t t t t tail - - -
            for (int i = headIndex; i <= tailIndex; i++) {
                data[i] = old[i];
            }
        }
    }

}
