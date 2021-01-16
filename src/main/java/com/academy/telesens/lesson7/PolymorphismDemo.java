package com.academy.telesens.lesson7;

import com.academy.telesens.lesson5.exc.Person;
import com.academy.telesens.lesson6.Operator;
import com.academy.telesens.lesson6.Subscriber;

import java.util.Arrays;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Long l1 = 23L;
        Integer i1 = 23;

        //l1 = (Long)i1;
        //i1 = l1;

        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(arr));

        Object[] arr2 = {1,"two",3};
        System.out.println(Arrays.toString(arr2));
        Operator operator = new Operator();
        operator.setName("Life");
        Subscriber subscriber = new Subscriber();
        subscriber.setOperator(operator);
        //subscriber.setFirstName("Peter");
        //subscriber.setPhoneNumder("999");
        System.out.println(subscriber.getProfile());

        System.out.println("*****");
        Person person = new Person();
        person = subscriber; // person должен быть родителем
        //subscriber = person; так нельзя
        System.out.println(person.getProfile());

        Person person2 = new Boxer();
        //((Boxer)person).fight();
        Boxer boxer = (Boxer) person2;
        boxer.fight();

        System.out.println("******");
        Person boxer2 = new Boxer();
        Person musician = new Musician();
        System.out.println(boxer.getProfile());
        System.out.println(musician.getProfile());

        System.out.println("******");
        Boxer boxer3 = new Boxer();
        Musician musician3 = new Musician();

        Person[] arrayPoly = {boxer3,musician3};
        System.out.println(Arrays.toString(arrayPoly));

        for (int i=0; i<arrayPoly.length; i++){
            System.out.println(arrayPoly[i].getProfile());
        }

        System.out.println("*****");
        for (int i=0; i<arrayPoly.length; i++){
            if (arrayPoly[i] instanceof Musician)
                ((Musician)arrayPoly[i]).play();
        }
    }
}