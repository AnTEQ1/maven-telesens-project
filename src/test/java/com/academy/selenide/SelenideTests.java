package com.academy.selenide;

import com.academy.selenide.page.EditFormPage;
import com.academy.selenide.page.FormPage;
import com.academy.selenide.page.HomePage;
import com.academy.selenide.page.SubscribersPage;
import com.academy.telesens.lesson11.ht.task3.Gender;
import com.academy.telesens.lesson6.Subscriber;
import com.codeborne.selenide.Configuration;
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
    }
    @Test
    public void testEditSubscriber() {
        HomePage homePage = open (baseUrl,HomePage.class);
        SubscribersPage subscribersPage = homePage.goToSubscriber ();
        List<Subscriber> before = subscribersPage.getAllSubscribers ();

        //before - найти того абонента которого будем менять и заменить тем на кого будем менять в тесте

        EditFormPage editFormPage = subscribersPage.editSubscriber(10);
        editFormPage.fillFirstNameField("Edited");
        editFormPage.fillLastNameField("Edited");
        subscribersPage = editFormPage.saveSubscriber();

        List<Subscriber> after = subscribersPage.getAllSubscribers ();
        Assert.assertEquals (after,before);
    }

    @Test
    /*public void testDeleteSubscriber(Subscriber subscriber) {
        HomePage homePage = open (baseUrl,HomePage.class);
        SubscribersPage subscribersPage = homePage.goToSubscriber ();
        List<Subscriber> before = subscribersPage.getAllSubscribers ();
        List<Subscriber> after;
        if (!before.isEmpty ()) {
            //Удалить с формы
            after = subscribersPage.getAllSubscribers ();
        } else {
            FormPage formPage = subscribersPage.goToFormPage();
            formPage.fillFirstNameField(subscriber.getFirstName ());
            formPage.fillLastNameField(subscriber.getLastName ());
            formPage.selectGender(subscriber.getGender().toValue());
            formPage.fillAgeField(subscriber.getAge ());
            subscribersPage = formPage.saveSubscriber();
            before = subscribersPage.getAllSubscribers ();
            //Удалить с формы
            after = subscribersPage.getAllSubscribers ();
        }
        before.remove ();//удалить абонента которого удалили с формы)
        Assert.assertEquals (after,before);
    }

    */

    @DataProvider (name = "subscriberProvider")
    public Object[][] subscriberProvider() {
        Subscriber subscriber = new Subscriber ();
        //subscriber.setId ();
        subscriber.setFirstName ("test2");
        subscriber.setLastName ("test2");
        subscriber.setAge (25);
        subscriber.setGender (Gender.parseGender ("ж"));

        return new Object[][] {
                {subscriber}
        };
    }

    @AfterClass
    public void afterClass() {
        closeWindow();
    }
}