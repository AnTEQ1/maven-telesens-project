package com.academy.telesens.lesson02.ht;
import java.util.Scanner;

/*	Нарисовать треугольник заданной размерности. Пример для размера 6:
*       *
*      **
*     ***
*    ****
*   *****
*  ******
*/

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность треугольника");
        int triangleSize = scanner.nextInt();

        for (int i = 0; i < triangleSize ; i++){
            for (int j = triangleSize-1; j > i; j--){
                System.out.print(" ");
            }
            for (int z = 0; z<=i; z++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
