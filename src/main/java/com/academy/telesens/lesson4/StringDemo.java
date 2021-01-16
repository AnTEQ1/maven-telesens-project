package com.academy.telesens.lesson4;

import java.util.Arrays;
import java.util.Locale;

public class StringDemo {
    public static void main(String[] args) {
        System.out.println("a"+" "+"b");
        System.out.println('a'+' '+'b');
        System.out.println('a'+" "+'b');
        System.out.println("*********************");
        String hello = "Hello World!!!";
        System.out.println(hello.length());
        System.out.println(hello.charAt(2));//третий символ
        String world = hello.substring(6);//подстрока начиная с символа 7
        System.out.println(world);
        String onlyWorld = hello.substring(6,11); //подстрока начиная с 7-го по 11 символ
        System.out.println(onlyWorld);

        System.out.println("*********************");
        String item = "id24_12349_vtr_234";
        int firstIndex = item.indexOf("_");
        int lastIndex = item.indexOf("_",5);
        System.out.println(firstIndex);
        System.out.println(lastIndex);
        String numberPart = item.substring(firstIndex+1, lastIndex);
        System.out.println(numberPart);
        int index = "123asdf".indexOf("_");
        System.out.println(index);
        int index2 = "123asdf".indexOf("asd");
        System.out.println(index2);

        System.out.println("**********Сравнение строк***********");
        String str1 = "hello";
        String str2 = "hello";
        String str3 = "Hello World";

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str1 == str2); //так сравнивать нельзя!!
        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str3));

        System.out.println("**********Сравнение чисел***********");
        Integer n1 = 200;
        Integer n2 = 200;
        System.out.println(n1.equals(n2));

        System.out.println("**********Замена подстроки***********");
        String msg = "   Hello, Helen!!!    ";
        String changedMsg = msg.replaceAll("!!!","!");
        System.out.println(msg);
        System.out.println(changedMsg);

        System.out.println(msg.toLowerCase());
        System.out.println(msg.toUpperCase());

        System.out.println("'" + msg + "'");
        System.out.println("'" + msg.trim() + "'");//Убирает пробелы в начале и в конце

        String demoString = "One, Two, Three";
        String[] parts = demoString.split(",");
        String tmp = Arrays.toString(parts);
        System.out.println(Arrays.toString(parts));
        String joined = tmp.replaceAll("\\[","")
                .replaceAll("\\]","")
                .replaceAll(" ","");
        System.out.println(joined);
    }
}
