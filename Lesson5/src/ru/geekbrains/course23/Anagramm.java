package ru.geekbrains.course23;

import java.util.HashSet;
import java.util.Set;

public class Anagramm {

    public static void main(String[] args) {
        new Anagramm("cat").getAnagramm();
    }

    private char[] chars;
    private Set<String> result = new HashSet<>();

    public Anagramm(String word) {
        this.chars = word.toCharArray();
    }

    public void getAnagramm() {
        if(chars.length == 1){
            System.out.print(chars[0]);
            return;
        }
        getAnagramm(chars.length);
        for(String anagramm : result) {
            System.out.println(anagramm);
        }
    }

    public void getAnagramm(int length) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            getAnagramm(length - 1);
            result.add(new String(chars));
//            showResult();
            rotate(length);
        }
    }

    private void rotate(int length) {
        int pos = chars.length - length;
        char temp = chars[pos];
        for(int i = pos +1; i<chars.length; i++) {
            chars[i-1] = chars[i];
        }
        chars[chars.length - 1] = temp;
    }

    private void showResult() {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }
}
