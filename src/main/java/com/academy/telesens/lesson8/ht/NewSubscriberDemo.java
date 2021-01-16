package com.academy.telesens.lesson8.ht;

import com.academy.telesens.lesson6.Subscriber;
import com.academy.telesens.lesson7.enumeration.Gender;

import java.util.Random;

public class NewSubscriberDemo {
    public static void main(String[] args) {
        Subscriber[] subscribers = new Subscriber[100]; // Объявляется массив для абонентов
        Gender[] genders = {Gender.MALE,Gender.FEMALE}; // Объявляется и инициализируется массив для полов
        int[] ages = new int[87]; // Объявляется массив для возростов

        //Инициализируется четыре массива с именами и фамилиями (для каждого пола)
        String[] maleFirstNames = {"Смирнов","Иванов","Кузнецов","Попов","Соколов","Лебедев","Козлов","Новиков",
                                    "Морозов","Петров","Волков","Соловьёв","Васильев","Зайцев","Павлов"};
        String[] maleLastNames = {"Архип","Болеслав","Марат","Семён","Юлиан","Сергей","Нифонт","Максим","Евгений",
                                    "Геннадий","Володар","Ждан","Марк","Григорий","Леонид","Олег"};
        String[] femaleFirstNames = {"Ковалёва","Ильина","Гусева","Титова","Кузьмина","Кудрявцева","Баранова","Куликова",
                                    "Алексеева","Степанова","Яковалева","Сорокина","Сергеева","Романова","Захарова","Борисова"};
        String[] femaleLastNames = {"Виктория","Дария","Арина","Зоя","Лиза","Мария","Надя","Раиса","Тамара","Октябрина",
                                    "Рая","Роза","Нелли","Милана","Любовь","Леся","Каролина","Зинаида","Карина","Клавдия"};

        Random random = new Random();

        for (int j = 0; j < ages.length; j++) { // массив возрастов заполняется значениями от 4 до 90
            ages[j] = j+4;
        }

        for (int i = 0; i < subscribers.length; i++) { // начало наполнения массива абонетов
            int genderNumber = random.nextInt(genders.length); // Случайным образом определяется номер пола в массиве
            Gender gender = genders[genderNumber]; // значение соответствующее определенному выше номеру пола записывается в переменную
            int ageNumber = random.nextInt(ages.length); // случайным образом определяется номер возраста в массиве
            int age = ages[ageNumber]; // значение соответствующее определенному выше номеру возраста записывается в переменню
            String firstName = ""; // Оьявляется переменная для Фамилии
            String lastName = ""; // Объявляется переменная для Имени
            switch (genders[genderNumber]) {
                case MALE: // если пол мужской
                    int maleFirstNameNumber = random.nextInt(maleFirstNames.length); // определяется случайный номер фамилии в массиве
                    int maleLastNameNumber = random.nextInt(maleLastNames.length); // определяется случайный номер имени в массиве
                    //значения имени и фамилии соответствующие определенным выше номерам записываются в перменные
                    firstName = maleFirstNames[maleFirstNameNumber];
                    lastName = maleLastNames[maleLastNameNumber];
                    break;
                case FEMALE: //аналогично если пол женский
                    int femaleFirstNameNumber = random.nextInt(femaleFirstNames.length);
                    int femaleLastNameNumber = random.nextInt(femaleLastNames.length);
                    firstName = femaleFirstNames[femaleFirstNameNumber];
                    lastName = femaleLastNames[femaleLastNameNumber];
                    break;
            }
            subscribers[i] = new Subscriber(firstName, lastName, age, gender); // наполняется массив абонентов
            System.out.println(subscribers[i].getProfile());
        }
    }
}
