package com.academy.ddt.core;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);//необходимо чтобы проинициализировать аннотационные данные
    }
    @Step("enter {0} {1}")
    public void inputField (WebElement textField, String value) {
        textField.click();
        textField.clear();
        textField.sendKeys(value);
    }
}
