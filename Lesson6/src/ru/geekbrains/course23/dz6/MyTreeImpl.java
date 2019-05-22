package ru.geekbrains.course23.dz6;

import java.util.ArrayList;

public class MyTreeImpl<E extends Comparable<? super E>> implements MyTree<E> {
    public static final int MAX_QUANTITY_MODE = 63;     //максимально допустимое количество элементов в одном дереве (макс количество, помещающееся в 6 уровней)

    private MyNode<E> root;             //корень
    private ArrayList<MyNode> nodeList = new ArrayList<>();     //массив, для формирования дерева, проверки симметричности по индексам

    @Override
    public boolean add(E value) {
        if(isEmpty()) {                 //если дерево пустое
            root = new MyNode<>(value);
            nodeList.add(root);
            return true;
        }

        //анализ баланса дерева (с каждой стороны не более одного элемента разницы)

        //1)добавляем элемент к искомому, близжайшему по значению, крайнему элементу (листу) с учетом следующего элемента, для соблюдения порядка
        //2)проверяем порядок элементов (берем предидущий и следующий, ближайший, элемент. Порядок возрастания не должен быть нарушен)

        //3)проверяем баланс, если дерево сбалансированно, оставляем. Если дисбалансируется, то п 4.
        //4)если дерево дисбалансируется добавлением, смещаем проверяемый на баланс корень в сторону меньшей ветви на один элемент,
        //  перестраиваем дерево (тут нужен изменяемый массив, с добавлением по индексу, и смещением остальных вправо,
        //  и средний индекс, для перехода к следующему уровню).

        //5)перезапускаем проверку порядка п.2 (выдать ошибку порядка, если неудача) и баланса п.3 (выдать ошибку баланса, если неудача), оставляем.


        return false;
    }

    @Override
    public boolean remove(E value) {
        return false;
    }

    @Override
    public boolean find(E value) {
        return findAndTake(value).getValue() != null;
    }

    public MyNode findAndTake(E value) {
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
}
