package com.academy.telesens.lesson02.ht;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        final double moonGravityToEarthGravityAttitude = 0.17;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите свой вес:");
        float weightOnEarth = scanner.nextFloat();
        System.out.println("Ваш вес на Земле: " + weightOnEarth + " кг.");
        float weightOnMoon = (float) (weightOnEarth * moonGravityToEarthGravityAttitude);
        System.out.println("Ваш вес на Луне: " + weightOnMoon + " кг.");
    }
}
