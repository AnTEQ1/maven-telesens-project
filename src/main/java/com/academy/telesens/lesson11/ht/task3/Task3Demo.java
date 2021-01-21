package com.academy.telesens.lesson11.ht.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Task3Demo {
    public static void main(String[] args) {
        List <Subscriber> subscribers = new ArrayList<>();
        Long id = 0l;
        Gender gender;
        String firstName="";
        String lastName="";
        int age = 0;
        String operatorName = "";
        String phone = "";
        Gender[] genders = {Gender.MALE, Gender.FEMALE};
        String[] operators = {"Life", "Kyivstar", "Vodafone"};
        String[] lifePrefixes = {"38063", "38093", "38073"};
        String[] kyivstarPrefixes = {"38067", "38097", "38098"};
        String[] vodafonePrefixes = {"38050", "38066", "38095"};
        int genderNumber = 0;
        int operatorNumber = 0;
        int operatorPrefixNumber = 0;
        List<String> maleFirstNames = new ArrayList<>();
        List<String> maleLastNames = new ArrayList<>();
        List<String> femaFirstNames = new ArrayList<>();
        List<String> femaLastNames = new ArrayList<>();
        String line;
        String operatorPrefix="";
        Random random = new Random();

        Properties properties = new Properties();
        File propertiesFile = new File("D:/lesson11/ht/task03/java-part.properties");

        try (FileInputStream fis = new FileInputStream(propertiesFile)) {
            properties.load(fis);
            String fileToWrite = properties.getProperty("subscribers.txt");
            String femaleFirstNameFile = properties.getProperty("female_first_name");
            String femaleLastNameFile = properties.getProperty("female_last_name");
            String maleFirstNameFile = properties.getProperty("male_first_name");
            String maleLastNameFile = properties.getProperty("male_last_name");
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
                operatorNumber = random.nextInt(operators.length);
                operatorName = operators[operatorNumber];
                switch (operatorName){
                    case "Life":
                        operatorPrefixNumber = random.nextInt(lifePrefixes.length);
                        operatorPrefix = lifePrefixes[operatorPrefixNumber];
                        break;
                    case "Kyivstar":
                        operatorPrefixNumber = random.nextInt(kyivstarPrefixes.length);
                        operatorPrefix = kyivstarPrefixes[operatorPrefixNumber];
                        break;
                    case "Vodafone":
                        operatorPrefixNumber = random.nextInt(vodafonePrefixes.length);
                        operatorPrefix = vodafonePrefixes[operatorPrefixNumber];
                        break;
                }
                phone = operatorPrefix + String.format("%07d",random.nextInt(10000000));
                Operator operator = new Operator(operatorName);
                id = (long)i+1;
                subscribers.add(new Subscriber(id,firstName,lastName,gender,age,phone,operator));
            }
            try (PrintWriter pw = new PrintWriter (new FileWriter("D:/lesson11/ht/task03/subscribers.txt",true))){
                for (int j = 0; j<subscribers.size(); j++) {
                    pw.println(subscribers.get(j));
                }
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(subscribers);
    }
}
