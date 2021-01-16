package com.academy.telesens.lesson8.anonymous;

import java.util.Locale;

public class LambdaDemo {
    public static void main(String[] args) {
        IntInterface oper1 = (n1, n2) -> n1+n2;
        IntInterface oper2 = (n1, n2) -> n1*n2;

        System.out.println(oper1.calc(3,5));
        System.out.println(oper2.calc(3,5));

        StringInterface strOper = s->s.toUpperCase();
        StringInterface strOper2 = String::toLowerCase;

        System.out.println(strOper.oper("hello"));
        System.out.println(strOper2.oper("HELLO"));

        StringConsumer stringConsumer = s -> System.out.println(s);
        StringConsumer stringConsumer1 = System.out::println;

        stringConsumer.consume("Hello World");
        stringConsumer1.consume("Hello World");
    }
}
