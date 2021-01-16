package com.academy.telesens.lesson6;

import com.academy.telesens.lesson5.exc.Person;
import com.academy.telesens.lesson7.enumeration.Gender;

/* 4) Доработать класс Subscriber. Поля класса:
*	firstName (имя)
*	lastName (фамилия)
*	gender (пол)
*	age (возраст)
*
*	Создать массив из 100 абонентов, заполнив все поля случайными данными:
*		- пол (мужч или женщ)
*		- возраст (от 4 - 90)
*		- имя (если женщина - случайное женское имя)
*		- фамилия (женская или мужская)
*
*	Фамилии и имена использовать из след. списков:
*		мужские фамилии: Смирнов,Иванов,Кузнецов,Попов,Соколов,Лебедев,Козлов,Новиков,Морозов,Петров,Волков,Соловьёв,Васильев,Зайцев,Павлов
*		мужские имена: Архип,Болеслав,Марат,Семён,Юлиан,Сергей,Нифонт,Максим,Евгений,Геннадий,Володар,Ждан,Марк,Григорий,Леонид,Олег
*		женские фамилии: Ковалёва,Ильина,Гусева,Титова,Кузьмина,Кудрявцева,Баранова,Куликова,Алексеева,Степанова,Яковалева,Сорокина,Сергеева,Романова,Захарова,Борисова,
*		женские имена: Виктория,Дария,Арина,Зоя,Лиза,Мария,Надя,Раиса,Тамара,Октябрина,Рая,Роза,Нелли,Милана,Любовь,Леся,Каролина,Зинаида,Карина,Клавдия
*/

public class Subscriber extends Person {
    private  String phoneNumder;
    private Operator operator;

    public Subscriber() {
    }

    public Subscriber (String firstName,
                       String lastName,
                       int age,
                       Gender gender,
                       String phoneNumder,
                       Operator operator){
        super(firstName, lastName, age, gender); // конструктор базового класса. Должен быть вызван первым
        //setFirstName(firstName);//первый вариант записи в поле родителя
        this.phoneNumder = phoneNumder;
        this.operator = operator;
    }

    public Subscriber (String firstName, String lastName, int age, Gender gender) {
        super(firstName, lastName, age, gender);
    }

    public String getPhoneNumder() {
        return phoneNumder;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setPhoneNumder(String phoneNumder) {
        this.phoneNumder = phoneNumder;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getProfile(){
        return super.getProfile() + String.format(" Номер телефона: %s\n Оперптор: \n",
                phoneNumder/*, operator.getName()*/);
    }

    public Subscriber withFirstName(String firstName){
       super.firstName = firstName; //должен быть protected
        return this;
    }

    public Subscriber withFLastName(String lastNameName){
        super.lastName = lastName; //должен быть protected
        return this;
    }

    public Subscriber withAge(int age){
        super.age = age; //должен быть protected
        return this;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phoneNumder='" + phoneNumder + '\'' +
                ", operator=" + operator +
                '}';
    }
}
