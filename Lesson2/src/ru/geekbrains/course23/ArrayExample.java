package ru.geekbrains.course23;

public class ArrayExample {

    public static void main(String[] args) {
        int[] arrray = new int[5];
        Integer[][] arrray1 = new Integer[5][5];
        Integer value = arrray1[0][4];

//        int[] array = new int[] {1, 2, 3};
        int[] array = {1, 2, 3};
        for (int i : array) {
            System.out.println(i);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("*** Array ***");
        Array<Integer> data = new ArrayImpl<>();
        data.add(1);
        data.add(2);
        data.add(3);

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }
}