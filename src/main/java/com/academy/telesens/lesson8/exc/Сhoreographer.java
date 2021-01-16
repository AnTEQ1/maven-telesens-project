package com.academy.telesens.lesson8.exc;

import com.academy.telesens.lesson5.exc.Person;

public class Сhoreographer extends Person implements Dancer {
    @Override
    public void dance() {
        System.out.println("Dancing");
    }
}
