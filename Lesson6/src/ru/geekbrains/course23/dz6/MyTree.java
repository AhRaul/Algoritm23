package ru.geekbrains.course23.dz6;

public interface MyTree<E extends Comparable<? super E>> {

    boolean add(E value);

    boolean remove(E value);

    boolean find(E value);

    boolean isEmpty();

    boolean isFull();       //если достигнут установленный предел заполненности дерева

    boolean totalBalanced();   //проверка баланса

}
