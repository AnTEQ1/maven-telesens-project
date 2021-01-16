package com.academy.telesens.lesson10.generic;

import com.academy.telesens.lesson5.exc.Person;

public class PairDemo {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(10, "string"); // второй раз можно указать только угловые скобки
        int n = pair.getFirst();
        String str = pair.getSecond();
        System.out.println("Pair 1: " + n + " -> " + str);

        Pair<String, Integer> pair2 = new Pair<>("string", 10);
        int n2 = pair2.getSecond();
        String str2 = pair2.getFirst();
        System.out.println("Pair 2: " + n2 + " -> " + str2);

        Pair<Integer, Integer> pair3 = new Pair<>(5, 10);
        int n3 = pair3.getSecond();
        int n4 = pair3.getFirst();
        System.out.println("Pair 3: " + n3 + " -> " + n4);

        Person person = new Person();
        Pair<Integer, Person> pair4 = new Pair<>(5, person);
        int n5 = pair4.getFirst();
        Person n6 = pair4.getSecond();
        System.out.println("Pair 4: " + n5 + " -> " + n6);

        print(1, "Hello");

        double result1 = sum(1,3);
        double result2 = sum(1.3, 4);
        System.out.println(result1);
        System.out.println(result2);

        someMethod(pair);

        Pair<Object, Integer> pair5 = new Pair<>("", 12);
        someMethod3(pair5);

    }
    public static <U,V> void print(U arg1, V arg2){
        System.out.println("first: " + arg1 + ", second: " + arg2);
    }

    public static <U extends Number, V extends Number> double sum (U arg1, V arg2){
        return arg1.doubleValue() + arg2.doubleValue();
    }

    public static void someMethod (Pair<?, ?> pair){
        Object first = pair.getFirst();
        Object second = pair.getSecond();
        System.out.println(first +":"+second);
    }

    public static void someMethod2 (Pair<? extends Number, ?> pair){
        Object first = pair.getFirst();
        Object second = pair.getSecond();
        System.out.println(first +":"+second);
    }

    public static void someMethod3 (Pair<? super Number, ?> pair){
        Object first = pair.getFirst();
        Object second = pair.getSecond();
        System.out.println(first +":"+second);
    }
}
