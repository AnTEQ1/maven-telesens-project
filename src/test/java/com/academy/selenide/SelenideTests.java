package com.academy.selenide;

import com.academy.selenide.page.FormPage;
import com.academy.selenide.page.HomePage;
import com.academy.selenide.page.SubscribersPage;
import com.academy.telesens.lesson11.ht.task3.Gender;
import com.academy.telesens.lesson6.Subscriber;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "subscriberProvider")
    public void testAddSubscriber(Subscriber subscriber) {
        //Доделать добавление дома
        HomePage homePage = open(baseUrl, HomePage.class);
        SubscribersPage subscribersPage = homePage.goToSubscriber();
        List<Subscriber> before = subscribersPage.getAllSubscribers();

        before.add (subscriber); //Остается вопрос с ID, при добавлении его указать нельзя

        FormPage formPage = subscribersPage.goToFormPage();
        formPage.fillFirstNameField(subscriber.getFirstName ());
        formPage.fillLastNameField(subscriber.getLastName ());
        formPage.selectGender(subscriber.getGender().toValue());
        formPage.fillAgeField(subscriber.getAge ());
        subscribersPage = formPage.saveSubscriber();

        List<Subscriber> after = subscribersPage.getAllSubscribers();
        Assert.assertEquals (after, before);


//        SubscribersPage subscribersPage2 = open(baseUrl, HomePage.class)
//                .goToSubscriber()
//                .goToFormPage()
//                .fillFirstNameField("test3")
//                .fillLastNameField("test3")
//                .selectGender("Male")
//                .fillAgeField(32)
//                .saveSubscriber();
    }

    @DataProvider (name = "subscriberProvider")
    public Object[][] subscriberProvider() {
        Subscriber subscriber = new Subscriber ();
        //subscriber.setId ();
        subscriber.setFirstName ("test2");
        subscriber.setLastName ("test2");
        subscriber.setAge (25);
        subscriber.setGender (Gender.valueOf ("f"));

        return new Object[][] {
                {subscriber}
        };
    }

    @AfterClass
    public void afterClass() {
        closeWindow();
    }
}