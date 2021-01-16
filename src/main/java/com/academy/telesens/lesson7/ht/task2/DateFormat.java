package com.academy.telesens.lesson7.ht.task2;
/* 2) a) Создать перечисление "Формат Даты" (DateFormat), в котором определить несколько форматов, например:
*		- 	RU 			Россия						DD.MM.YYYY					24.01.2011
*		- 	USA 		США							MM-DD-YYYY					01-24-2011
*		-	ENG			Международный английский	DD-MM-YYYY					24-01-2011
*		- 	UK			Великобритания				DD/MM/YYYY					24/01/2011
*		-* 	CUSTOM		Пользовательский			DD <Название месяца> YYYYг	25 января 2011г
*
*	b) Модифицировать класс CustomDate из предыдущего занятия, для фозможности отображения даты в заданном формате:
*		- public String getFormattedDate() {} // возвращает дату в формате по умолчанию - RU: 24.01.2011
*		- public String getFormattedDate((DateFormat format){} // возвращает дату в заданном формате по образцу из задания а)
*/

public enum DateFormat {
    RU,
    USA,
    ENG,
    UK,
    CUSTOM
}
