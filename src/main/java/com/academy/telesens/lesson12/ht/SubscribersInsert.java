package com.academy.telesens.lesson12.ht;

import com.academy.telesens.lesson11.ht.task3.Gender;
import com.academy.telesens.lesson5.exc.Person;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class SubscribersInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/operator?user=root&password=root";
        String sqlInsertTemplate = "Insert into subscriber (first_name, last_name, gender, age) values (?, ?, ?, ? )";
        List<Person> people = new ArrayList<>();
        Gender gender;
        String firstName = "";
        String lastName = "";
        int age;
        Gender[] genders = {Gender.MALE, Gender.FEMALE};
        int genderNumber;
        List<String> maleFirstNames = new ArrayList<>();
        List<String> maleLastNames = new ArrayList<>();
        List<String> femaFirstNames = new ArrayList<>();
        List<String> femaLastNames = new ArrayList<>();
        String line;
        Random random = new Random();

        Properties properties = new Properties();
        File propertiesFile = new File("D:/Testing/TelesensAcademy/lesson11/ht/task03/java-part.properties");

        try (FileInputStream fis = new FileInputStream(propertiesFile);
             Connection conn = DriverManager.getConnection(url)) {
            properties.load(fis);
            String femaleFirstNameFile = properties.getProperty("female_first_name");
            String femaleLastNameFile = properties.getProperty("female_last_name");
            String maleFirstNameFile = properties.getProperty("male_first_name");
            String maleLastNameFile = properties.getProperty("male_last_name");
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (BufferedReader maleFirstNameReader = new BufferedReader(new FileReader(maleFirstNameFile));
                 BufferedReader maleLastNameReader = new BufferedReader(new FileReader(maleLastNameFile));
                 BufferedReader femaleFirstNameReader = new BufferedReader(new FileReader(femaleFirstNameFile));
                 BufferedReader femaleLastNameReader = new BufferedReader(new FileReader(femaleLastNameFile))) {
                while ((line = maleFirstNameReader.readLine()) != null) {
                    maleFirstNames.add(line);
                }
                while ((line = maleLastNameReader.readLine()) != null) {
                    maleLastNames.add(line);
                }
                while ((line = femaleFirstNameReader.readLine()) != null) {
                    femaFirstNames.add(line);
                }
                while ((line = femaleLastNameReader.readLine()) != null) {
                    femaLastNames.add(line);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            for (int i = 0; i < 200; i++) {
                age = 5 + random.nextInt(86);
                genderNumber = random.nextInt(genders.length);
                gender = genders[genderNumber];
                switch (gender) {
                    case MALE:
                        firstName = maleFirstNames.get(random.nextInt(maleFirstNames.size()));
                        lastName = maleLastNames.get(random.nextInt(maleLastNames.size()));
                        break;
                    case FEMALE:
                        firstName = femaFirstNames.get(random.nextInt(femaFirstNames.size()));
                        lastName = femaLastNames.get(random.nextInt(femaLastNames.size()));
                        break;
                }

                people.add(new Person(firstName, lastName, age, gender));
                PreparedStatement preparedStatement = conn.prepareStatement(sqlInsertTemplate);
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, gender.getRu());
                preparedStatement.setInt(4, age);
                preparedStatement.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(people);
    }
}

