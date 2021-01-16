package com.academy.telesens.lesson02;

public class Exc {
    public static void main(String[] args) {
        double x=1.1,y=3,z=5,result;
        System.out.println("Значение X: " + x);
        System.out.println("Значение Y: " + y);
        System.out.println("Значение Z: " + z);
        result = z-x-y;
        System.out.println("Результат: " + result);//при вычеслении теряется байт 2 в -52 степени и следовательно выводит 0.8999999999999999

    }
}
