package com.academy.telesens.lesson5.ht;

import com.academy.telesens.lesson5.ht.CustomDate;

import java.util.Random;

public class CustomDateDemo {
    public static void main (String[] args){
        CustomDate customDate = new CustomDate(30,1,2020);
        System.out.println(customDate.getFormattedDate(/*customDate*/)); // Проверка работы меода getFormattedDate
        System.out.println(CustomDate.validate(29,2,1600)); // Проверка работы метода validate

        CustomDate[] customDatesArray = new CustomDate[10];
        Random random = new Random();
        int day;
        int month;
        int year;
        boolean result;
        for (int i = 0; i<customDatesArray.length; i++){ // Наполнение массива случайными датами
            day = (int)(1 + 31 * random.nextDouble());
            month = (int)(1 + 12 * random.nextDouble());
            year = (int)(1 + 9999 * random.nextDouble());
            result = CustomDate.validate(day,month,year);
            while (!result) { // Если вычисленная выше дата не существует, то вычеслякм новую до тех пор пока не будет найдена существующая
                day = (int) (1 + 31 * random.nextDouble());
                month = (int) (1 + 12 * random.nextDouble());
                year = (int) (1 + 9999 * random.nextDouble());
                result = CustomDate.validate(day, month, year);
            }
            if (result){
                customDatesArray[i] = new CustomDate(day,month,year);
            }
            System.out.println(customDatesArray[i].getFormattedDate());
        }
        System.out.println("***** Числа февраля ******");
        for (int i = 0; i<customDatesArray.length; i++){
            String row = customDatesArray[i].getFormattedDate();
            boolean monthIsFebruary = row.contains(".02.");
            if (monthIsFebruary){
                System.out.println(row);
            }
        }

    }
}
