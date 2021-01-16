package com.academy.telesens.lesson10.ht.collections;
/* 2) List
*	a) создать список целых чисел
*	b) наполнить список случайными целыми числами от 1 до 100 (размер списка 20 элементов)
*	c) вывести список на экран
*	d) вывести минимальное, максимально значения
*	e) вывести сумму чисел на экран
*	f) найти наиболее часто встречающееся число, вывести это число и кол-во повторений на экран
*		(если чисел несколько с одинаковой частотой повторений, то вывести минимальное из них)
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int j = 0;
        int z = 100;
        int x = 0;
        int frequentElement = 0;
        int frequency = 1;
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++){
            list.add(random.nextInt(100));
        }
        System.out.println(list);

        for (int i = 0; i < list.size(); i++){
            if (list.get(i)>j){
                j = list.get(i);
            }
        }
        System.out.println("Максимальный элемент:" + j);

        for (int i = 0; i < list.size(); i++){
            if (list.get(i)<z){
                z = list.get(i);
            }
        }
        System.out.println("Минимльный элемент:" + z);

        list.sort(Integer::compareTo);
        System.out.println("Максимальный элемент (второй способ): " + list.get(list.size()-1));
        System.out.println("Минимальный элемент (второй способ): " + list.get(0));

        for (int i = 0; i<list.size(); i++){
            x += list.get(i);
        }
        System.out.println("Сумма всех элементов: " + x);

        ///??????
        for (int i = 0; i < list.size(); i++) {
            frequentElement = list.get(i);
            if (Collections.frequency(list, frequentElement) > frequency){
                frequency = Collections.frequency(list, frequentElement);
            } else {
                continue;
            }
            System.out.println(frequentElement + " " + frequency);
        }
        //System.out.println(frequentElement + " " + frequency);
    }
}
