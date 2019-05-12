package ru.geekbrains.course23.bag;

import java.util.ArrayList;
import java.util.List;

public class Packing {

    private static Thing[] things;
    private static List<Thing[]> result = new ArrayList<>();

    public static void main(String[] args) {
        //создаю сумку
        Bag portfel = new Bag(7);

        //создаю предметы для укладки в сумку
        Thing brick = new Thing(5, 17);
        Thing phone = new Thing(1, 50000);
        Thing laptop = new Thing(2, 20000);
        Thing cat = new Thing(4, 5);
        Thing book = new Thing(1, 200);
        Thing waterBalon = new Thing(10, 30);

        //сложение предметов в массив
        things = new Thing[4];              //обьем рассматриваемых весчей для упаковки
        things[0] = brick;
        things[1] = phone;
        things[2] = laptop;
        things[3] = cat;
//        things[4] = book;
//        things[5] = waterBalon;

        //упаковка в сумку предметов, наибольшей суммарной стоимости
        optimalPacking(portfel, things);
    }


    private static void optimalPacking(Bag bag, Thing[] things) {
        int summaryThingsWeight = 0;                  //суммарный вес всех весчей
        for (int i = 0; i<things.length; i++) {
            summaryThingsWeight = summaryThingsWeight + things[i].getWeight();
        }

        if(bag.getBagCapacity() >= summaryThingsWeight) {   //если суммарный вес умещается в рюкзак, то упаковать всё в рюкзак, и отценить
            for (int i = 0; i<things.length; i++) {
                things[i].putInABag(bag);
            }
            System.out.println("Стоймость сумки: " + bag.getBagPrice());
        } else {                                            //или упаковать все анаграммы поочередно
            getAnagramm(bag);
        }
    }

    public static void getAnagramm(Bag bag) {
        if(things.length == 1) {             //если предмет всего 1, попробовать упаковать, и показать стоймость рюкзака
            if(things[0].putInABag(bag)) {
                System.out.println("Единственная весч поместилась, её стоймость: " + bag.getBagPrice());
                return;
            } else {
                System.out.println("Весчь не поместилась.");
                return;
            }
        }
        getAnagramm(things.length);
        runToAnagramm(bag);                         //пробежка по анаграммам, упаковка c первого элемента, пока помещается
    }

    public static void getAnagramm(int length) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            getAnagramm(length - 1);
            result.add(things);
            rotate(length);
        }
    }

    private static void rotate(int length) {
        int pos = things.length - length;
        Thing temp = things[pos];
        for(int i = pos +1; i<things.length; i++) {
            things[i-1] = things[i];
        }
        things[things.length - 1] = temp;
    }


    private static void runToAnagramm(Bag bag) {
        int tempPrice = 0;                              //хранение максимальной стоймости
        for (int i = 0; i < result.size(); i++) {       //пробежка по анаграммам, упаковка каждого с первого элемента
            for (int j = 0; j < things.length; j++) {
                result.get(i)[j].putInABag(bag);
            }
            if (bag.getBagPrice() > tempPrice) {
                tempPrice = bag.getBagPrice();
            }
            bag.bagReset();                         //опустошение сумки для повторной загрузки новой анаграммой
        }
        System.out.println("Самая дорогая сумка стоит: " + tempPrice);
    }

}
