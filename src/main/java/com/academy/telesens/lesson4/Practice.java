package com.academy.telesens.lesson4;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        char[] chars = new char[26];
        char first = 'a', last = 'z';
        char symbol = 0;
        for(int j = (int) first, i= 0; j<(int)last && i<26; j++, i++){
            symbol = (char)j;
            chars[i] = symbol;
        }
        System.out.println(Arrays.toString(chars));

        System.out.println("**********************");
    //Второй варинат
    for(char symb = 'a'; symb <= 'z'; symb++){
        System.out.print(symb);
    }

        System.out.println("***eaquals***");
        String[] arr1 = {"One", "Two", "Three"};
        String[] arr2 = {"One", "Two", "Three"};
        System.out.println(Arrays.equals(arr1,arr2));

}
}
