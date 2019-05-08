package ru.geekbrains.course23.linkedlist;

public interface Entry<T> {

    //значение элемента
    T getValue();

    //получить следующий элемент
    Entry<T> getNext();

    //задать следующий элемент
    void setNext(Entry<T> nextElement);
}
