package ru.geekbrains.course23;

public class HelloBye {

    public static void main(String[] args) {
        hello("Alexey");
    }

    private static void hello(String name) {
        print("Hello, " + name + "!");
        bye(name);
    }

    private static void bye(String name) {
        print("Good bye, " + name + "!");
    }

    private static void print(String message) {
        System.out.println(message);
    }

}
