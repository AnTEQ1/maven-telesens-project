package com.academy.telesens.lesson4.ht;

/* 2) Напишите программу, которая:
 *      - считывает строку
 *      - выводит исходную строку
 *      - выводит количество и список слов, которые заканчиваются буквами 'ED'
 */

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        wordSearcher();
    }

    private static void wordSearcher() {
        int i = 0; //количество слов
        String userString; // переданная строка
        int startIndex = 0; //номер позиции начала поиска
        int prefixSpace; // позиция пробела после слова
        int postfixSpace;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        userString = scanner.nextLine();
        System.out.println("Исходная строка: \n" + userString);

        while (true) {
            int indexOfED = userString.indexOf("ED", startIndex);
            //System.out.println(userString.length());
            if (indexOfED != -1) {
                if (indexOfED + 2 == userString.length()) {
                    i++;
                    break;
                } else if (userString.charAt(indexOfED + 2) == ' ') {
                    i++;
                    startIndex = indexOfED + 2;
                }
            } else {
                break;
            }
        }
        System.out.println("Количество слов заканчивающихся на ED " + i);

        /*int wordStartPosition = userString.indexOf(" ",startIndex);
        int wordEndPosition = userString.indexOf(" ", wordStartPosition+1);
        String word = userString.substring(wordStartPosition+1, wordEndPosition);
        System.out.println(word);
        System.out.println(wordEndPosition);
        System.out.println(wordStartPosition);*/
    }
}
