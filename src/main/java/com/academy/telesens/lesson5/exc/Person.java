package com.academy.telesens.lesson5.exc;

import com.academy.telesens.lesson7.enumeration.Gender;
import com.academy.telesens.lesson9.NegativeAgeError;
import com.academy.telesens.lesson9.TooBigAgeError;

import java.util.Objects;

public class Person {
    protected String firstName;
    protected String lastName;
    protected int age;
    private Gender gender;

    public Person() {

    }

    public Person(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) throws NegativeAgeError, TooBigAgeError {
        if (age < 0) {
            throw new NegativeAgeError();
        }
        if (age > 140) {
            throw new TooBigAgeError();
        }
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getProfile(){
        return String.format(" Фамилия: %s\n Имя: %s\n Возраст: %d\n Пол: %s\n", firstName, lastName, age, gender);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
