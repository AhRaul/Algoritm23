package ru.geekbrains.course23.deque;

public class DequeImpl<E> implements Deque<E> {

    public static final int DEFAULT_DEQUE_FRONT = -1;
    public static final int DEFAULT_DEQUE_REAR = 0;

    protected E[] data;
    protected int size;

    private int front;  //начало очереди
    private int rear;   //конец очереди

    @SuppressWarnings("unchecked")
    public DequeImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        front = DEFAULT_DEQUE_FRONT;                              //авто вынос в константу ctrl+alt+c по выделенному числу;
        rear = DEFAULT_DEQUE_REAR;
    }

    @Override
    public void insertFront(E value) {
        // check whether Deque if  full or not
        if (isFull())
        {
            System.out.println("Overflow");
            return;
        }
        // If queue is initially empty
        if (front == DEFAULT_DEQUE_FRONT)
        {
            front = 0;
            rear = 0;
        }
        // front is at first position of queue
        else if (front == 0)
            front = data.length - 1 ;
        else // decrement front end by '1'
            front--;
        // insert current element into Deque
        data[front] = value ;
        size++;
    }

    @Override
    public void insertRear(E value) {
        if (isFull())
        {
            System.out.println(" Overflow ");
            return;
        }

        // If queue is initially empty
        if (front == -1)
        {
            front = 0;
            rear = 0;
        }

        // rear is at last position of queue
        else if (rear == data.length-1)
            rear = 0;

            // increment rear end by '1'
        else
            rear = rear+1;

        // insert current element into Deque
        data[rear] = value ;
        size++;
    }

    @Override
    public E deleteFront() {
        // check whether Deque is empty or not
        if (isEmpty()) {
            System.out.println("Queue Underflow\n");
            return null;
        }

        E revovedValue;
        // Deque has only one element
        if (front == rear) {
            revovedValue = data[front];
            front = -1;
            rear = -1;
        } else
            // back to initial position
            if (front == data.length - 1) {
                revovedValue = data[front];
                front = 0;
            }
            else // increment front by '1' to remove current
                // front value from Deque
            {
                revovedValue = data[front];
                front++;
            }
        size--;
        return revovedValue;
    }

    @Override
    public E deleteRear() {
        if (isEmpty()) {
            System.out.println(" Underflow");
            return null;
        }

        E revovedValue;
        // Deque has only one element
        if (front == rear)  {
            revovedValue = data[rear];
            front = -1;
            rear = -1;
        }
        else if (rear == 0) {
            revovedValue = data[rear];
            rear = data.length - 1;
        }  else {
            revovedValue = data[rear];
            rear--;
        }
        size--;
        return revovedValue;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public E getRear() {
        return data[rear];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public int getSize() {
        return size;
    }
}
