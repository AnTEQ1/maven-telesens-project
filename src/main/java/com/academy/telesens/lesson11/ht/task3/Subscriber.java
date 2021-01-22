package com.academy.telesens.lesson11.ht.task3;

public class Subscriber {
    	private Long id;
		private String firstName;
		private String lastName;
		private Gender gender;
		private int age;
		private String phoneNumber;
		private Operator operator;

		public Subscriber (Long id, String firstName,
                           String lastName,
                           Gender gender,
                           int age,
                           String phoneNumber,
                           Operator operator){
		    this.id = id;
		    this.firstName = firstName;
		    this.lastName = lastName;
		    this.gender = gender;
		    this.age = age;
		    this.phoneNumber = phoneNumber;
		    this.operator = operator;
        }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return  id +
                ", " + firstName +
                ", " + lastName +
                ", " + gender.getRu() +
                ", " + age +
                ", " + phoneNumber +
                ", " + operator;
    }
}
