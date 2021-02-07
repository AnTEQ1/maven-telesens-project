package com.academy.lesson17.ht.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement loginField;
    @FindBy(id = "passwd")
    private WebElement passwordField;
    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@id='center_column']/div[1]/ol/li")
    private WebElement errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputLogin(String login) {
        inputField(loginField,login);
        return this;
    }

    public LoginPage inputPassword(String password) {
        inputField(passwordField,password);
        return this;
    }

    public LoginPage submitForError() {
        submitButton.click();
        return this;
    }

    public MyAccountPage submitForSuccess() {
        submitButton.click();
        return new MyAccountPage(driver);
    }

    public String getErrorMessage() {
        return errorMsg.getText();
    }
}
