package ru.geekbrains.course23.stack.brackets;

import ru.geekbrains.course23.stack.Stack;
import ru.geekbrains.course23.stack.StackImpl;

//скобки
public class Brackets {

    private String code;    //проверяемая строка

    public Brackets(String code) {
        this.code = code;
    }

    public void check() {
        Stack<Character> stack = new StackImpl<>(code.length());

        for (int i = 0; i < code.length(); i++) {
            char chr = code.charAt(i);              //передается непостредственно символ
            switch(chr) {
                case '{' :
                case '[' :
                case '(' :
                case '<' :
                    stack.push(chr);
                    break;
                case '}':
                case ']':
                case ')':
                case '>' :
                    if(stack.isEmpty()) {
                        System.out.println("Error: " + chr + " at " + i);
                        break;
                    }
                    char lastChar = stack.pop();
                    if(lastChar == '{' && chr != '}' ||
                            lastChar == '[' && chr != ']' ||
                            lastChar == '(' && chr != ')' ||
                            lastChar == '<' && chr != '>') {
                        System.out.println("Error: " + chr + " at " + i);
                    }
                default:
                    break;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}
