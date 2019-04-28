package ru.geekbrains.course23.hw323onlesson423;

import ru.geekbrains.course23.queue.QueueImpl;

public class DequeImpl2<E> extends QueueImpl<E> implements Deque2<E> {

    public DequeImpl2(int maxSize) {
        super(maxSize);
    }

    @Override
    public void insertRight(E value) {
        super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }


    @Override
    public void insertLeft(E value) {
        if(front - 1 < 0)
            front = data.length;

        data[--front] = value;
        size++;
    }

    @Override
    public E removeRight() {
        if(rear < 0)
            rear = data.length - 1;

        size--;
        return data[rear--];
    }
}
