package com.academy.lesson15.ht;

import com.academy.telesens.util.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void startUp(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", PropertyProvider.get("chrome.driver"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", PropertyProvider.get("firefox.driver"));
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Browser %s is not supported", browser)
                );
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
