package com.academy.lesson15.ht;

import com.academy.telesens.util.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", PropertyProvider.get("chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
