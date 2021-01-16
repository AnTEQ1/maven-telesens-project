package com.academy.telesens.lesson7;

import com.academy.telesens.lesson5.exc.Person;

public class Musician extends Person {

    @Override
    public String getProfile() {
        return "I am musician";
    }

    public void play() {
        System.out.println("guitar playing");
    }

    @Override
    public String toString() {
        return "Musician{}";
    }
}
