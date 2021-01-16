package com.academy.telesens.lesson10.ht.collections;
/*
* 1) Дан массив имен: {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "max}
*	a) Создать список List из элементов массива и вывести на экран
*	b) Добавить 3 новых имени в список (Philip, Joseph, Leon) и вывести весь список на экран
*	c) Удалить из списка все имена: Veronica, Leonid и вывести на экран
*	d) Поменять имя Helen на Elizabet
*	e) Отсортировать имена по алфавиту и вывести на экран
*	f) Отсортировать имена в обратном порядке и вывести имена на экран
*	g) Перевести все первые символы в верхний регистр
*	h) Вывести все имена, начинающиеся на букву A
*	i) Проверить, содержит ли список имя Andry
*	j) Удалить из списка все имена кроме Kate и Helen
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        String[] originArray = {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "Max"};

        //a
        List<String> list = new ArrayList<>(Arrays.asList(originArray));
        System.out.println("a: " + list);

        //b
        list.add("Philip");
        list.add("Joseph");
        list.add("Leon");
        System.out.println("b: " + list);

        //c
        list.remove("Veronica");
        list.remove("Leonid");
        System.out.println("c: " + list);

        //d
        list.set(list.indexOf("Helen"),"Elizabet");
        System.out.println("d: " + list);

        //e
        list.sort(String::compareTo);
        System.out.println("e: " + list);

        //f
        //Collections.reverse(list); // перевернет отсортированный по алфавиту
        list.sort((s1,s2) -> s2.compareTo(s1)); // перевернет список по алфавиту в обратном порядке, даже если предварительно не отсортирован
        //list.sort(String::lastIndexOf);// это не подходит для сортировки, т.к. ищет подстроку s2 в строке s1
        System.out.println("f: " + list);

        //g
        for (int i = 0; i < list.size(); i++){
            String element = list.get(i); // элемент списка
            int posAtList = list.indexOf(element); // позиция элемента в списке
            list.set(posAtList,element.toLowerCase()); // элемент переводится в нижний регистр
            char ch = Character.toUpperCase(list.get(i).charAt(0)); // перевод первого символа в верхний регистр
            String updatedElement = ch + element.substring(1); // Обновленный первый символ добавляется к остальной строке
            list.set(posAtList,updatedElement); // замена элемента в списке
        }
        System.out.println("g: " + list);

        //h
        System.out.print("h: ");
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (name.charAt(0) == 'A'){
                System.out.print(name + " ");
            }
        }
        System.out.println();

        //i
        if(list.contains("Andry")){
            System.out.println("i: Список содержит имя Andry");
        }

        //j
        for (int i = 0; i < list.size(); ) {
            if (list.get(i).equals("Kate") || list.get(i).equals("Elizabet")){  // Helen была заменена на Elizabet в шаге d ))
                i++;
            } else {
                list.remove(list.get(i));
                i=0;
            }
        }
        System.out.println("j: " + list);
    }
}
