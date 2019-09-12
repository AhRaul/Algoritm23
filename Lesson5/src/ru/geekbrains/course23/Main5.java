package ru.geekbrains.course23;

public class Main5 {

    public static void main(String[] args) {
        //countDownLoop(5);
        countDownRec(5);
    }

    public static void countDownLoop(int n) {
        while (true) {
            System.out.println(n);
            n--;
        }
    }

    private static void countDownRec(int n) {
        System.out.println(n);
        countDownRec(n - 1);
    }
}
