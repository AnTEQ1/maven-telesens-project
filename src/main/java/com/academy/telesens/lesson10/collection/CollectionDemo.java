package com.academy.telesens.lesson10.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("hello");
        list.add("string");



//        for (int i = 0; i < 100; i++) {
//            list.add("others");
//        }
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list.contains("two"));

        list.remove(2);
        list.remove("hello");


        ArrayList <Integer> listInt = new ArrayList<>(
                Arrays.asList(1,2,3,4,2,5,3,10)
        );

        System.out.println(listInt);
        listInt.remove((Integer) 1);//удаляет по значению - если указать int то сработает удаление по индексу
        listInt.remove((Object) 2);//удаляет по значению
        listInt.remove(0); // удаляет по индексу
        System.out.println(listInt);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Peter");
        list2.add("Ann");
        list2.add("Helen");


        System.out.println(list2);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
        //сортировка
        list2.sort(String::compareTo);
        System.out.println(list2);

        System.out.println(listInt);
        //listInt.sort((n1,n2) -> n1.compareTo(n2)); // 1й способ
        listInt.sort(Integer::compareTo); // 2й способ
        System.out.println(listInt);
    }
}
