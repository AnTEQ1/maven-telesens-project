package com.academy.telesens.lesson5.oop;

public class ButtonOOP {
    //поля
    private int size = 12; //0 - присваиватеся по умолчанию
    String text;  //null - присваиватеся по умолчанию
    public static final String DEFAULT_TEXT = "text";

    void init (){
        size = 20;
        text = "NoName";
    }

    //Конструктор
    public ButtonOOP(){
        System.out.println("Конструктор класса Button");
    }


    public ButtonOOP(int size, String text) {
        this.size = size;
        this.text = text;
    }

    public void setSize(int size) {
        this.size = size;
    }

    void init (int size, String text){
        this.size = size;
        this.text = text;
    }

    void setText(String text){
        this.text = text;
    }

    public int getSize() {
        return size;
    }

    //мтоды
    void printInfo(){
        System.out.println(String.format("size: %d, text: %s", size,text));
    }
}
