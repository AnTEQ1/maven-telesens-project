package com.academy.telesens.lesson02.ht;

import java.util.Scanner;
/* Для запуска с параметрами необходимо перейти Run - Edit Configurations.
** Выбрать текущий класс и в поле Program arguments указать нужные параметры (через пробел)
*/
public class Task3 {

    public static void main(String[] args) {
        int q, w;

        if (args.length==0){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите значение для переменной q:");
            q = scanner.nextInt();
            System.out.println("Введите значение для переменной w:");
            w = scanner.nextInt();
        } else {
            q = Integer.parseInt(args[0]);
            w = Integer.parseInt(args[1]);
        }
        System.out.println("Значение в переменной q: " + q);
        System.out.println("Значение в переменной w: " + w);
        int integerDivision = q/w;
        System.out.println("Результат целочисленного деления q/w: " + integerDivision);
        int modDivision = q % w;
        System.out.println("Остаток от деления q/w: " + modDivision);
    }
}