package com.academy.telesens.lesson01;

import java.util.Scanner;

public class Demo {//начало области видимости класса
    public static void main(String[] args) {//начало области видимости метода
        //Вывод на консоль с переводом строки
        System.out.println("Привет Мир!");
        System.out.println("Привет Мир2!");
        System.out.println("Привет Мир3!");
        //Вывод на консоль. Курсор остается на той же строке
        System.out.print("один");
        System.out.print("два");
        System.out.print("три\n");

        //Форматирование строк - 1й спопосб (устаревший)
        System.out.printf("My name is %s; My address %s%n", "Helen", "Kharkiv");

        //Формтирование строк - 2й строк (более правильный). Параметр %s - для строки/текста, %d - для чисел.
        System.out.println(String.format("My name is %s; My address %s; Age: %d", "Helen", "Kharkiv",28));

        //Ввод с консоли
        System.out.print("Введите ваше имя:");
        Scanner scanner = new Scanner(System.in);//Настраиваем сканнер
        String name = scanner.nextLine();//Считываем с консоли
        int age = scanner.nextInt();
        System.out.println(String.format("Привет, %s!", name));//Вывод приветствия
    }
}