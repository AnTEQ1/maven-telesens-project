package com.academy.telesens.lesson02.ht;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите произвольное положительное число:");
        String numberAsString = scanner.next();
        int numberLength = numberAsString.length();
        long n = Long.parseLong(numberAsString);
        System.out.println("Исходное число: " + n);
        System.out.println("Разрядность числа: " + numberLength);
        for (int i = 0; i < numberLength; i++){
            sum = (int)(sum + (n % 10));
            n = n/10;
        }
        System.out.println("Сумма цифр исходного числа: " + sum);
    }
}
