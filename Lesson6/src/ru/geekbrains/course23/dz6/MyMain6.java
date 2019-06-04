package ru.geekbrains.course23.dz6;

public class MyMain6 {
    public static void main(String[] args) {
        MyTree<Integer> myTree = new MyTreeImpl<>();
        myTree.add(66);
        myTree.add(23);
        myTree.add(22);
        myTree.add(24);
//        myTree.add(25);
        myTree.add(68);
        myTree.add(66);
        myTree.add(69);
//        myTree.add(69);
//        myTree.add(70);
//        myTree.add(60);

//        while (!myTree.isFull()) {                              //генерировать случайные числа от -100 до 100, пока дерево не заполнится
//            myTree.add((int)(Math.random() * 200) - 100);
//        }

//        for(int i = 1; i < 65; i++) {
//            myTree.add(i);
//        }

        System.out.println("Find 63: " + myTree.find(63));
        System.out.println("Find 25: " + myTree.find(25));
        System.out.println("Find 66: " + myTree.find(66));
        System.out.println("Find 65: " + myTree.find(65));

        ((MyTreeImpl<Integer>) myTree).displayNodeList();
        System.out.println("Проверка баланса " + myTree.totalBalanced());
    }
}
