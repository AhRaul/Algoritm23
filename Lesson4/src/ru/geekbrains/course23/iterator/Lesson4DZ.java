package ru.geekbrains.course23.iterator;

import ru.geekbrains.course23.linkedlist.LinkedList;
import ru.geekbrains.course23.linkedlist.SimpleLinkedListImpl;

public class Lesson4DZ {

    public static void main(String[] args) {
        LinkedList<Integer> list = new SimpleLinkedListImpl<>();
        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(1);

        displayAll(list);

        System.out.println("----------");

        ListIterator<Integer> iterator = (ListIterator) list.iterator();
        iterator.reset();                 //1! 2 3 4
        iterator.insertAfter(11);   //1 11! 2 3 4
        iterator.next();                  //1 11 2! 3 4
        iterator.remove();                //1 11 3! 4
        iterator.insertBefore(0);   //1 11 0! 3 4

        displayAll(list);
    }

    private static void displayAll(LinkedList<Integer> list) {
        for (Integer value : list) {
            System.out.println(value);
        }
    }
}
