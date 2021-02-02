package com.academy.telesens.lesson15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArrayDemo {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("one");
        strList.add("two");
        strList.add("three");

        String[] strArray1 = strList.toArray(new String[0]);
        String[] strArray2 = strList.toArray(n->new String[n]);
        String[] strArray3 = strList.toArray(String[]::new);
        System.out.println(Arrays.toString(strArray1));
        System.out.println(Arrays.toString(strArray2));
        System.out.println(Arrays.toString(strArray3));

        List<String[]> listStr = new ArrayList<>();
        listStr.add(new String[] {"1", "2", "2"});
        Object [][] result5 = listStr.toArray(String[][]::new);
        System.out.println(Arrays.deepToString(result5));
    }


    public static String [][] listToString (List<List<String>> list) {
        return list.stream()
                .map(arr -> arr.toArray(String[]::new)) // List<String>, List<String>, .... = > String[], String[],...
                .toArray(String[][]::new) ; //String[], String[],... = > String[][]
    }


}
