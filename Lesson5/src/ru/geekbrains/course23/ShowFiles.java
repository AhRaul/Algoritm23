package ru.geekbrains.course23;

import java.io.File;

public class ShowFiles {

    public static void main(String[] args) {
        File rootDir = new File("D:\\sqlite\\");
        viewDir(rootDir, "");
    }

    private static void viewDir(File rootDir, String prefix) {
        if(rootDir.isFile()) {
            System.out.println(prefix + "File: " + rootDir.getName());
        }
        else {
            System.out.println(prefix + "Dir: " + rootDir.getName());
            for (File file : rootDir.listFiles()) {
                viewDir(file, prefix + "    ");
            }
        }
    }
}
