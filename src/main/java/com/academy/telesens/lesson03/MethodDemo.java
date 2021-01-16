package com.academy.telesens.lesson03;

public class MethodDemo {
    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 4;
        int sum1 = n1+n2;
        int sum2 = sum (3,2);
        System.out.println(sum1);
        System.out.println(sum2);

        reverseNumbers(1,3,5);

        printProfile("Helen", 25);
    }

    // метод суммы
    public static int sum(int arg1, int arg2){
        int sum = arg1 + arg2;
        return sum;
    }

    //метод выводит три аргумента
    public static void reverseNumbers(int a, int b, int c){
        System.out.print(a + " " + b + " " + c);
    }

    public static void printProfile (String name, int age){
        System.out.println(String.format("Name %s, age %d",name,age));
    }
}
