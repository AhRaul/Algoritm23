package ru.geekbrains.course23.hw323onlesson423;

import ru.geekbrains.course23.deque.Deque;
import ru.geekbrains.course23.stack.Stack;
import ru.geekbrains.course23.stack.StackImpl;

//решение дз3 на лекции 4
public class Lesson3DZMain {


    public static void main(String[] args) {
        //Задание 2
//        String str = "abcd";
//
//        Stack<Character> st = new StackImpl<>(str.length());
//        for (int i = 0; i < str.length(); i++) {
//            st.push(str.charAt(i));
//        }
//
//        while ( !st.isEmpty() ) {
//            System.out.print(st.pop());
//        }
//        System.out.println();


        //Задание 3
        Deque2<Integer> deq = new DequeImpl2<>(6);

        insertRight(deq, 1);
        insertRight(deq, 2);
        insertRight(deq, 3);
        insertRight(deq, 4);    // 1234
        insertLeft(deq, 5);    // 51234
        insertLeft(deq, 6);    // 651234

        removeLeft(deq);             //51234
        removeRight(deq);            //5123

//        displayLeftToRight(deq);    //Queue
        displayRightToLeft(deq);    //Stack
    }

    private static <E> void insertRight(Deque2<E> deq, E value) {
        if(!deq.isFull()) {
            deq.insertRight(value);
        }
    }

    private static <E> void insertLeft(Deque2<E> deq, E value) {
        if(!deq.isFull()) {
            deq.insertLeft(value);
        }
    }

    private static <E> void removeLeft(Deque2<E> deq) {
        if(!deq.isEmpty()) {
            deq.removeLeft();
        }
    }

    private static <E> void removeRight(Deque2<E> deq) {
        if(!deq.isEmpty()) {
            deq.removeRight();
        }
    }

    private static <E> void displayLeftToRight(Deque2<E> deq) {
        while (!deq.isEmpty()) {
            System.out.println(deq.removeLeft());
        }
    }

    private static <E> void displayRightToLeft(Deque2<E> deq) {
        while (!deq.isEmpty()) {
            System.out.println(deq.removeRight());
        }
    }
}
