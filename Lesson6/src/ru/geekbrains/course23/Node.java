package ru.geekbrains.course23;

import java.util.Objects;

//элемент
public class Node<T extends Comparable<? super T>> {

    private final T value;

    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node (T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean shouldBeLeft(T anotherValue) {
        if(anotherValue == null) {
            throw new IllegalArgumentException("Not null value is required");
        }
        return anotherValue.compareTo(value) < 0;
    }

    public boolean isLeaf() {           //проверка элемента, лист ли это
        return leftChild == null && rightChild == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
