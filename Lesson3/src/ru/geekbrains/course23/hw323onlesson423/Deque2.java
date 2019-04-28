package ru.geekbrains.course23.hw323onlesson423;

import ru.geekbrains.course23.queue.Queue;

public interface Deque2<E> extends Queue<E> {

    void insertLeft(E value);
    void insertRight(E value);

    E removeLeft();
    E removeRight();
}
