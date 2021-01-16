package com.academy.telesens.lesson02.ht;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите двузначное число:");
        int n = scanner.nextInt();
        if (n >= 10 && n < 100) {
            System.out.println("Вы ввели число: " + n);
            for (int i = 0; i < 2; i++){
                sum += n % 10;
                n = n/10;
            }
            System.out.println("Сумма цифр исходного числа: " + sum);
        } else {
            System.out.println("Введеное значение не является двузначным");
        }
    }
}
