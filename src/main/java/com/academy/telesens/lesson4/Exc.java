package com.academy.telesens.lesson4;

public class Exc {
    public static void main(String[] args) {
        String[] tracks={"track_01", "track_03", "track_21", "track_15", "track_12","track_99", "track_11", "track_10"};

        for (int i = 0; i<tracks.length; i++){
            int startIndex = tracks[i].indexOf("_");
            int number = Integer.parseInt(tracks[i].substring(startIndex+1));
            if (number>=10 && number<=15)
            System.out.println(tracks[i]);
        }
        System.out.println("*************");
        String demo = "Abcd djl wcdel dc cd;";
        String sub = "cd"; // подсчитать количество вхождений
    }
}
