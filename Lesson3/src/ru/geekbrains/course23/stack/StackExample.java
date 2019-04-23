package ru.geekbrains.course23.stack;

public class StackExample {

    public static void main(String[] args) {
        Stack<Integer> stack = new StackImpl<>(3);
        addIfNotFull(stack, 1);
        addIfNotFull(stack, 2);
        addIfNotFull(stack, 3);
        addIfNotFull(stack, 4);

        removeIfNotEmpty(stack);
        removeIfNotEmpty(stack);
        removeIfNotEmpty(stack);
        removeIfNotEmpty(stack);
        removeIfNotEmpty(stack);
        removeIfNotEmpty(stack);
        removeIfNotEmpty(stack);
    }

    private static void removeIfNotEmpty(Stack<Integer> stack) {
        if( !stack.isEmpty() ) {
            System.out.println(stack.pop());
        }
    }

    private static void addIfNotFull(Stack<Integer> stack, int value) { //нажатие на выделенном блоке кода ctrl+Alt+M для упаковки его в метод
        if ( !stack.isFull() ) {
            stack.push(value);
        }
    }
}
