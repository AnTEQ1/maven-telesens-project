package com.academy.telesens.lesson6.exc;

public class RoundButton extends Button {
    public RoundButton(String text) {
        super(text);
    }
    @Override
    public void draw() {
        //super.draw();
        System.out.println("Draw RoundButton");
    }
}
