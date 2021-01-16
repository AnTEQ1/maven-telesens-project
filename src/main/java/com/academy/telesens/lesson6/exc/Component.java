package com.academy.telesens.lesson6.exc;

import com.academy.telesens.lesson8.VisualComponent;

abstract public class Component implements VisualComponent {
    protected int xPosition;
    protected int yPosition;
    protected int width;
    protected int height;
    protected String text;

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setText(String text){
        this.text = text;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public int getWidth() {
        return width;
    }

    public Component (String text) {
        this.text = text;
    }

    public int getHeight() {
        return height;
    }

    public String getText() {
        return text;
    }

    @Override
    public abstract void draw();
}
