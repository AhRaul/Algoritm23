package ru.geekbrains.course23.stack.fliper;

import ru.geekbrains.course23.stack.StackImpl;

//Переворачивает вводимые строки (читает справа налево)
public class StringFliper<E> extends StackImpl<Character> {

    public StringFliper(String stringToFlip) {
        super(stringToFlip.length());
        for (int i = 0; i < stringToFlip.length(); i++) {
            super.push(stringToFlip.charAt(i));
        }
    }

    public String flipString() {
        StringBuffer resultString = new StringBuffer();
        if (super.isEmpty()) {
            System.out.println("Your string is empty");
            return null;
        }
        int size = super.getSize();
        for(int i = 0; i < size; i++) {
            resultString.append(super.pop());
        }
        return resultString.toString();
    }
}
