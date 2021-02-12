package com.academy.lesson17.ht.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAddressesPage extends BasePage{

    @FindBy(linkText = "Add a new address")
    private WebElement addNewAddressButton;
    @FindBy (xpath = "//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[4]")
    private WebElement factAddress;
    @FindBy (xpath = "//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[5]")
    private WebElement cityStateZipCode;
    @FindBy (xpath = "//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[7]")
    private WebElement factPhoneNumber;
    @FindBy (xpath = "//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[8]")
    private WebElement factMobileNumber;
    @FindBy (xpath = "//h3[contains(text(),\"For edit\")]/../../li[last()]/a[1]")
    private WebElement editAddressButton;
    @FindBy (className = "page-subheading")
    private List<WebElement> addresses;
    @FindBy (xpath = "//li[last()]/a[2]/span[contains(text(),'Delete')] ")
    private WebElement addressDeleteButton;


    public MyAddressesPage(WebDriver driver) {
        super(driver);
    }

    public AddNewAddressPage goToAddNewAddressPage() {
        addNewAddressButton.click();
        return new AddNewAddressPage(driver);
    }

    public AddressEditPage goToAddressEditPage() {
        editAddressButton.click();
        return new AddressEditPage(driver);
    }

    public String getFactAddress() {
        return factAddress.getText();
    }

    public String getCityStateZipCode() {
        return cityStateZipCode.getText();
    }

    public String getPhoneNumber() {
        return factPhoneNumber.getText();
    }

    public String getMobileNumber() {
        return factMobileNumber.getText();
    }

    public String getEditedAddressName() {
        return addresses.get(2).getText();
    }

    public int getAmountOfAddresses() {
        return addresses.size();
    }

    public MyAddressesPage deleteAddress (String addressAlias) {
        String pathToAddressToDelete = String.format("//h3[contains(text(),\"%s\")]/../../%s",addressAlias, addressDeleteButton);
        driver.findElement(By.xpath(pathToAddressToDelete));
        return this;
    }
}
