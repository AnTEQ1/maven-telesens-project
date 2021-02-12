package com.academy.lesson17.ht.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage{

    private String baseUrl;

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;
    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]/a")
    private WebElement dressesLink;

    public HomePage(WebDriver driver, String baseUrl) {
        super(driver);
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public HomePage goToHomePage() {
        driver.get(baseUrl);
        return this;
    }

    public LoginPage login() {
        signInLink.click();
        return new LoginPage(driver);
    }

    public DressesPage goToDressesPage() {
        dressesLink.click();
       return new DressesPage (driver);
    }
}
