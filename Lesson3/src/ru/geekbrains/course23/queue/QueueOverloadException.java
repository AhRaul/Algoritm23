package ru.geekbrains.course23.queue;

public class QueueOverloadException extends RuntimeException {

    public static QueueOverloadException queueIsEmpty() {
        return new QueueOverloadException("Queue is empty!");
    }

    public static QueueOverloadException queueIsFull() {
        return new QueueOverloadException("Queue is full!");
    }

    public QueueOverloadException(String message) {
        super(message);
    }
}
