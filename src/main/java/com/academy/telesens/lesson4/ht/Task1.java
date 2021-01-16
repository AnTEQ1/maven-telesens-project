package com.academy.telesens.lesson4.ht;
import java.util.Scanner;
/*
1) Напишите программу, которая:
	- считывает строку
	- выводит исходную строку
	- выводит количество и список слов, которые начинаются на букву 'd'
*/

public class Task1 {

    public static void main(String[] args) {
        stringEditor (); // не посчитает если первое слово начинается на d
    }

    public static void stringEditor (){
        int i = 0; // Переменная для подсчета количества слов
        int indexOfSpace; // переменная для хранения позиции пробела следующего за искомым словом
        int startIndex = 0; // переменная для хранения позиции с которой нужно начинать поиск слова

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String userString = scanner.nextLine();
        System.out.println("Исходная строка: \n" + userString);

        while (true){
            int indexOfD = userString.indexOf(" d",startIndex); //вычисляется начало слова
            if (indexOfD !=-1){ // если начало слова найдено
                i++; // увеличиваем количество слов на единицу
                indexOfSpace = userString.indexOf(" ",indexOfD+1); //вычисляется позиция пробела после найденного начала слова
                startIndex = indexOfSpace; // присваивается новая позиция для начала следующего поиска
                System.out.println(userString.substring(indexOfD,indexOfSpace)); // выводится слово между вычесленными позициями начала слова и следующего пробела
            } else { //иначе
                break; // цикл прерывается
            }
        }
        System.out.println("Количество слов: " + i);// выводится количество слов
    }
}
