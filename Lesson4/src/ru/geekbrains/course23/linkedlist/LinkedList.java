package ru.geekbrains.course23.linkedlist;

public interface LinkedList<E> extends Iterable<E> {

    void insert(E value);

    E remove();

    boolean remove(E value);

    boolean isEmpty();

    int getSize();

    boolean find(E value);

    void display();

    E getFirstElement();

    Entry<E> getFirst();

    void setFirst(Entry<E> value);
}
