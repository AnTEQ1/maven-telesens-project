package com.academy.telesens.lesson6;

import com.academy.telesens.lesson7.enumeration.Gender;

public class Runner {
    public static void main(String[] args) {
        Operator operator = new Operator("Vodafone", "Kyiv");
        Subscriber subscriber = new Subscriber("Иван", "Иванов", 25, Gender.MALE, "0669545856", operator);
        String profile = subscriber.getProfile();
        System.out.println(profile);
        //System.out.println(subscriber.getPhoneNumder());
        //System.out.println(subscriber.getOperator().getName());

        Subscriber subscriber2 = new Subscriber();
        subscriber2.setFirstName("Петров");
        subscriber2.setLastName("Петр");

        Subscriber subscriber3 = new Subscriber().withFirstName("Федор").withFLastName("Петров").withAge(32);

        System.out.println("*********");
        System.out.println(subscriber);
        System.out.println(subscriber.toString());

        System.out.println("**********");
        Operator operatorLife = new Operator("Life", "Kyiv");
        Operator operatorLife2 = new Operator("Life", "Kyiv");
        Operator operatorLife3 = operatorLife2;
        System.out.println(operatorLife2 == operatorLife); //== сравнения ссылки на объект а не самих обьектов
        System.out.println(operatorLife3 == operatorLife2); //== сравнения ссылки на объект а не самих обьектов
        System.out.println(operator.equals(operatorLife));
        System.out.println(operatorLife2.equals(operatorLife));
        System.out.println(operatorLife2.equals(operatorLife3));

    }
}
