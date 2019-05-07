package com.wupengchoy.mystudy.datastructure.hash;

import java.util.LinkedList;
import java.util.List;

/**
 * 散列--分离连接法
 * create by wupengchoy
 * 2019-05-07
 */
public class SeperateChainingHashTable<T> {
    private static final int DEFAULT_TABLE_SIZE = 16;
    private List<T>[] lists;
    private int currentSize;

    public SeperateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeperateChainingHashTable(int defaultSize) {
        //散列表的长度最好是质数，这样，散列出来的数据才能均匀分布
        lists = new LinkedList[nextPrime(defaultSize)];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
    }

    /**
     * 判断当前树是否是一个质数，如果不是，获取下一个质数
     *
     * @param num
     * @return
     */
    private int nextPrime(int num) {
        while (!isPrime(num)) {
            num++;
        }
        return num;
    }

    private boolean isPrime(int num) {
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取散列下标
     *
     * @param t
     * @return
     */
    private int hash(T t) {
        int hashVal = t.hashCode();
        hashVal %= lists.length;
        if (hashVal < 0) {
            hashVal += lists.length;
        }
        return hashVal;
    }

    /**
     * 再散列
     */
    private void reHash() {
        List<T>[] oldLists = lists;
        lists = new LinkedList[nextPrime(2 * lists.length)];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
        for (int i = 0; i < oldLists.length; i++) {
            for (T t : oldLists[i]) {
                insert(t);
            }
        }
    }

    private void clear() {
        for (int i = 0; i < lists.length; i++) {
            lists[i].clear();
        }
        this.currentSize = 0;
    }

    public void insert(T t) {
        List<T> list = lists[hash(t)];
        if (!list.contains(t)) {
            list.add(t);
            if (++currentSize > lists.length) reHash();
        }
    }

    public boolean contains(T t) {
        return lists[hash(t)].contains(t);
    }

    public void remove(T t) {
        lists[hash(t)].remove(t);
        this.currentSize--;
    }

}

class Foo {
    private String name;

    /**
     * 为什么String使用31作为乘子?
     * 第一，31是一个不大不小的质数，是作为 hashCode 乘子的优选质数之一。
     * 另外一些相近的质数，比如37、41、43等等，也都是不错的选择。那么为啥偏偏选中了31呢？请看第二个原因。
     * 第二、31可以被 JVM 优化，31 * i = (i << 5) - i。
     *
     * @return
     */
    @Override
    public int hashCode() {
        int h = 0;
        if (name.length() > 0) {
            char val[] = name.toCharArray();
            for (int i = 0; i < name.length(); i++) {
                h = 31 * h + val[i];
            }
        }
        return h;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Foo)) {
            return false;
        }
        Foo foo = (Foo) obj;
        if (this.name == null && foo.name == null) return true;
        return this.name.equals(foo.name);
    }
}
