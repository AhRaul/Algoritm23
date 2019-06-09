package ru.geekbrains.course23.dz6;

import java.util.ArrayList;

public class MyTreeImpl<E extends Comparable<? super E>> implements MyTree<E> {
    public static final int MAX_QUANTITY_MODE = 63;     //максимально допустимое количество элементов в одном дереве (макс количество, помещающееся в 6 уровней)

    private MyNode<E> root;             //корень
    private ArrayList<MyNode<E>> nodeList = new ArrayList<MyNode<E>>();     //массив, для формирования дерева, проверки симметричности по индексам

    @Override
    public boolean add(E value) {
        if (nodeList.size() >= MAX_QUANTITY_MODE) {
            System.out.println("Дерево заполнено. Расчитано на " + MAX_QUANTITY_MODE + " элементов.");
            return false;
        }

        if(isEmpty()) {                 //если дерево пустое
            root = new MyNode<>(value);
            root.setLevel(1);
            nodeList.add(root);
            return true;
        }

        MyNode<E> currentPlace = findAndTake(value);
        MyNode<E> previousElement = currentPlace.getParent();
        int index = nodeList.indexOf(previousElement);               //индекс родительского элемента в массиве

        if(find(value)) {  //если такой элемент уже присутствует в дереве, то
            System.out.println("Такой элемент уже есть в дереве");
            return false;                                          //не добавлять
        } else {
            MyNode<E> tempValue = new MyNode<>(value);                      //??!! вроде это должно сэкономить память, дав одну и ту же ссылку связанному списку и массиву !!??
            if (previousElement.shouldBeLeft(value)) {              //если можно поместить элемент слева от родителя
                previousElement.setLeftChild(tempValue);
                nodeList.add(index, tempValue);           //помещаем в массив дубликат со сдвигом родительского элемента в массиве вправо
                previousElement.getLeftChild().setLevel(previousElement.getLevel()+1);      //левому ребенку дать +1 лвл от родительского
            } else {
                previousElement.setRightChild(tempValue);
                nodeList.add(index+1, tempValue);           //помещаем в массив дубликат справа от родительского элемента в массиве
                previousElement.getRightChild().setLevel(previousElement.getLevel()+1);      //правому ребенку дать +1 лвл от родительского
            }
        }
        //анализ баланса дерева (с каждой стороны не более одного элемента разницы)

        //1)добавляем элемент к искомому, близжайшему по значению, крайнему элементу (листу) с учетом следующего элемента, для соблюдения порядка

        //3)проверяем баланс, если дерево сбалансированно, оставляем. Если дисбалансируется, то п 4.
        //4)если дерево дисбалансируется добавлением, смещаем проверяемый на баланс корень в сторону меньшей ветви на один элемент,
        //  перестраиваем дерево (тут нужен изменяемый массив, с добавлением по индексу, и смещением остальных вправо,
        //  и средний индекс, для перехода к следующему уровню).

        //5)перезапускаем проверку порядка п.2 (выдать ошибку порядка, если неудача) и баланса п.3 (выдать ошибку баланса, если неудача), оставляем.

        return true;
    }

    @Override
    public boolean remove(E value) {
        return false;
    }

    @Override
    public boolean find(E value) {
        return findAndTake(value).getValue() != null;
    }

    public MyNode<E> findAndTake(E value) {
        MyNode<E> previous = null;
        MyNode<E> current = root;
        while (current != null) {
            if( current.getValue().equals(value) ) {
                return new MyNode<>(value);
            }

            previous = current;
            if (current.shouldBeLeft(value)) {      //если аргумент должен быть слева , то
                current = current.getLeftChild();   //переходим влево
            }
            else {
                current = current.getRightChild();  //переходим вправо
            }
        }

        MyNode<E> returnPlace = new MyNode<>(null);
        returnPlace.setParent(previous);
        return returnPlace;    //возвращает пустую ячейку, подходящую для размещения искомого элемента, привязанную к родителю
    }

    @Override
    public boolean isEmpty() {
        return root == null ;
    }

    @Override
    public boolean isFull() {
        return nodeList.size() >= MAX_QUANTITY_MODE;
    }

    @Override
    public boolean totalBalanced() {                       //запуск метода проверки баланса дерева
        MyNode<E> currentRoot;
        for(int i = 0; i < nodeList.size(); i++) {
            currentRoot = nodeList.get(i);
            if(!balanceTest(currentRoot)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод проверки баланса
     *
     * Принцип работы:
     * 1. Каждый элемент поочереди рекурсивно рассматривается как корень.
     * 2. у рассматриваемого корня справа и слева количество наследников может отличаться не более чем на 1 элемент.
     * 3. расчёт количества ведется от индекса крайнего левого элемента в корне - до индекса корня.
     * 4. и от индекса корня - до индекса крайнего правого элемента в этом корне.
     * 5.  расстояния п.4 и п.5 сравниваются на соблюдение условия п.2.
     * @param current
     * @return
     */
    private boolean balanceTest(MyNode<E> current) {                                                            // метод проверки баланса корня
        if(current != null) {
            int currentID = nodeList.indexOf(current);                                                              //получение ID для рассчёта по порядковому номеру
            if (((currentID - getLeftListID(current) + 1) < (getRightListID(current) - currentID))) {           //если справа или слева от current корня разница в количестве больше, чем на 1 элемент
                return false;
            } else if (((currentID - getLeftListID(current)) > (getRightListID(current) - currentID + 1))) {
                return false;
            }
        }
        return true;
    }

    //метод поиска индекса крайнего левого элемента рассматриваемого корня
    private int getLeftListID (MyNode<E> currentRoot) {
        if(!currentRoot.isLastLeftChild()) {
            return getLeftListID(currentRoot.getLeftChild());
        }
        return nodeList.indexOf(currentRoot);
    }

    //метод поиска индекса крайнего правого элемента рассматриваемого корня
    private int getRightListID (MyNode<E> currentRoot) {
        if(!currentRoot.isLastRightChild()) {
            return getRightListID(currentRoot.getRightChild());
        }
        return nodeList.indexOf(currentRoot);
    }

    public void displayNodeList() {
        for(int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i);
            System.out.print(nodeList.get(i));
        }
        System.out.println("\n" + nodeList.size());
    }


}
