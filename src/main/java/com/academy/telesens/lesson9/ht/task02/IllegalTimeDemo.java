package com.academy.telesens.lesson9.ht.task02;

import com.academy.telesens.lesson6.ht.CustomDateTime;

public class IllegalTimeDemo {
    public static void main(String[] args) {
        CustomDateTime customDateTime = new CustomDateTime();
        System.out.println("Проверка позитивных сценариев");
        try {
            customDateTime = new CustomDateTime(2020,1,1,12,12,12);
        } catch (IllegalTimeException illegalTimeException){
            System.out.println("Время указано некорректно");
        }
        System.out.println(customDateTime.getFormattedDate());
        System.out.println("****************");

        try {
            customDateTime = new CustomDateTime(2020,1,1,23,1,1);
        } catch (IllegalTimeException illegalTimeException){
            System.out.println("Время указано некорректно");
        }
        System.out.println(customDateTime.getFormattedDate());
        System.out.println("****************");

        try {
            customDateTime = new CustomDateTime(2020,1,1,0,0,0);
        } catch (IllegalTimeException illegalTimeException){
            System.out.println("Время указано некорректно");
        }
        System.out.println(customDateTime.getFormattedDate());
        System.out.println("****************");

        try {
            customDateTime = new CustomDateTime(2020,1,1,23,59,59);
        } catch (IllegalTimeException illegalTimeException){
            System.out.println("Время указано некорректно");
        }
        System.out.println(customDateTime.getFormattedDate());
        System.out.println("****************");

        System.out.println("Проверка негативных сценариев");
        try {
            customDateTime = new CustomDateTime(2020,1,1,-12,12,12);
        } catch (IllegalTimeException illegalTimeException){
            System.out.println("Время указано некорректно");
        }
        System.out.println(customDateTime.getFormattedDate());
        System.out.println("****************");

        try {
            customDateTime = new CustomDateTime(2020,1,1,23,1,60);
        } catch (IllegalTimeException illegalTimeException){
            System.out.println("Время указано некорректно");
        }
        System.out.println(customDateTime.getFormattedDate());
        System.out.println("****************");

        try {
            customDateTime = new CustomDateTime(2020,1,1,24,0,0);
        } catch (IllegalTimeException illegalTimeException){
            System.out.println("Время указано некорректно");
        }
        System.out.println(customDateTime.getFormattedDate());
        System.out.println("****************");

        try {
            customDateTime = new CustomDateTime(2020,1,1,23,60,0);
        } catch (IllegalTimeException illegalTimeException){
            System.out.println("Время указано некорректно");
        }
        System.out.println(customDateTime.getFormattedDate());
        System.out.println("****************");
    }
}
