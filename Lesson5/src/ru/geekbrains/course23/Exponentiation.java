package ru.geekbrains.course23;

//Возведение в степень при помощи рекурсии
public class Exponentiation {

    public static void main(String[] args) {
        double value = 5;
        int exponent = 2; //25

        System.out.println(exponentiation(value, exponent));

//        System.out.println(exponentiation(0, 0));   //неопределено
        System.out.println(exponentiation(0, 2));   //0
        System.out.println(exponentiation(0, -1));  //0
        System.out.println(exponentiation(1, 0));   //1
        System.out.println(exponentiation(1, -1));  //1
        System.out.println(exponentiation(2, 2));   //4
        System.out.println(exponentiation(10, -2)); //0.01
        System.out.println(exponentiation(-3, 2));  //9
        System.out.println(exponentiation(3, 1));   //3
    }

    private static double exponentiation(double value, int exponent) {
        if (exponent < 0) {             //если степень отрицательная
            value = 1/value;
            exponent = exponent * (-1);
        }
        if(exponent == 1) {      //если степень равна 1
            return value;
        } else if(exponent == 0) {      //если степень равна 0, то любое число, кроме нуля, равно единице
            if (value != 0) {
                return 1;
            } else {
                throw new IllegalArgumentException("Invalid rank " + exponent + " for value = 0");
            }
        }
        try {
            return value * exponentiation(value, exponent - 1);
        } catch (StackOverflowError e) {
            System.out.println("Стек рекурсии переполнен, задана высокая степень");
            return 0;
        }
    }
}
