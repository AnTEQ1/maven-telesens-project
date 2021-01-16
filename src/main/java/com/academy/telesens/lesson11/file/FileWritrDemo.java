package com.academy.telesens.lesson11.file;

import java.io.*;

public class FileWritrDemo {
    public static void main(String[] args) {
        String path = "D:/Тестирование/TelesenseAcademy/write-demo.txt";

        try (PrintWriter pw = new PrintWriter (new FileWriter(path,true)))
        {
            pw.println("next line");
            pw.println("next line 2");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
