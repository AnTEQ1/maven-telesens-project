package com.academy.telesens.lesson7.ht.task3;
/*а) Создать перечисление "Формат времени" (TimeFormat), в котором определить следующие форматы:
*		- H12		12 часовой			HH:MM:SS (am|pm)	09:23:45am, 09:23:45pm
*		- H24		24 часовой			HH:MM:SS			09:23:45,	21:23:45
*
*	б)Модифицировать класс CustomDateTime из пред. занятия(ий), для возможности отображения времени в заданном формате:
*		- public String getFormattedDate() {} // возвращает дату и время в формате по умолчанию: 24.01.2011	21:23:45
*		- public String getFormattedDate(DateFormat dateFormat, TimeFormat format) {} // возвращает дату и время в заданном форматах
*/

public enum TimeFormat {
    H12,
    H24
}
