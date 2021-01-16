package com.academy.telesens.lesson8.exc;

import com.academy.telesens.lesson5.exc.Person;

public class Programmer extends Person implements Coder {
    @Override
    public void coding() {
        System.out.println("Coding");
    }
}
