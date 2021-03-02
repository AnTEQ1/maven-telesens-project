package com.academy.selenide.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.lang.ref.SoftReference;

import static com.codeborne.selenide.Selenide.page;

public class EditFormPage {
    @FindBy(id = "id")
    private SelenideElement id;
    @FindBy(id = "first-name")
    private SelenideElement fName;
    @FindBy(id = "last-name")
    private SelenideElement lName;
    @FindBy(id = "MALE")
    private SelenideElement radioMale;
    @FindBy(id = "FEMALE")
    private SelenideElement radioFemale;
    @FindBy(id = "age")
    private SelenideElement ageField;
    @FindBy(className = "btn-success")
    private SelenideElement submitChanges;


    public EditFormPage fillFirstNameField(String value) {
        fName.setValue(value);
        return page(EditFormPage.class);
    }

    public EditFormPage fillLastNameField(String value) {
        lName.setValue(value);
        return page(EditFormPage.class);
    }

    public EditFormPage editGender (String gender) {
        switch (gender) {
            case "ж":
                radioFemale.click();
                break;
            case "м":
                radioMale.click();
                break;
        }
        return page(EditFormPage.class);
    }

    public EditFormPage fillAgeField (int age) {
        ageField.setValue(String.valueOf(age));
        return page(EditFormPage.class);
    }

    public SubscribersPage saveSubscriber() {
        submitChanges.click();
        return page(SubscribersPage.class);
    }
}
