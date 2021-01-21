package com.academy.telesens.lesson11.ht.task3;

public class Operator {
    private Long id = 0l;
    private String name;

    public Operator (String name){
        this.id += 1;
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
