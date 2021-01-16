package com.academy.telesens.lesson10.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntBinaryOperator;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(12);
        set.add(12);
        set.add(13);
        set.add(14);
        set.add(14);
        set.add(14);

        System.out.println(set);

        //Исключить дубликаты

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(4);
        integerList.add(1);

        Set<Integer> integerSet = new HashSet<>(integerList);
        System.out.println(integerSet);
        integerList.sort(Integer::compareTo);


    }
}
