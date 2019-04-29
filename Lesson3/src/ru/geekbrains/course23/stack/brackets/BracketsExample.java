package ru.geekbrains.course23.stack.brackets;

public class BracketsExample {

    public static void main(String[] args) {
        String input = "System.out.println(\"Hello world!\")";
        new Brackets(input).check();
    }
}
