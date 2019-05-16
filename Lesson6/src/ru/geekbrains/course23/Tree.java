package ru.geekbrains.course23;

public interface Tree<E extends Comparable<? super E>> {

    enum TraverseMode {
        IN_ORDER,       //симметричный обход дерева
        PRE_ORDER,      //прямой обход
        POST_ORDER,     //обратный обход
    }

    boolean add(E value);

    boolean remove(E value);

    boolean find(E value);

    boolean isEmpty();

    void display();

    //метод для обхода
    void traverse(TraverseMode traverseMode);

}
