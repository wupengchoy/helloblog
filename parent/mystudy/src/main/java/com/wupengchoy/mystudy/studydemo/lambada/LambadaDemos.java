package com.wupengchoy.mystudy.studydemo.lambada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambadaDemos {
    public static void main(String[] args) {
        //语法
//        List<String> strs = new ArrayList<>();
//        strs.add("c");
//        strs.add("a");
//        strs.add("f");
//        strs.add("b");
//        strs.add("d");
//        strs.sort(String::compareTo);
//        strs.stream().sorted(String::compareTo).sorted(Comparator.reverseOrder());
//        strs.forEach(System.out::println);
//
//        List<String> newStrs = strs.stream().filter(s -> s.equals("c")).collect(Collectors.toList());
//        newStrs.forEach(System.out::println);
        /**
         * Predicate
         */
        List<Foo> foos = Arrays.asList(new Foo[]{new Foo(11), new Foo(22), new Foo(33), new Foo(44)});
//        foos.forEach(i -> System.out.println(i));
        //        List<Foo> afterFilter = filter(foos, foo -> foo.index >= 22);
//        afterFilter.forEach(System.out::println);
        /**
         Function
         */
//        List<Integer> indexs = map(foos, Foo::getIndex);
//        indexs.forEach(System.out::println);
        /**
         * Consumer
         */
//        reIndex(foos, foo -> foo.index++);
//        foos.forEach(System.out::println);

        /**
         * 方法引用
         */
//        int newIndex = 777;
//        changeIndex(foos, 777, Foo::setIndex);
//        foos.forEach(System.out::println);
        /**
         * this是什么
         */
//        new Foo(123).thisObj();
        /**
         * default 方法--继承、覆盖，多级继承，冲突处理
         */
//        new Foo(1).hello();
        System.out.println(foos.stream().mapToInt(Foo::getIndex).sum());
    }

    public static <E> void reIndex(List<E> list, Consumer<E> consumer) {
        for (E e : list) {
            consumer.accept(e);
        }
    }

    public static <E> List<E> filter(List<E> list, Predicate<E> pred) {
        List<E> result = new ArrayList<E>();
        for (E e : list) {
            if (pred.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static <E, R> List<R> map(List<E> list, Function<E, R> function) {
        List<R> result = new ArrayList<>();
        for (E e : list) {
            result.add(function.apply(e));
        }
        return result;
    }

    public static <E, K> void changeIndex(List<E> list, K index, BiConsumer<E, K> biConsumer) {
        for (E e : list) {
            biConsumer.accept(e, index);
        }
    }
}

class Foo implements IFoo {
    int index = 0;

    public Foo(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

//    @Override
//    public String toString() {
//        return this.index + ":"+this.getClass();
//    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void thisObj() {
        Arrays.asList(new int[]{1, 2}).forEach(i -> System.out.println(this.toString()));
    }

    @Override
    public void hello() {
        System.out.println("hello2");
    }
}

interface IFoo {
    default void hello() {
        System.out.println("hello1");
    }
}
