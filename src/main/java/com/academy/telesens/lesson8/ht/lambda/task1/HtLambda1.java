package com.academy.telesens.lesson8.ht.lambda.task1;
/*  1) 	Составьте лямбда-выражение, которое возвращает значение true, если
*		число принадлежит к диапазону чисел 10-20, включая граничные значения
*/
public class HtLambda1 {
    public static void main(String[] args) {
        BoolInterfaсe oper = (x) -> x >= 10 && x <= 20;
        System.out.println(oper.limit(15));
        System.out.println(oper.limit(21));
        System.out.println(oper.limit(9));
    }
}
