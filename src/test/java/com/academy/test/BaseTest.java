package com.academy.test;

import com.academy.telesens.lesson16.LoggingDemo;
import com.academy.telesens.util.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    private static Logger LOG = LoggerFactory.getLogger(BaseTest.class);
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

    @BeforeMethod
    public void testSetUp(Method method, Object[] parameters) {
    LOG.info("Test '{}' start. Parameters: {}", method.getName(),parameters);
    }

    @AfterMethod
    public void testTearDownTests(Method method) {
        LOG.info("Test '{}' finished.", method);
    }
}
