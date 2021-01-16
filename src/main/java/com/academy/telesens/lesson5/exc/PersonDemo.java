package com.academy.telesens.lesson5.exc;

import com.academy.telesens.lesson7.enumeration.Gender;

public class PersonDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Иванов", "Василий", 28, Gender.MALE);
        Person p2 = new Person("Иванов", "Василий", 28,  Gender.MALE);
        Person p3 = new Person("Иванов", "Василий", 28,  Gender.MALE);
        Person p4 = new Person("Иванов", "Василий", 28,  Gender.MALE);
        Person p5 = new Person("Иванов", "Василий", 28,  Gender.MALE);
        Person p6 = new Person("Иванов", "Василий", 28,  Gender.MALE);
        Person p7 = new Person("Иванов", "Василий", 28,  Gender.MALE);
        Person p8 = new Person("Иванов", "Василий", 28,  Gender.MALE);
        Person p9 = new Person("Иванов", "Василий", 28,  Gender.MALE);
        Person p10 = new Person("Иванов","Василий", 28,  Gender.MALE);
        System.out.println(p1.getProfile());

    }
}
