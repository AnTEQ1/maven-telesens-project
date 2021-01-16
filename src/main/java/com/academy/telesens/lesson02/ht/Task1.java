package com.academy.telesens.lesson02.ht;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1, number2, number3;

        System.out.println("Введите первое число:");
        number1 = scanner.nextInt();
        System.out.println("Введите второе число:");
        number2 = scanner.nextInt();
        System.out.println("Введите третье число:");
        number3 = scanner.nextInt();

        int max = Math.max(Math.max(number1,number2), Math.max(Math.max(number2,number3),Math.max(number1,number3)));
        int min = Math.min(Math.min(number1,number2), Math.min(Math.min(number2,number3),Math.min(number1,number3)));
        System.out.println("Максимальное число: " +max);
        if (number1 == max && number2 == min){
            System.out.println("Среднее число: " +number3);
        } else if (number2 == max && number3 == min || number2 == min){
            System.out.println("Среднее число: " +number1);
        } else if (number1 == max || number1 == min && number3 == max){
            System.out.println("Среднее число: " +number2);
        }
        System.out.println("Миниальное число: " +min);

        //Второй вариант

        /*if (number1<number2 && number2<number3){
            System.out.println("Максимальное число: " +number3);
            System.out.println("Среднее число: " +number2);
            System.out.println("Миниальное число: " +number1);
        } else if (number1>number2 && number2<number3 && number3>number1){
            System.out.println("Максимальное число: " +number3);
            System.out.println("Среднее число: " +number1);
            System.out.println("Миниальное число: " +number2);
        } else if (number1<number2 && number2>number3 && number3<number1){
            System.out.println("Максимальное число: " +number2);
            System.out.println("Среднее число: " +number1);
            System.out.println("Миниальное число: " +number3);
        } else if (number2<number3 && number3<number1){
            System.out.println("Максимальное число: " +number1);
            System.out.println("Среднее число: " +number3);
            System.out.println("Миниальное число: " +number2);
        }*/

        //Третий вариант

        /*if (number1 > number2){
            if (number1 > number3 && number3 > number2){
                System.out.println("Максимальное число: " +number1);
                System.out.println("Среднее число: " +number3);
                System.out.println("Миниальное число: " +number2);
            } else if(number3 > number2) {
                System.out.println("Максимальное число: " +number3);
                System.out.println("Среднее число: " +number1);
                System.out.println("Миниальное число: " +number2);
            }
        }else if (number2 > number3 && number3>number1){
            System.out.println("Максимальное число: " +number2);
            System.out.println("Среднее число: " +number3);
            System.out.println("Миниальное число: " +number1);
            } else {
            System.out.println("Максимальное число: " +number2);
            System.out.println("Среднее число: " +number1);
            System.out.println("Миниальное число: " +number3);
        }*/
    }
}
