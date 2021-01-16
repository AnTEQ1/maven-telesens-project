package com.academy.telesens.lesson8;


import com.academy.telesens.lesson6.exc.*;

public class InterfaceDemo {
    public static void main(String[] args) {
        Button button = new Button("Login");
        Component button2 = new Button("Login");
        VisualComponent button3 = new Button("Login");
        VisualComponent label = new Label("First Name");

        button3.draw();
        /*
        * 2) Добавить новый метод по умолчанию в VisualComponent
		* - default void draw3D(); //
		* - перекрыть метод draw3D у Label
		* - продемонстрировать работу метода draw3D() во всех компонентах
		*/

        System.out.println("**************");
        VisualComponent button3D = new Button("text");
        VisualComponent checkBox3D = new CheckBox("text");
        VisualComponent label3D = new Label("text");
        VisualComponent roundButton3D = new RoundButton("text");

        button3D.draw3D();
        checkBox3D.draw3D();
        label3D.draw3D();
        roundButton3D.draw3D();


    }

}
