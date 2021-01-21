package com.academy.telesens.lesson10.generic;

public class Pair <U, V> {
    private U first;
    private V second;
    public Pair (U first, V second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(U first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}