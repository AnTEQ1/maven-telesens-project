package com.academy.telesens.lesson03;

import java.util.Arrays;
import java.util.Random;

public class ArrayDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[5];
        for (int i = 0; i< 5; i++){
            numbers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers));
        for (int i = numbers.length-1; i>=0; i--){
            System.out.println(numbers[i]);
        }
        System.out.println("*************************************************");

        double[] doubleNumbers = new double[30];
        for (int i = 0; i<doubleNumbers.length; i++){
            //doubleNumbers[i] = 10 * random.nextDouble();
            doubleNumbers[i] = 10 + 90 * random.nextDouble(); //дипазон от 10 до 100
            System.out.println(String.format("%.2f", doubleNumbers[i]));
        }
    }
}
