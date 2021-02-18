package com.academy.lesson20;

public class NotFoundSubscriberException extends RuntimeException{
    private int id;

    public NotFoundSubscriberException(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
