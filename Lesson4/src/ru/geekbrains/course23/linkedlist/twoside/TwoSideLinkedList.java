package ru.geekbrains.course23.linkedlist.twoside;

import ru.geekbrains.course23.linkedlist.LinkedList;

public interface TwoSideLinkedList<E>  extends LinkedList<E> {

    void insertLeft(E value);
    void insertRight(E value);

    E removeLeft();
}
