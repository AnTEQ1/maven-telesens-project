package com.academy.telesens.lesson6.exc;

public class Label  extends Component{
    @Override
    public void draw() {
        System.out.println("Draw Label");
    }
    public Label (String text) {
        super(text);
    }

    @Override
    public void draw3D() {
        System.out.println("Draw 3D Label");
    }
}
