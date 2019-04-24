package ru.geekbrains.course23.stack;

public interface Stack<E> {

    /**
     * метод, добавляющий значение в вершину стека
     * @param value - значение, принимаемое в вершину стека
     */
    void push(E value);

    /**
     * возвращает вершину стека и удаляет её из стека
     * @return значение вершины стека
     */
    E pop();

    /**
     * читает, возвращает вершину стека, не меняя стек
     * @return значение вершины стека
     */
    E peek();

    /**
     * Утилитный метод, пустой ли стек
     * @return  true - стек пустой, false - стек не пустой
     */
    boolean isEmpty();

    /**
     * Утилитный метод, заполнен ли стек до предела
     * @return true - стек заполнен до предела, false - стек не заполнен до предела
     */
    boolean isFull();

    /**
     * Утилитный метод, врзвращает текущее кол-во элементов в стеке
     * @return количество элементов в стеке
     */
    int getSize();
}