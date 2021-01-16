package com.academy.telesens.lesson7.ht.task2;

import com.academy.telesens.lesson5.ht.CustomDate;

public class DateFormatRunner {
    public static void main(String[] args) {
        CustomDate customDate = new CustomDate();
        System.out.println(customDate.getFormattedDate());
        System.out.println("*************");
        CustomDate customDate1 = new CustomDate();
        System.out.println(customDate1.getFormattedDate(DateFormat.RU));
        System.out.println(customDate1.getFormattedDate(DateFormat.USA));
        System.out.println(customDate1.getFormattedDate(DateFormat.ENG));
        System.out.println(customDate1.getFormattedDate(DateFormat.UK));
        System.out.println(customDate1.getFormattedDate(DateFormat.CUSTOM));
    }
}
