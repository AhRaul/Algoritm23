package ru.geekbrains.course23.iterator;

import ru.geekbrains.course23.linkedlist.Entry;
import ru.geekbrains.course23.linkedlist.LinkedList;
import ru.geekbrains.course23.linkedlist.SimpleLinkedListImpl;

import java.util.Iterator;
import java.util.List;

public class TestIterator {

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3};

//        for(int i = 0; i<intArray.length; i++) {
//            System.out.println(intArray[i]);
//        }

        for (Integer value: intArray) {
            System.out.println(value);
        }

        System.out.println("-----");

        List<Integer> arrayList = List.of(1, 2, 3);
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }

        for (Integer value: arrayList) {
            System.out.println(value);
        }

        java.util.LinkedList<Integer> linkedListJdk = new java.util.LinkedList<>();
        linkedListJdk.add(1);
        linkedListJdk.add(2);
        linkedListJdk.add(3);

        for (Integer value : linkedListJdk) {
            System.out.println(value);
        }

        Iterator<Integer> iterator = linkedListJdk.iterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }

        System.out.println("-----");

        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);

        Entry<Integer> current = linkedList.getFirst();
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }

        //дз423 задание3
//        for (Integer value : linkedList) {
//            System.out.println(value);
//        }

        //дз423 задание 2
        System.out.println("-----");

        LinkedList<Integer> iterableList = new SimpleLinkedListImpl<>();
        LinkIterator itr = new LinkIterator(iterableList);

        itr.insertAfter(4);
        itr.insertAfter(5);
        itr.insertAfter(6);                      //  ??!! Почему такой порядок insertAfter  ??!!
        itr.insertBefore(3);
        itr.reset();                //сброс указателей (тут ничего не произошло)
        itr.insertBefore(2);
        itr.insertBefore(1);

        itr.deleteCurrent();        //удаление последнего введенного значения (1)

        itr.reset();                //сброс указателей (тут ничего не произошло)
        itr.atEnd();                //проверка конца (тут ничего не произошло)
        itr.nextLink();             //переход к следующему значению
        itr.nextLink();             //переход к следующему значению

        iterableList.display();

        System.out.println(itr.getCurrent().getValue());    //вывод текущего значения (4)

    }

}
