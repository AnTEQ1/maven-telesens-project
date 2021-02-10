package com.academy.lesson17.ht.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressEditPage extends BasePage{
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy (id = "alias")
    private WebElement aliasField;
    @FindBy (id = "submitAddress")
    private WebElement saveAddress;

    public AddressEditPage(WebDriver driver) {
        super(driver);
    }

    public AddressEditPage inputCity(String  city) {
        inputField(cityField, city);
        return this;
    }

    public AddressEditPage inputAlias (String alias) {
        inputField(aliasField, alias);
        return this;
    }

    public MyAddressesPage saveEditedAddress() {
        saveAddress.click();
        return new MyAddressesPage(driver);
    }
}
