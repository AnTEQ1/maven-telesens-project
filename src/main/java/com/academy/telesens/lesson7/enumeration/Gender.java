package com.academy.telesens.lesson7.enumeration;

public enum Gender {
    MALE("мужч"),
    FEMALE("женщ");

    private String ru;

    Gender(String ru) {
        this.ru = ru;
    }

    public String getRu(){
        return ru;
    }

    public void saySomething() {
        if (this == MALE){
            System.out.println("Я мужчина");
        } else {
            System.out.println("Я женщина");
        }
    }
}
