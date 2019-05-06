package ru.geekbrains.course23;

public interface Array<E> {

    void add(E value);

    boolean remove(E value);
    void remove(int index);

    E get(int index);

    boolean contains(E value);
    int indexOf(E value);

    int size();
    boolean isEmpty();

    void sortBubble();

    void sortSelect();

    void sortInsert();

}