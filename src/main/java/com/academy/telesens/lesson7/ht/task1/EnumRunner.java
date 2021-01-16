package com.academy.telesens.lesson7.ht.task1;

public class EnumRunner {
    public static void main(String[] args) {
        DaysOfWeek daysOfWeek = DaysOfWeek.SUNDAY;
        System.out.println(daysOfWeek);
        System.out.println(daysOfWeek.next());
        System.out.println("*********");
        DaysOfWeek daysOfWeek2 = DaysOfWeek.MONDAY;
        System.out.println(daysOfWeek2);
        System.out.println(daysOfWeek2.previous());

    }
}
