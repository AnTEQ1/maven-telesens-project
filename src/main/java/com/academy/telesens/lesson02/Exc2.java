package com.academy.telesens.lesson02;

public class Exc2 {
    public static void main(String[] args) {
        int age = 90;
        if (age<=0){
            System.out.println("Ошибка");
        } else if (age>=1 && age<18){
            System.out.println("Несовершеннолетний");
        } else if (age>=18 && age<89) {
            System.out.println("Взрослый");
        }else if (age>=90) {
            System.out.println("Долгожитель");
        }

        }
    }
