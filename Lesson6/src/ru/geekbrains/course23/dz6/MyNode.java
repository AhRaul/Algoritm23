package ru.geekbrains.course23.dz6;

import java.util.Objects;

public class MyNode<T extends Comparable<? super T>> {

    private final T value;

    private MyNode<T> parent;           //родитель
    private MyNode<T> leftChild;
    private MyNode<T> rightChild;

    private int level;                  //уровень в древе

    public MyNode (T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public MyNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MyNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public MyNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(MyNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public MyNode<T> getParent() {
        return parent;
    }

    public void setParent(MyNode<T> parent) {
        this.parent = parent;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean shouldBeLeft(T anotherValue) {       //если аргумент меньше this, то < 0 т.е. true, и агрументу стоит быть слева
        if(anotherValue == null) {
            throw new IllegalArgumentException("Not null value is required");
        }
        return anotherValue.compareTo(value) < 0;
    }

    public boolean isLast() {       //проверить нет ли наследников
        return leftChild == null && rightChild == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyNode<?> myNode = (MyNode<?>) o;
        return Objects.equals(value, myNode.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "value=" + value +
                '}';
    }
}
