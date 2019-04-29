package ru.geekbrains.course23.queue;

//интерфейс очередь
public interface Queue<E> {

    void insert(E value);

    E remove();

    E peek();

    boolean isEmpty();

    boolean isFull();

    int getSize();
}
