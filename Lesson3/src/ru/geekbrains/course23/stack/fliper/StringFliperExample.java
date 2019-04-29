package ru.geekbrains.course23.stack.fliper;

import ru.geekbrains.course23.stack.Stack;

public class StringFliperExample {
    public static void main(String[] args) {
        StringFliper stringToFlip = new StringFliper("12 doG 89");
        String resultString = (String) stringToFlip.flipString();
        System.out.println(resultString);
    }
}
