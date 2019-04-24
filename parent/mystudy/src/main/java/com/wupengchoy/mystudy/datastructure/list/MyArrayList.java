package com.wupengchoy.mystudy.datastructure.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPCITY = 10;
    private int size;
    private T[] items;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        size = 0;
        ensureCapcity(DEFAULT_CAPCITY);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapcity(size());//去除数组中的空值，节省空间,
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[index];
    }

    public T set(int index, T newValue) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = items[index];
        items[index] = newValue;
        return old;
    }

    public void add(int index, T newValue) {
        if (index == size()) {
            ensureCapcity(size() * 2 + 1);//扩容
        }
        //index后的元素后移一位
        for (int i = size(); i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = newValue;
        this.size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        T removed = items[index];
        for (int i = index; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        this.size--;
        return removed;
    }

    //用来扩容并赋值
    public void ensureCapcity(int capcity) {
        if (capcity < size) {
            return;
        }
        T[] old = items;
        items = (T[]) new Object[capcity];
        for (int i = 0; i < size; i++)//size是扩容前的值
        {
            items[i] = old[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    class ArrayListIterator implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);//next()中已经加1了，所以要先减1
        }
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size(); i++) {
            result = result.concat(String.valueOf(items[i])).concat(",");
        }
        result = result.concat("]");
        return result;
    }
}
