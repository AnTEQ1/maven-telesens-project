package com.academy.telesens.lesson11;

import com.academy.telesens.lesson5.exc.Person;
import com.academy.telesens.lesson7.enumeration.Gender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exc {
    public static void main(String[] args) {

        Person p1 = new Person("Ivan", "Ivanov", 20, Gender.MALE);
        Person p2 = new Person("Peter", "Sidorov", 45, Gender.MALE);
        Person p3 = new Person("Kolya", "Goryanov", 18, Gender.MALE);
        Person p4 = new Person("Helen", "Petrovna", 35, Gender.FEMALE);
        Person p5 = new Person("Liza", "Milovich", 28, Gender.FEMALE);
        Person p6 = new Person("Anna", "Milovich", 30, Gender.FEMALE);
        List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6));

        //people.sort(Comparator.comparing(Person::getLastName)); - возможный метод

        people.sort((o1, o2) -> {
                    if (o1.getLastName().equals(o2.getLastName())) {
                        return o1.getFirstName().compareTo(o2.getFirstName());
                    } else {
                        return o1.getLastName().compareTo(o2.getLastName());
                    }
                }
        );

        System.out.println(people);

        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }
    }
}
