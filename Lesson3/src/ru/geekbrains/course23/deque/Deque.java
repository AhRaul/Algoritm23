package ru.geekbrains.course23.deque;

//Интерфейс Дек
public interface Deque <E> {

    /**
     * установка обьекта в начало очереди
     * @param value - устанавливаемый обьект
     */
    void insertFront(E value);

    /**
     * Установка обьекта в конец очереди
     * @param value - устанавливаемый обьект
     */
    void insertRear(E value);

    /**
     * Удаление обьекта из начала
     * @return - удаляемый обьект из начала
     */
    E deleteFront();

    /**
     * Удаление обьекта из конца
     * @return - удаляемый обьект из конца
     */
    E deleteRear();

    /**
     * получение обьекта из начала без удаления
     * @return - получаемый объект из начала
     */
    E getFront();

    /**
     * получение обьекта из конца без удаления
     * @return - получаемый обьект из конца
     */
    E getRear();

    /**
     * Если очередь пуста
     * @return true - если пуста
     */
    boolean isEmpty();

    /**
     * Если очередь переполнена
     * @return true - если переполнена
     */
    boolean isFull();

    /**
     * количество обьектов в очереди
     * @return - int количество обьектов
     */
    int getSize();
}
