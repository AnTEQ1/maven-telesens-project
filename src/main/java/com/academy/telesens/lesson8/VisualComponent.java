package com.academy.telesens.lesson8;

public interface VisualComponent {
    void draw();

    default void draw3D(){
        System.out.println("Нарисовать 3D из VisualComponent");
    }

}
