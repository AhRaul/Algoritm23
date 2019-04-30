package ru.geekbrains.course23.linkedlist.stack;

import ru.geekbrains.course23.linkedlist.twoside.TwoSideLinkedListImpl;
import ru.geekbrains.course23.queue.Queue;

public class LinkedQueueImpl<E> implements Queue<E> {

    private TwoSideLinkedListImpl<E> data;

    public LinkedQueueImpl() {
        data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public void insert(E value) {
        data.insertRight(value);
    }

    @Override
    public E remove() {
        return data.removeLeft();
    }

    @Override
    public E peek() {
        return data.getFirstElement();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int getSize() {
        return data.getSize();
    }
}
