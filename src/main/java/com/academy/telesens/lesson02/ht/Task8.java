package com.academy.telesens.lesson02.ht;

/* Нарисовать квадрат заданного размера. Пример для размера 4:
*   ****
*   *  *
*   *  *
*   ****
*/

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите размер квадрата:");
        int squareSize = scanner.nextInt();
        for (int i = 0; i < squareSize; i++){ //Цикл для наполнения строк
            System.out.print("*"); //Первым элементом каждой строки будет *
            for (int j = 1; j < squareSize-1; j++){ //Цикл наполнения столбцов
                if (i == 0 || i==squareSize-1){ // Если находимся в первой или последней строке то
                    System.out.print("*"); // заполняем столбцы *
                } else {
                    System.out.print(" "); // иначе пробелами
                }
            }
            System.out.println("*"); // последний символ каждой строки
        }
    }
}
