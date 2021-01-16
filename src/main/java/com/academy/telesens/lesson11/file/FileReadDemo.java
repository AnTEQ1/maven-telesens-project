package com.academy.telesens.lesson11.file;

import java.io.*;
import java.util.Scanner;

public class FileReadDemo {
    public static void main(String[] args)  {
        String path = "D:/Тестирование/TelesenseAcademy/мужские имена.txt";


        //1й способ
        System.out.println("1й способ");
        try (InputStream is = new FileInputStream(path)) {
            Scanner scanner = new Scanner(is);
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //2й способ
        System.out.println("2й способ");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line ;
            while ((line = br.readLine())!=null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
