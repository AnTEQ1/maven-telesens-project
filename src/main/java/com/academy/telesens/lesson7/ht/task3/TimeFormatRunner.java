package com.academy.telesens.lesson7.ht.task3;

import com.academy.telesens.lesson6.ht.CustomDateTime;
import com.academy.telesens.lesson7.ht.task2.DateFormat;

public class TimeFormatRunner {
    public static void main (String[] args){
        CustomDateTime customDateTime = new CustomDateTime();
        System.out.println(customDateTime.getFormattedDate());

        CustomDateTime customDateTime1 = new CustomDateTime();
        System.out.println(customDateTime1.getFormattedDate(DateFormat.CUSTOM,TimeFormat.H12));

        CustomDateTime customDateTime2 = new CustomDateTime(2020,1,30,5,35,33);
        System.out.println(customDateTime2.getFormattedDate(DateFormat.CUSTOM,TimeFormat.H12));

        CustomDateTime customDateTime3 = new CustomDateTime();
        System.out.println(customDateTime3.getFormattedDate(DateFormat.CUSTOM,TimeFormat.H24));
    }
}
