package com.academy.test;

import com.academy.telesens.util.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
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

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver!=null) {
            driver.quit();
        }
    }
}
