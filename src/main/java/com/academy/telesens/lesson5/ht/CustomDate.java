package com.academy.telesens.lesson5.ht;

/*
 * 1) Создать класс CustomDate, который имеет следующие поля:
 *		/- день
 *		/- месяц
 *		/- год
 *
 *	Все поля должны быть помечены модификатором private
 *		/- реализовать доступ к полям через методы set и get
 *		/- реализовть public метод getFormattedDate(); который вернет дату в отформатированном виде, напр. 21.12.2018 (или 21.12.2018 пятница)
 *		/-* реализовать статический метод validate(int day, int month, int year), который проверяет существование введенной даты
 *		/и выводит true/false (учитывать высокосный год)
 *
 *		-* использовать проверку validate, при попытке изменить поле методом set, в случае ошибки не проводить изменение,
 *			а вывести сообщение об ошибке на консоль
 *		-** реализовать статический метод dayOfWeek(int day, int month, int year), который принимает другую дату и вычисляет день недели.
 *           Этот метод может возвращать, напр. для
 *			понедельника - 0
 *			вторника - 1
 *			и т.д.
 *		- проверить работу методов:
 *			/getFormattedDate()
 *			/validate()
 *			dayOfWeek()
 *
 * 2) Создать массив размера 10, состоящий из классов CustomDate
 *	/- наполнить массив случайными значениями действительных дат
 *	/- вывести все даты массива на консоль
 *	/- вывести только даты месяца февраль
 *	- *вывести только даты понедельника
 */

import com.academy.telesens.lesson7.ht.task2.DateFormat;
import com.academy.telesens.lesson9.ht.task01.IllegalDateException;

public class CustomDate {
    private int day;
    private int month;
    private int year;

    public CustomDate() {
        this.day = 15;
        this.month = 12;
        this.year = 2020;
    }

    public CustomDate(int day, int month, int year) throws IllegalDateException {
        if (!validate(day,month,year)) {
            throw new IllegalDateException();
        } else {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static boolean validate(int day, int month, int year) {
        boolean thirtyDaysInMonth = false;
        boolean yearIsExist = false;
        boolean monthIsExist = false;
        boolean thirtyDaysRange = false;
        boolean thirtyOneDaysRange = false;
        boolean twentyNinthOfFebruary = false;
        boolean isFebruary = false;
        boolean isDateExist = false;

        if (month == 4 || month == 6 || month == 9 || month == 11){ // В месяце 30 дней?
            thirtyDaysInMonth = true;
        }
        if(year >= 1 && year <= 9999){ // Ограничение диапазона годов
            yearIsExist = true;
        }
        if (month >= 1 && month <= 12){ // Существует ли введенный месяц
            monthIsExist = true;
        }
        if (month!= 2 && (day >= 1 && day <= 31)){ // число от 01 до 31
            thirtyOneDaysRange = true;
        }
        if (month!= 2 && (day >= 1 && day <= 30)) { // число от 01 до 31
            thirtyDaysRange = true;
        }
        if (month == 2 && (day>=1 && day<=28)){ // числа февраля от 01 до 28
            isFebruary = true;
        }
        if (month == 2 && day == 29){ // если пришло 29-е февраля ...
            int firstCheck = year % 4;
            int secondCheck = year % 100;
            int thirdCheck = year % 400;
            if (firstCheck == 0 || (secondCheck != 0 && thirdCheck == 0)) { // то проверяем что год высокосный
                twentyNinthOfFebruary = true;
            }
        }

        if (yearIsExist){ // год попадает в ограничения...
            if (monthIsExist){ // и месяц существует ...
                if (thirtyDaysRange && thirtyDaysInMonth){ // проверяем что дата не выходит за рамки месяца с 30ю числами
                    isDateExist = true;
                }
                if (thirtyOneDaysRange && !thirtyDaysInMonth){ // проверяем что дата не выходит за рамки месяца с 31м числом
                    isDateExist = true;
                }
                if (isFebruary){ // проверяем что дата попадает в 28-мь чисел февралая
                    isDateExist = true;
                }
                if (twentyNinthOfFebruary){ // проеряем что 29-е февраля попадает в высокосный год
                    isDateExist = true;
                }
            }
        }
        return isDateExist;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
            this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFormattedDate() {
        String format = DateFormat.RU.name();
        return String.format("%s: %02d.%02d.%04d", format, day, month, year);
    }

    public String getFormattedDate(DateFormat format) {
        String[] monthsNames = {"Января", "Фераля", "Марта", "Апреля", "Мая", "Июня",
                                "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"};
        String nameOfMonth = monthsNames[month - 1];
        String formattedDate = "";
        switch (format) {
            case RU:
                formattedDate = String.format("%02d.%02d.%04d", day, month, year);
                break;
            case USA:
                formattedDate = String.format("%02d-%02d-%04d", month, day, year);
                break;
            case ENG:
                formattedDate = String.format("%02d-%02d-%04d", day, month, year);
                break;
            case UK:
                formattedDate = String.format("%02d/%02d/%04d", day, month, year);
                break;
            case CUSTOM:
                formattedDate = String.format("%02d %s %04dг.", day, nameOfMonth, year);
                break;
            default:
        }
        return String.format("%s: %s", format.name(), formattedDate);
    }
}
