package com.academy.lesson14.ht;

import com.academy.telesens.util.PropertyProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddNewAddressTest {
    private WebDriver driver;
    private String baseUrl = "http://automationpractice.com/index.php";

    @BeforeClass (alwaysRun = true)
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", PropertyProvider.get("chrome.driver"));
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // selenium 4...
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // selenium 3...
        }

    @Test
    public void testNewAddressAdd() {
        String address = "Address Test";
        String city = "City Test";
        String state = "Pennsylvania";
        String zipCode = "26598";
        String homeNumber = "+380577556584";
        String mobileNumber = "+380958895644";
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("an.andrey.90@gmail.com");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("123qweASD");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.linkText("My addresses")).click();
        driver.findElement(By.linkText("Add a new address")).click();
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys(address);
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city);
        WebElement listOfStates = driver.findElement(By.id("id_state"));
        Select select = new Select(listOfStates);
        select.selectByVisibleText(state);
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys(zipCode);
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys(homeNumber);
        driver.findElement(By.id("phone_mobile")).clear();
        driver.findElement(By.id("phone_mobile")).sendKeys(mobileNumber);
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys("Test Address");
        driver.findElement(By.id("submitAddress")).click();
        String factAddress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[4]")).getText();
        String cityStateZipCode = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[5]")).getText();
        String factPhoneNumber = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[7]")).getText();
        String factMobileNumber = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[8]")).getText();
        Assert.assertEquals(factAddress,address);
        Assert.assertEquals(cityStateZipCode, city + ", " + state + " " + zipCode);
        Assert.assertEquals(factPhoneNumber, homeNumber);
        Assert.assertEquals(factMobileNumber,mobileNumber);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @AfterClass (alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
