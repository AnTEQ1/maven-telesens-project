package com.academy.ddt.page;

import com.academy.ddt.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    @FindBy(xpath = "//a[contains(@class, 'account')]/span")
    private WebElement userNameEl;

    @FindBy(linkText = "Sign out")
    private WebElement signOutButton;
    
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return userNameEl.getText();
    }

    public LoginPage logout() {
        signOutButton.click();
        return new LoginPage(driver);
    }
}
