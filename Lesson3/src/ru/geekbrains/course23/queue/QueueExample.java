package ru.geekbrains.course23.queue;

import ru.geekbrains.course23.stack.Stack;
import ru.geekbrains.course23.stack.StackImpl;

public class QueueExample {

    public static void main(String[] args) {
        Queue<Integer> queue = new QueueImpl<>(3);
        addIfNotFull(queue, 1);
        addIfNotFull(queue, 2);
        addIfNotFull(queue, 3);
        addIfNotFull(queue, 4);

        removeIfNotEmpty(queue);
        removeIfNotEmpty(queue);
        removeIfNotEmpty(queue);
        removeIfNotEmpty(queue);
        removeIfNotEmpty(queue);
        removeIfNotEmpty(queue);
        removeIfNotEmpty(queue);
    }

    private static void removeIfNotEmpty(Queue<Integer> queue) {
        if( !queue.isEmpty() ) {
            System.out.println(queue.remove());
        }
    }

    private static void addIfNotFull(Queue<Integer> queue, int value) { //нажатие на выделенном блоке кода ctrl+Alt+M для упаковки его в метод
        if ( !queue.isFull() ) {
            queue.insert(value);
        }
    }
}
