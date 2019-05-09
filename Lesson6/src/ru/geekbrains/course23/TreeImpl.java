package ru.geekbrains.course23;

import javax.management.relation.InvalidRelationIdException;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;

    @Override
    public boolean add(E value) {
        if ( root == null ) {
            root = new Node<> (value);
            return true;
        }

        NodeAndPrevious nodeAndPrevious = doFind(value);
        Node<E> previous = nodeAndPrevious.previous;


        if(previous.shouldBeLeft(value)) {
            previous.setLeftChild(new Node<> (value));
        }
        else {
            previous.setRightChild(new Node<> (value));
        }

        return true;
    }

    @Override
    public boolean remove(E value) {
        return false;
    }

    @Override
    public boolean find(E value) {
        NodeAndPrevious nodeAndPrevious = doFind(value);
        return nodeAndPrevious.current != null;
    }

    private NodeAndPrevious doFind(E value) {
        Node<E> previous = null;
        Node<E> current = root;
        while(current != null) {
            if( current.getValue().equals(value) ) {        //если встретился эквивалентный элемент, добавить не удастся
                return new NodeAndPrevious(current, previous);
            }

            previous = current;
            if (current.shouldBeLeft(value)) {
                current = current.getLeftChild();
            }
            else {
                current = current.getRightChild();
            }
        }

        return new NodeAndPrevious(current, previous);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void display() {

    }

    class NodeAndPrevious {
        Node<E> current;
        Node<E> previous;

        public NodeAndPrevious(Node<E> current, Node<E> previous) {
            this.current = current;
            this.previous = previous;
        }
    }
}
