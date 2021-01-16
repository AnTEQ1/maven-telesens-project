package com.academy.telesens.lesson7.enumeration;

import java.util.Arrays;

public class EnumDemo {
    public static void main(String[] args) {
        Gender gender = Gender.MALE;

        if (gender == Gender.MALE) {
            System.out.println("Мужчина");
        } else {
            System.out.println("Мужчина");
        }
        System.out.println("***");
        switch (gender) {
            case MALE:
                System.out.println("Мужчина");
                break;
            case FEMALE:
                System.out.println("Женщина");
        }

        //Трюки
        System.out.println("Порядковый номер enum");
        System.out.println(Gender.FEMALE.ordinal());

        System.out.println("Массив enum значений");
        Gender[] genders = Gender.values();
        System.out.println(Arrays.toString((genders)));

        System.out.println("enum из строки");
        Gender gender2 = Gender.valueOf("FEMALE");
        System.out.println(gender2);

        System.out.println(gender2.getRu());
    }
}
