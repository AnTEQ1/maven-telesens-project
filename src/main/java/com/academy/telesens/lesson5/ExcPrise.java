package com.academy.telesens.lesson5;

import java.util.Arrays;

public class ExcPrise {
    public static void main(String[] args) {
        String prices = "18 999 ₴, 29 999 ₴, 19 499 ₴, 26 555 ₴, 22 999 ₴, 27 777 ₴, 36 399 ₴, 23 349 ₴, 57 777 ₴";

        String replaced = prices.replace("₴", "").replace(" ", "");
        System.out.println(replaced);
        String[] splitted = replaced.split(",");
        System.out.println(Arrays.toString(splitted));
        int[] arrayOfPrices = new int[splitted.length];
        for (int i = 0; i < splitted.length; i++) {
            arrayOfPrices[i] = Integer.parseInt(splitted[i]);
        }
        System.out.println(Arrays.toString(arrayOfPrices));
        Arrays.sort(arrayOfPrices);
        System.out.println(Arrays.toString(arrayOfPrices));
    }
}
