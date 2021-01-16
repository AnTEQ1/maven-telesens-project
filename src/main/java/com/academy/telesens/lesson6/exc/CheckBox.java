package com.academy.telesens.lesson6.exc;

public class CheckBox extends Button{
    protected Boolean checked = false;
    public CheckBox(String text){
        super(text);
    }
    @Override
    public void draw() {
        //super.draw();
        System.out.println("Draw CheckBox");
    }

    @Override
    public void click() {
        //super.click();
        System.out.println("Click CheckBox");
    }

    public boolean isChecked() {
        return checked;
    }
}
