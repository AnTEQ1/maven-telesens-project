package com.academy.selenide.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class FormPage {
    @FindBy (id = "fname")
    private SelenideElement firstNameField;
    @FindBy (id = "lname")
    private SelenideElement lastNameField;
    @FindBy (id = "FEMALE")
    private SelenideElement radioFemale;
    @FindBy (id = "MALE")
    private SelenideElement radioMale;
    @FindBy (id = "age")
    private SelenideElement ageField;
    @FindBy (css = "body > div > form > button")
    private SelenideElement saveButton;

    public FormPage fillFirstNameField (String fName) {
        firstNameField.setValue(fName);
        return page(FormPage.class);
    }
    public FormPage fillLastNameField (String lName) {
        lastNameField.setValue(lName);
        return page(FormPage.class);
    }
    public FormPage selectGender (String gender) {
        switch (gender) {
            case "ж":
                radioFemale.click();
                break;
            case "м":
                radioMale.click();
                break;
        }
        return page(FormPage.class);
    }
    public FormPage fillAgeField (int age) {
        ageField.setValue(String.valueOf(age));
        return page(FormPage.class);
    }
    public SubscribersPage saveSubscriber () {
        saveButton.click();
        return page(SubscribersPage.class);
    }

}
