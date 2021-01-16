package com.academy.telesens.lesson7;

import com.academy.telesens.lesson5.exc.Person;
import com.academy.telesens.lesson8.exc.Fighter;

public class Boxer extends Person implements Fighter {
    @Override
    public void fight(){
        System.out.println("I am boxing");
    }

    @Override
    public String getProfile() {
        return "I am boxing";
    }

    @Override
    public String toString() {
        return super.toString() + "Boxer{}";
    }

}
