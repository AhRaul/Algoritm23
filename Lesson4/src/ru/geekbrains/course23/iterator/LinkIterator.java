package ru.geekbrains.course23.iterator;

import ru.geekbrains.course23.linkedlist.Entry;
import ru.geekbrains.course23.linkedlist.EntryImpl;
import ru.geekbrains.course23.linkedlist.LinkedList;

public class LinkIterator<E> {
    private Entry<E> current;               //рассматриваемое значение
    private Entry<E> previous;              //предидущее значение
    private LinkedList<E> linkedList;       //итерируемый связанный список


    public LinkIterator(LinkedList<E> linkedList) {
        this.linkedList = linkedList;
        this.reset();
    }

    //обнулить счетчики итератора при инициализации
    public void reset() {
        current = linkedList.getFirst();
        previous = null;
    }

    //если конец массива - true
    public boolean atEnd() {
        return (current.getNext() == null);
    }

    //перенос счетчиков итератора к следующему значению
    public void nextLink() {
        previous = current;
        current = current.getNext();
    }

    //получить текущее значение
    public Entry<E> getCurrent() {
        return current;
    }

    //установка следующего значения аргумента в итератор после current значения
    public void insertAfter(E value) {
        Entry<E> newLink = new EntryImpl<>(value);
        if(linkedList.isEmpty()) {
            linkedList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.setNext(current.getNext());
            current.setNext(newLink);
            nextLink();
        }
    }

    //установка значения аргумента перед current значением
    public void insertBefore(E value) {
        Entry<E> newLink = new EntryImpl<>(value);
        if(previous == null) {
            newLink.setNext(linkedList.getFirst());
            linkedList.setFirst(newLink);
            reset();
        } else {
            newLink.setNext(previous.getNext());
            previous.setNext(newLink);
            current = newLink;
        }
    }

    //удалить текущий элемент из списка
    public E deleteCurrent() {
        E value = current.getValue();
        if(previous == null) {
            linkedList.setFirst(current.getNext());
            reset();
        } else  {
            previous.setNext(current.getNext());
            if(atEnd()) {
                reset();                                //??!! Зачем ?!!
            } else {
                current = current.getNext();
            }
        }
        return value;
    }


}
