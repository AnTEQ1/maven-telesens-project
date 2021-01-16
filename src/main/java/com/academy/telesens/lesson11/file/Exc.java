package com.academy.telesens.lesson11.file;

import java.io.*;

public class Exc {
    public static void main(String[] args) {
        String fileToRead = "D:/Тестирование/TelesenseAcademy/мужские имена.txt";
        String fileToWright = "D:/Тестирование/TelesenseAcademy/write-demo.txt";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileToRead));
             PrintWriter pw = new PrintWriter(new FileWriter(fileToWright,true))) {
            while ((line = br.readLine())!=null){
                pw.println(line);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
