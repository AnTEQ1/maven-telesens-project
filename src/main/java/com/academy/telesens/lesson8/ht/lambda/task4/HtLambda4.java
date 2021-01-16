package com.academy.telesens.lesson8.ht.lambda.task4;
/*4) Создайте лямбда-выражение, которое удаляет все пробелы из заданной строки и возвращает результат.
*	Продемонстрируйте работу лямбда-выражения.
*	"Helen Abdel Leon abc array var jMeter Selenium Yaguar" => "HelenAbdelLeonabcarrayvarjMeterSeleniumYaguar"
*/
public class HtLambda4 {
    public static void main(String[] args) {
        DeleteSpaces deleteSpaces = s -> s.replace(" ", "");
        System.out.println(deleteSpaces.spaceDeletion("Helen Abdel Leon abc array var jMeter Selenium Yaguar"));
    }
}
