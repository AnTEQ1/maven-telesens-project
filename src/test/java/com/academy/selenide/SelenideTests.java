package com.academy.selenide;

import com.academy.selenide.page.FormPage;
import com.academy.selenide.page.HomePage;
import com.academy.selenide.page.SubscribersPage;
import com.academy.telesens.lesson6.Subscriber;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {
    private String baseUrl = "http://localhost:8081";

    @BeforeClass
    public void beforeClass() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10;
        Configuration.startMaximized = true;
    }

    @Test
    public void testAddSubscriber(Subscriber subscriber) {
        //Доделать добавление дома
        HomePage homePage = open(baseUrl, HomePage.class);
        SubscribersPage subscribersPage = homePage.goToSubscriber();
        List<Subscriber> before = subscribersPage.getAllSubscribers();

        FormPage formPage = subscribersPage.goToFormPage();
        formPage.fillFirstNameField("test2");
        formPage.fillLastNameField("test2");
        formPage.selectGender("Female");
        formPage.fillAgeField(25);
        subscribersPage = formPage.saveSubscriber();

//        SubscribersPage subscribersPage2 = open(baseUrl, HomePage.class)
//                .goToSubscriber()
//                .goToFormPage()
//                .fillFirstNameField("test3")
//                .fillLastNameField("test3")
//                .selectGender("Male")
//                .fillAgeField(32)
//                .saveSubscriber();
    }

    @AfterClass
    public void afterClass() {
        closeWindow();
    }
}