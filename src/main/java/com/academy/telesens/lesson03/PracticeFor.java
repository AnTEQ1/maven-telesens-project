package com.academy.telesens.lesson03;

import java.util.Scanner;

public class PracticeFor {
    public static void main(String[] args) {
        //первое задаение
        for(int i = 1; i <= 100; i += 2){
            System.out.println(i);
        }

        //Втрое задание
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int number = scanner.nextInt(), sum=0;
        for (int i = 1; i<=number; i++){
            sum = sum + i;
        }
        System.out.println(sum);

        //Третье задание
        for (int i = 0; i<5; i++){
            for (int j = 0; j<5; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
