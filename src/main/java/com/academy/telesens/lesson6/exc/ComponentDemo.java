package com.academy.telesens.lesson6.exc;

public class ComponentDemo {
    public static void main(String[] args) {
        RoundButton roundButton = new RoundButton("RoundButton");
        roundButton.setXPosition(12);
        roundButton.setYPosition(12);
        roundButton.draw();
        System.out.println(roundButton.getXPosition());
        System.out.println(roundButton.getYPosition());
    }
}
