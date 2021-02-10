package com.academy.lesson17.ht.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void inputField(WebElement field, String value) {
        field.click();
        field.clear();
        field.sendKeys(value);
    }

    public void selectItem (WebElement field, String value) {
        Select select = new Select(field);
        select.selectByVisibleText(value);
    }
}
