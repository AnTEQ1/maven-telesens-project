package com.academy.telesens.lesson8.exc;

import com.academy.telesens.lesson5.exc.Person;

public class Genius extends Person implements Coder, Dancer, Fighter {
    @Override
    public void coding() {
        System.out.println("Genius is Coding");
    }

    @Override
    public void dance() {
        System.out.println("Genius is Dancing");
    }

    @Override
    public void fight() {
        System.out.println("Genius is Fight");
    }
}
