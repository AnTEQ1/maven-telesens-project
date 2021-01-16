package com.academy.telesens.lesson8.ht.lambda.task5;

import com.academy.telesens.lesson6.ht.CustomDateTime;

public class HtLambda5 {
    public static void main(String[] args) {
        CustomDateTime customDateTime = new CustomDateTime();
        TimeToZero timeToZero = () -> {
            customDateTime.setHour(0);
            customDateTime.setMinute(0);
            customDateTime.setSecond(0);
        };
        timeToZero.setTimeToZero();
        System.out.println(customDateTime.getFormattedDate());
    }
}
