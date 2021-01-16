package com.academy.telesens.lesson02.ht;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*  Проинициализировать одномерный массив произвольными целыми числами
*	Вывести массив в виде, например:
*		[3, 4, 9, 10, 34, 239, 8, 0, -3, 19, 17]
*		a) используя цикл for
*		b) используя цикл while
*/

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Введите желаемую размерность массива");
        int arraySize = scanner.nextInt();
        int[] arrFor = new int[arraySize];
        int[] arrWhile = new int[arraySize];

        //Наполнение массива при помощи цикла for
        for (int i = 0; i<arraySize; i++){
            arrFor[i] = random.nextInt(arraySize);
        }
        System.out.println("Массив наполненный значениями при помощи цикла for: " + Arrays.toString(arrFor));

        //Наполнение массива при помощи цикла while
        int j = 0;
        while (j<arraySize){
            arrWhile[j] = random.nextInt(arraySize);
            j++;
        }
        System.out.println("Массив наполненный значениями при помощи цикла while: " + Arrays.toString(arrWhile));
    }
}
