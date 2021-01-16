package com.academy.telesens.lesson4;

public class Polindrom {
    public static void main(String[] args) {
        String polindrom = "qwertyytrewq";
        String notPolindrom = "Not Polindrom";

        System.out.println(isPolindrom(polindrom));
        System.out.println(isPolindrom(notPolindrom));
        System.out.println(countSubs("java programming java java", "java"));
    }
    public static boolean isPolindrom (String testString){
        for (int i=0, k = testString.length()-1; i<k; i++, k--){
            if (testString.charAt(i)!=testString.charAt(k)){
                return false;
            }
        }
        return true;
    }
    public static int countSubs(String origin, String subs){
        int count = 0;
        int index = 0;

        while ((index = origin.indexOf(subs,index))!=-1){
            count++;
            index = index+subs.length();
        }
        return count;
    }
}
