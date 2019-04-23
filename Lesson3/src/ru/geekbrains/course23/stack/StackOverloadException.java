package ru.geekbrains.course23.stack;

public class StackOverloadException extends IndexOutOfBoundsException {

    public StackOverloadException() {
        super("Invalid index for stack");
    }
}
