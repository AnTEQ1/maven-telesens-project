package com.academy.telesens.lesson5.oop;

public class Demo {
    public static void main(String[] args) {
        ButtonOOP btn = new ButtonOOP();

        btn.setSize(134);
        btn.text = "Login";
        //System.out.println("btn.size: "  + btn.size);
        System.out.println("****************");
        btn.printInfo();

        System.out.println("****************");
        ButtonOOP btn4 = new ButtonOOP();
        btn4.init(30,"44");
        btn4.printInfo();


        System.out.println(ButtonOOP.DEFAULT_TEXT);
    }
}
