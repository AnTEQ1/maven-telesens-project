package com.academy.telesens.lesson02.ht;

/* Вывести на таблицу умножения чисел от 1 до 9:
*	1*1 = 1
*	1*2 = 2
*	1*3 = 3
*	...
*	2*1 = 2
*	2*2 = 4
*	...
*	9*8 = 72
*	9*9 = 81
*/

public class Task12 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++){
            for (int j = 1; j <= 9; j++){
                System.out.println(i + " * " + j + " = " +i * j);
            }
            System.out.println("----------");
        }
    }
}
