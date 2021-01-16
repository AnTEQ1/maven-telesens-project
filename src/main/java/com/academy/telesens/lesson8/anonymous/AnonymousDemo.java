package com.academy.telesens.lesson8.anonymous;

import com.academy.telesens.lesson6.exc.Button;
import com.academy.telesens.lesson6.exc.Component;
import com.academy.telesens.lesson7.Boxer;
import com.academy.telesens.lesson8.VisualComponent;
import com.academy.telesens.lesson8.exc.Fighter;

public class AnonymousDemo {
    public static void main(String[] args) {
        VisualComponent component = new Button("Button");
        VisualComponent component2 = new InputField();
        component.draw();
        component2.draw();

        VisualComponent visualComponent = new VisualComponent() {
            @Override
            public void draw() {
                System.out.println("Draw custom component");
            }
        };
        visualComponent.draw();

        //способ реализации интерфейса с одним!! методом через анонимный класс
        Fighter fighter = new Fighter() {
            @Override
            public void fight() {
                System.out.println("SUMO");
            }
        };
        fighter.fight();
        //способ реализации интерфейса с одним!! методом через лямбда выражения
        fighter = () -> System.out.println("Kick boxing");
        fighter.fight();
    }
}

