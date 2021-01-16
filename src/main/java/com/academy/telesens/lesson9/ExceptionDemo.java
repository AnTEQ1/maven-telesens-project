package com.academy.telesens.lesson9;

import com.academy.telesens.lesson5.exc.Person;

public class ExceptionDemo {
    public static void main(String[] args) {
        double d1 = 1;
        double d2 = 0;

        int d3 = 1;
        int d4 = 0;

        try {
            //Потенциально опасный код
            double result = div(d1,d2);
            System.out.println(result);
        } catch (DivisionByZeroError divisionByZeroError) {
            //обработка ошибки
            System.out.println("Error: Division by zero");
            System.out.println("Details" + divisionByZeroError.getMessage());
            //divisionByZeroError.printStackTrace();
        }
        try {
            int result = div(1,0);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Common error");
            System.out.println("Details " + e.getMessage());
        }

        System.out.println("******");

        Person person = new Person();
        try {
            person.setAge(-5); // Возраст отрицательный
            //person.setAge(140); // пока люди столько не живут
        } catch (NegativeAgeError negativeAgeError) {
            System.out.println("Возраст отрицательный");
        } catch (TooBigAgeError tooBigAgeError) {
            System.out.println("Пока люди столько не живут");
        }
        person.setAge(20);
        System.out.println(person.getAge());
        System.out.println("Finish");
    }
    public static double div(double d1, double d2) throws DivisionByZeroError{
        if (d2 == 0){
            throw new DivisionByZeroError("Unsupported division by zero");
        }
        return d1/d2;
    }

    public static int div (int n1, int n2){
        return n1/n2;
    }
}
