package com.academy.telesens.lesson02.ht;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите трехзначное число:");
        int n = scanner.nextInt();
        if (n >= 100 && n <= 999){
            System.out.println("Вы ввели число: " + n);
            for (int i = 0; i<3; i++) {
                sum = sum + (n % 10);
                n = n / 10;
            }
            System.out.println("Сумма цифр исходного числа: " + sum);
        } else {
            System.out.println("Вы ввели не трехзначное число");
        }
    }
}
