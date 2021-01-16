package com.academy.telesens.lesson02.ht;

/*	Нарисовать треугольник заданной размерности. Пример для размера 6:
*    *
*    **
*    ***
*    ****
*    *****
*    ******
*/

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите рахмерность треугольника:");
        int triangleSize = scanner.nextInt();
        for (int i = 0; i < triangleSize; i++){
            for (int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
