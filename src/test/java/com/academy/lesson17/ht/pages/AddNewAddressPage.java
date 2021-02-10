package com.academy.lesson17.ht.pages;

import org.apache.commons.math3.analysis.function.Add;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewAddressPage extends BasePage{

    @FindBy(id = "address1")
    private WebElement addressField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy (id = "id_state")
    private WebElement listOfStates;
    @FindBy (id = "postcode")
    private WebElement zipCode;
    @FindBy (id = "phone")
    private WebElement phoneNumber;
    @FindBy (id = "phone_mobile")
    private WebElement mobilePhoneNumber;
    @FindBy (id = "alias")
    private WebElement aliasField;
    @FindBy (id = "submitAddress")
    private WebElement saveAddress;

    public AddNewAddressPage(WebDriver driver) {
        super(driver);
    }

    public AddNewAddressPage inputAddress(String address) {
        inputField(addressField,address);
        return this;
    }

    public AddNewAddressPage inputCity(String  city) {
        inputField(cityField, city);
        return this;
    }

    public AddNewAddressPage selectState (String state) {
        selectItem(listOfStates, state);
        return this;
    }

    public AddNewAddressPage inputZipCode (String code) {
        inputField(zipCode, code);
        return this;
    }

    public AddNewAddressPage inputPhoneNumber (String number) {
        inputField(phoneNumber, number);
        return this;
    }

    public AddNewAddressPage inputMobilePhoneNumber(String number) {
        inputField(mobilePhoneNumber , number);
        return this;
    }

    public AddNewAddressPage inputAlias (String alias) {
        inputField(aliasField, alias);
        return this;
    }

    public MyAddressesPage saveAddress() {
        saveAddress.click();
        return new MyAddressesPage(driver);
    }

}
