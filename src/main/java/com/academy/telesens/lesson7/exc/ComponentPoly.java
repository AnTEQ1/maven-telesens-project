package com.academy.telesens.lesson7.exc;

import com.academy.telesens.lesson6.exc.*;

public class ComponentPoly {
    public static void main(String[] args) {
        Label label = new Label("Label");
        Button button = new Button("Button");
        CheckBox checkBox = new CheckBox("LAbel");
        RoundButton roundButton = new RoundButton("RoundButton");

        Component[] components = {label,button, checkBox, roundButton};

        for (int i = 0; i < components.length; i++){
            components[i].draw();
        }
        System.out.println("******");
        for (int i = 0; i < components.length; i++){
            if (components[i] instanceof Button){
                components[i].draw();
            }
        }
    }
}
