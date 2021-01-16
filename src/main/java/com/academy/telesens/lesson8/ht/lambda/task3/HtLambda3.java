package com.academy.telesens.lesson8.ht.lambda.task3;
/*3)  Создайте лямбда-выражение, которое переводит символы строки в верхний регистр.
*        Перевести строку в верхний регистр с помощью лямбда-выражения.
*       Перевести строку в верхний регистр с помощью ссылки на метод.
*/
public class HtLambda3 {
    public static void main(String[] args) {
        ToHigherCase toHigherCase = s -> s.toUpperCase();
        System.out.println(toHigherCase.changeCase("qwerty"));
        ToHigherCase toHigherCase1 = String::toUpperCase;
        System.out.println(toHigherCase1.changeCase("qwertyytrewq"));
    }
}
