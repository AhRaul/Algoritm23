package ru.geekbrains.course23;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(500_000_000));
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
