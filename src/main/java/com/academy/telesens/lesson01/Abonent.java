package com.academy.telesens.lesson01;

import java.util.Scanner;

public class Abonent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Имя:");
        String name = scanner.next();
        System.out.println("Введите Фамилию:");
        String lastName = scanner.next();
        System.out.println("Введите Отчество:");
        String patronomic = scanner.next();
        System.out.println("Введите Возраст:");
        int age = scanner.nextInt();
        System.out.println("Введите Пол:");
        String sex = scanner.next();
        System.out.println("Введите номер телефона:");
        String phoneNumber = scanner.next();

        System.out.println("-----Абонент-----");
        System.out.println("Имя: " + name);
        System.out.println("Фамилия: " + lastName);
        System.out.println("Отчество: " + patronomic);
        System.out.println("Возраст: " + age);
        System.out.println("Пол:" + sex);
        System.out.println("Номер телефона: " + phoneNumber);
    }
}