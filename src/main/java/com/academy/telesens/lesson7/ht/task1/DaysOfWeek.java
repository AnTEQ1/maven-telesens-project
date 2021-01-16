package com.academy.telesens.lesson7.ht.task1;
/* 1)  Перечисление для представления дней недели
*		/Реализовать перечисление "День недели": Понедельник, Вторник, ...
*		В перечислении "День недели" добавить методы получения дня "завтра" next() и "вчера" before().
*		Протестировать перечисление в функции main() тестового класса.
*/
public enum DaysOfWeek {
   MONDAY,
   TUESDAY,
   WEDNESDAY,
   THURSDAY,
   FRIDAY,
   SATURDAY,
   SUNDAY;

  DaysOfWeek next(){
      int numberOfDay = ordinal() + 1;
      if (numberOfDay == 7) {
          numberOfDay = 0;
      }
      return values()[numberOfDay];
   }

   DaysOfWeek previous() {
      int numberOfDay = ordinal() - 1;
      if (numberOfDay == - 1) {
          numberOfDay = 6;
      }
      return values()[numberOfDay];
   }
}
