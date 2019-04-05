package com.wupengchoy.mystudy.datastructure.list;

public class ListTest {
    public static void main(String[] args) {
//        MyArrayList<Integer> list = new MyArrayList<>();
//        list.add(0,11);
//        list.add(1,12);
//        list.add(2,13);
//        list.add(3,14);
//        list.add(4,15);
//        System.out.println(list.toString());
//        list.remove(2);
//        System.out.println(list.toString());
//        Iterator iterator = list.iterator();
//        while(iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }

//        MyLinkedList<String> list = new MyLinkedList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add(2,"22");
//        System.out.println(list.size());
//        System.out.println(list);
//        list.remove(3);
//        System.out.println(list);
//        Iterator<String> iterator = list.iterator();
//        String str;
//        while(iterator.hasNext())
//        {
//            str = iterator.next();
//            if("22".equals(str))
//            {
//                iterator.remove();
//                continue;
//            }
//            System.out.println(str);
//        }
//        System.out.println(list);


        MyArrayStack<Integer> stack = new MyArrayStack<>();
        stack.push(1);
        System.out.println("peek" + stack.peek());
        System.out.println("size" + stack.size());
        System.out.println("pop" + stack.pop());
        System.out.println("size" + stack.size());

        for (int i = 1; i <= 20; i++) {
            stack.push(i);
        }

        System.out.println("size" + stack.size());

    }
}
