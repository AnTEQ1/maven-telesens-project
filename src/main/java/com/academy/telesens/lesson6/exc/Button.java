package com.academy.telesens.lesson6.exc;

public class Button extends Component {
    @Override
    public void draw() {
        System.out.println("Draw button");
    }

    public Button (String text) {
        super(text);
    }

    public void click(){
        System.out.println("Click button");
    }
}
