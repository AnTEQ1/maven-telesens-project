package com.academy.telesens.lesson8.exc;

import com.academy.telesens.lesson5.exc.Person;
import com.academy.telesens.lesson7.Boxer;

import java.util.Arrays;

public class InterfaceDemo {
    public static void main(String[] args) {
        Coder coder = new Programmer();
        Dancer dancer = new Сhoreographer();
        Fighter fighter = new Boxer();
        Coder coder1 = new Genius();

        coder.coding();
        dancer.dance();
        fighter.fight();
        coder1.coding();
        System.out.println("*******************");
        Person[] people = {new Programmer(), new Boxer(), new Genius(), new Сhoreographer(),
                            new Genius(), new Boxer(), new Boxer(), new Genius(), new Programmer(), new Programmer()};

        for (int i = 0; i < people.length; i++) {
            if (people[i] instanceof Dancer) {
                ((Dancer) people[i]).dance();
            }
        }
        System.out.println("*******************");
        Coder[] coders = {new Programmer(), new Programmer(), new Tester(), new Tester()};
        for (int i = 0; i<coders.length; i++) {
                coders[i].coding();
        }

        System.out.println("Пример для лямбда выражений");
        Person[] people1 = {new Boxer(), new Сhoreographer(), new Programmer()};
        //Arrays.sort(people1);
        System.out.println(Arrays.toString(people1));
    }
}
