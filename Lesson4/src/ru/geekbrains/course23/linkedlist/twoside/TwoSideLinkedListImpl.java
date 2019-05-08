package ru.geekbrains.course23.linkedlist.twoside;

import ru.geekbrains.course23.linkedlist.Entry;
import ru.geekbrains.course23.linkedlist.EntryImpl;
import ru.geekbrains.course23.linkedlist.SimpleLinkedListImpl;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    private Entry<E> lastElement;

    @Override
    public void insertLeft(E value) {
        super.insert(value);
        if(getSize() == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public void insertRight(E value) {
        Entry<E> newElement = new EntryImpl<>(value);
        if(isEmpty()) {
            firstElement = newElement;
        }
        else {
            lastElement.setNext(newElement);
        }
        lastElement = newElement;
        size++;

    }

    @Override
    public E removeLeft() {
        E removedValue = super.remove();
        if (isEmpty()) {
            lastElement = null;
        }
        return removedValue;
    }

    @Override
    public boolean remove(E value) {        //разворачивание метода на ctrl+Alt+N
        Entry<E> currentElement = firstElement;
        Entry<E> previousElement = null;
        while (currentElement != null) {
            if(currentElement.getValue().equals(value)) {
                break;
            }
            previousElement = currentElement;
            currentElement = currentElement.getNext();
        }

        if(currentElement == null) {
            return false;
        }

        if(currentElement == firstElement) {
            firstElement = firstElement.getNext();
        } else if (currentElement == lastElement) {
            lastElement = previousElement;
            previousElement.setNext(null);          //!!?? почему тут previousElement а не lastElement, либо нужно выше писать эту строчку кода ??!!
        } else {
            previousElement.setNext(currentElement.getNext());
        }

        size--;
        return true;
    }
}
