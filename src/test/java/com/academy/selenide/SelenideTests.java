package com.academy.selenide;

import com.academy.selenide.page.EditFormPage;
import com.academy.selenide.page.FormPage;
import com.academy.selenide.page.HomePage;
import com.academy.selenide.page.SubscribersPage;
import com.academy.telesens.lesson11.ht.task3.Gender;
import com.academy.telesens.lesson6.Subscriber;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {
    private String baseUrl = "http://localhost:8081";

    @BeforeClass
    public void beforeClass() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10;
        Configuration.startMaximized = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @Test(dataProvider = "subscriberProvider")
    public void testAddSubscriber(Subscriber expectedSubscriber) {
        HomePage homePage = open(baseUrl, HomePage.class);
        SubscribersPage subscribersPage = homePage.goToSubscriber();
        List<Subscriber> before = subscribersPage.getAllSubscribers();

        FormPage formPage = subscribersPage.goToFormPage();
        formPage.fillFirstNameField(expectedSubscriber.getFirstName ());
        formPage.fillLastNameField(expectedSubscriber.getLastName ());
        formPage.selectGender(expectedSubscriber.getGender().toValue());
        formPage.fillAgeField(expectedSubscriber.getAge ());
        subscribersPage = formPage.saveSubscriber();

        Subscriber actualSubscriber = subscribersPage.getLastSubscriber();
        expectedSubscriber.setId(actualSubscriber.getId());
        Assert.assertEquals(actualSubscriber, expectedSubscriber);

        List<Subscriber> after = subscribersPage.getAllSubscribers();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(expectedSubscriber);
        // sort by id
        before.sort(Comparator.comparingInt(Subscriber::getId));
        after.sort(Comparator.comparingInt(Subscriber::getId));

        Assert.assertEquals(after, before);
        Assert.assertEquals (after, before);
    }
    @Test(dataProvider = "editSubscriberProvider")
    public void testEditSubscriber(Subscriber subscriber) {
        HomePage homePage = open (baseUrl,HomePage.class);
        SubscribersPage subscribersPage = homePage.goToSubscriber ();
        List<Subscriber> before = subscribersPage.editSubscriberInList (subscriber);

        EditFormPage editFormPage = subscribersPage.editSubscriber(subscriber.getId());
        editFormPage.fillFirstNameField(subscriber.getFirstName());
        editFormPage.fillLastNameField(subscriber.getLastName());
        editFormPage.editGender(subscriber.getGender().toValue());
        editFormPage.fillAgeField(subscriber.getAge());
        subscribersPage = editFormPage.saveSubscriber();

        List<Subscriber> after = subscribersPage.getAllSubscribers ();
        before.sort(Comparator.comparingInt(Subscriber::getId));
        after.sort(Comparator.comparingInt(Subscriber::getId));
        Assert.assertEquals (after,before);
    }

    @Test(dataProvider = "subscriberProvider")
    public void testDeleteSubscriber(Subscriber subscriber) {
        HomePage homePage = open (baseUrl,HomePage.class);
        SubscribersPage subscribersPage = homePage.goToSubscriber ();
        List<Subscriber> before = subscribersPage.getAllSubscribers ();
        List<Subscriber> after;
        //if (!before.isEmpty ()) {
            subscribersPage.selectSubscriber(6714);
            subscribersPage.clickDeleteButton();
            after = subscribersPage.getAllSubscribers ();
        /*} else {
            FormPage formPage = subscribersPage.goToFormPage();
            formPage.fillFirstNameField(subscriber.getFirstName ());
            formPage.fillLastNameField(subscriber.getLastName ());
            formPage.selectGender(subscriber.getGender().toValue());
            formPage.fillAgeField(subscriber.getAge ());
            subscribersPage = formPage.saveSubscriber();
            before = subscribersPage.getAllSubscribers ();
            //Удалить с формы
            after = subscribersPage.getAllSubscribers ();
        }*/
        Assert.assertEquals (after.size(),before.size()-1);
    }

    @DataProvider (name = "subscriberProvider")
    public Object[][] subscriberProvider() {
        Subscriber subscriber = new Subscriber ();
        subscriber.setFirstName ("test2");
        subscriber.setLastName ("test2");
        subscriber.setAge (25);
        subscriber.setGender (Gender.parseGender ("ж"));

        return new Object[][] {
                {subscriber}
        };
    }
    @DataProvider(name = "editSubscriberProvider")
    public Object[][] editSubscriberProvider() {
        Subscriber subscriber = new Subscriber();
        subscriber.setId(10);
        subscriber.setFirstName ("EditedFName");
        subscriber.setLastName ("EditedLName");
        subscriber.setAge (25);
        subscriber.setGender (Gender.parseGender ("ж"));

        return new Object[][]{
                {subscriber}
        };
    }

    @AfterClass
    public void afterClass() {
        closeWindow();
    }
}