package com.academy.telesens.lesson9.ht.task01;

import com.academy.telesens.lesson5.ht.CustomDate;

public class IllegalDateDemo {
    public static void main(String[] args) {
        CustomDate customDate = new CustomDate();
        System.out.println("Проверка позитивных сценариев");

        try {
            customDate = new CustomDate(1,1,2012);
        } catch (IllegalDateException illegalDateException){
            System.out.println("Дата не существует");
        }
        System.out.println(customDate.getFormattedDate());
        System.out.println("***************");

        try {
            customDate = new CustomDate(17,2,2019);
        } catch (IllegalDateException illegalDateException){
            System.out.println("Дата не существует");
        }
        System.out.println(customDate.getFormattedDate());
        System.out.println("***************");

        try {
            customDate = new CustomDate(29,2,2020);
        } catch (IllegalDateException illegalDateException){
            System.out.println("Дата не существует");
        }
        System.out.println(customDate.getFormattedDate());
        System.out.println("***************");

        try {
            customDate = new CustomDate(31,1,1999);
        } catch (IllegalDateException illegalDateException){
            System.out.println("Дата не существует");
        }
        System.out.println(customDate.getFormattedDate());
        System.out.println("***************");

        try {
            customDate = new CustomDate(13,6,1681);
        } catch (IllegalDateException illegalDateException){
            System.out.println("Дата не существует");
        }
        System.out.println(customDate.getFormattedDate());
        System.out.println("***************");

        System.out.println("Проверка негативных сценариев");

        try {
            customDate = new CustomDate(-1,1,2012);
        } catch (IllegalDateException illegalDateException){
            System.out.println("Дата не существует");
        }
        System.out.println(customDate.getFormattedDate());
        System.out.println("***************");

        try {
            customDate = new CustomDate(31,2,2019);
        } catch (IllegalDateException illegalDateException){
            System.out.println("Дата не существует");
        }
        System.out.println(customDate.getFormattedDate());
        System.out.println("***************");

        try {
            customDate = new CustomDate(29,2,2019);
        } catch (IllegalDateException illegalDateException){
            System.out.println("Дата не существует");
        }
        System.out.println(customDate.getFormattedDate());
        System.out.println("***************");

        try {
            customDate = new CustomDate(31,13,1999);
        } catch (IllegalDateException illegalDateException){
            System.out.println("Дата не существует");
        }
        System.out.println(customDate.getFormattedDate());
        System.out.println("***************");

        try {
            customDate = new CustomDate(0,6,1681);
        } catch (IllegalDateException illegalDateException){
            System.out.println("Дата не существует");
        }
        System.out.println(customDate.getFormattedDate());
        System.out.println("***************");
    }
}
