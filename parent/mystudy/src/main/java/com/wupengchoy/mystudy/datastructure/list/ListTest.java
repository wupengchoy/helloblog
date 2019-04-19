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


//        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
//        stack.push(1);
//        System.out.println("peek" + stack.peek());
//        System.out.println("size" + stack.size());
//        System.out.println("pop" + stack.pop());
//        System.out.println("size" + stack.size());
//
//        for (int i = 1; i <= 20; i++) {
//            stack.push(i);
//        }
//
//        System.out.println("size" + stack.size());

        /**
         * 算式的逆波兰记法
         * a+b*c+(d*e+f)*g
         * 输出：a b c * + d e * f + g * +
         * 思路：读取算式，将遇到的数字输出，在栈中储存符号，在读取到下一个符号的时候判断栈顶
         * 符号优先级，如果栈顶符号优先级高于当前读出的符号，则优先输出栈顶符号
         */
        //TODO


        MyArrayQueue<Integer> queue = new MyArrayQueue<>();
        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.size());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue.size());
        for (int i = 21; i <= 43; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.size());
    }
}
