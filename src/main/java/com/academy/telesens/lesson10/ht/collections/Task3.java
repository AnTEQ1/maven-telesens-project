package com.academy.telesens.lesson10.ht.collections;
/*
* 	a) создать список List целых чисел
*	b) заполнить его случайными значениями 10-ти значных чисел, первый три цифры 999, остальные - любые, последняя заканчивается на 0 или 5
*	c) Вывести список на экран
*	d) Проверить значения списка, с помощью регулярного выражения.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        String start = "999";
        int[] end = {0, 5};
        Random random1 = new Random();
        Random random2 = new Random();

        for (int i = 0; i < 10; i++) {
            String body = String.format("%06d",random1.nextInt(1000000));
            int chooseEndNumber = random2.nextInt(2);
            String endOfString = Integer.toString(end[chooseEndNumber]);
            String createdString = start+body+endOfString;
            long number = Long.parseLong(createdString);
            list.add(number);
        }
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            boolean result = list.get(i).toString().matches("(999)(\\d{6})([0,5])");
            if (result) {
                System.out.println("Значение " + list.get(i) + " соответствует регулярному выражению");
            } else {
                System.out.println("Значение " + list.get(i) + " не соответствует регулярному выражению");
            }
        }
    }
}
