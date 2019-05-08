package ru.geekbrains.course23.linkedlist;

import ru.geekbrains.course23.iterator.ListIterator;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>{

    protected Entry<E> firstElement;
    protected int size;

    @Override
    public void insert(E value) {
        Entry<E> newElement = new EntryImpl<>(value);   //создание элемента
        newElement.setNext(firstElement);               //добавление ссылки на предыдущий элемент
        firstElement = newElement;
        size++;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        Entry<E> removedElement = firstElement;
        firstElement = firstElement.getNext();

        size--;
        return removedElement.getValue();
    }

    //удаление подходящего по значению элемента
    @Override
    public boolean remove(E value) {
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
        } else {
            previousElement.setNext(currentElement.getNext());
        }

        size--;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    //если такой элемент (value) есть, true
    @Override
    public boolean find(E value) {
        return doFind(value) != null;
    }

    //поиск элемента по значению
    private Entry<E> doFind(E value) {
        Entry<E> currentElement = firstElement;
        while (currentElement != null) {
            if(currentElement.getValue().equals(value)) {
                return currentElement;
            }
            currentElement = currentElement.getNext();
        }

        return null;
    }

    @Override
    public void display() {
        System.out.println("-------");
        System.out.println("display " + this.getClass().getSimpleName());

        Entry<E> current = firstElement;
        while(current != null) {
            System.out.println(current);
            current = current.getNext();
        }

        System.out.println("-------");
    }

    @Override
    public E getFirstElement() {
        return firstElement.getValue();
    }

    @Override
    public Entry<E> getFirst() {
        return firstElement;
    }

    @Override
    public void setFirst(Entry<E> value) {
        firstElement = value;
        if (this.isEmpty()) {
            size++;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(this);
    }



    private static class LinkedListIterator<E> implements ListIterator<E> {

        private SimpleLinkedListImpl list;

        private Entry<E> current;
        private Entry<E> previous;

        public LinkedListIterator(SimpleLinkedListImpl list) {
            this.list = list;
            reset();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E nextValue = current.getValue();
            previous = current;
            current = current.getNext();
            return nextValue;
        }

        @Override
        public void remove() {
            if (previous == null){
                list.firstElement = current.getNext();
                reset();
            } else {
                previous.setNext(current.getNext());
                if ( !hasNext() ) {
                    reset();
                } else {
                    current = current.getNext();
                }
            }
        }

        @Override
        public void reset() {
            current = list.firstElement;
            previous = null;
        }

        @Override
        public void insertBefore(E value) {
            Entry newItem = new EntryImpl(value);
            if(previous == null) {
                newItem.setNext(list.firstElement);
                list.firstElement = newItem;
                reset();
            }
            else {
                newItem.setNext(previous.getNext());
                previous.setNext(newItem);
                current = newItem;
            }
        }

        @Override
        public void insertAfter(E value) {
            Entry newItem = new EntryImpl(value);
            if(list.isEmpty()) {
                list.firstElement = newItem;
                current = newItem;
            } else {
                newItem.setNext(current.getNext());
                current.setNext(newItem);
                next();
            }
        }
    }
}
