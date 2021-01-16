package com.academy.telesens.lesson02;

public class Operators {
    public static void main(String[] args) {
        double n1 = 10;
        double n2 = 4;
        double result = n1/n2;
        System.out.println(result);

        System.out.println(1.0/0);

        System.out.println(10 % 3);
        System.out.println(1 % 3);

        int value = 1;
        ++ value; // увеличивает value на единицу
        value++; //value = value +1 ; value +=1;

        System.out.println("*******");
        int value2 = 1;
        System.out.println(++value2);
        System.out.println(value2++);
        System.out.println(value2);

        //Сравнение
        System.out.println(2 == 2); // true/false
        System.out.println(2 != 3); // true/false
        System.out.println(2 > 3); // true/false
        System.out.println(2 >= 3); // true/false

        System.out.println("*******");
        int n = 2;
        System.out.println(n > 1  && n < 3); //&& - and(и)
        System.out.println(n > 2  && n < 3);
        System.out.println(n > 2  || n < 3);// || - or (или)
        System.out.println(n > 2  || n == 0);// || - or (или)
        System.out.println(!true);

        int m = 2;
        m *= 3; //6
        m = m*3; //6

        final int z = 10; //final - запрещает изменение значения переменной (но можно приводить к другому типу)
        char s = z;
    }
}
