package com.academy.telesens.lesson8.ht.extra;

import java.util.Arrays;

public class ArrayExtImpl implements ArrayExt {
    Object[] objects;

    public ArrayExtImpl(){
        this.objects = new ArrayExtImpl[10];
    }

    @Override
    public Object get(int index) {
        return this.objects[index];
    }

    @Override
    public int size() {
        return this.objects.length;
    }

    @Override
    public void add(Object el) {
        this.objects = Arrays.copyOf(this.objects, this.objects.length+10);
        this.objects[size()-1] = el;
    }

    @Override
    public void add(int index, Object el) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public String toString() {
        return "ArrayExtImpl{" +
                "objects=" + Arrays.toString(objects) +
                '}';
    }
}
