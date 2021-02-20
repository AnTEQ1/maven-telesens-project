package com.academy.lesson13.ht;

import com.academy.telesens.util.PropertyProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class AuthPageTests {
    private WebDriver driver;
    private String baseUrl = "http://automationpractice.com/index.php";
    ReadTestDataFromFile readTestDataFromFile = new ReadTestDataFromFile();
    List<List<String>> dataSet = readTestDataFromFile.readData();

    @BeforeClass (alwaysRun = true)
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", PropertyProvider.get("chrome.driver"));
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // selenium 4...
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // selenium 3...
    }

    @Test
    public void wrongLoginAndPasswordTest() {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(dataSet.get(0).get(0));
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(dataSet.get(0).get(1));
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        String errMsgExp = dataSet.get(0).get(2);
        String errMsgAct = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertEquals(errMsgAct, errMsgExp);
    }

    @Test
    public void wrongLoginTest() {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(dataSet.get(1).get(0));
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(dataSet.get(1).get(1));
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        String errMsgExp = dataSet.get(1).get(2);
        String errMsgAct = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertEquals(errMsgAct, errMsgExp);
    }

    @Test
    public void wrongPasswordTest(){
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(dataSet.get(2).get(0));
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(dataSet.get(2).get(1));
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        String errMsgExp = dataSet.get(2).get(2);
        String errMsgAct = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertEquals(errMsgAct, errMsgExp);
    }

    @Test
    public void emptyLoginAndPasswordTest()  {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(dataSet.get(3).get(0));
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(dataSet.get(3).get(1));
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        String errMsgExp = dataSet.get(3).get(2);
        String errMsgAct = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertEquals(errMsgAct, errMsgExp);
    }

    @Test
    public void emptyPasswordTest()  {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(dataSet.get(4).get(0));
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(dataSet.get(4).get(1));
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        String errMsgExp = dataSet.get(4).get(2);
        String errMsgAct = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertEquals(errMsgAct, errMsgExp);
    }

    @Test
    public void emptyLoginTest() {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(dataSet.get(5).get(0));
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(dataSet.get(5).get(1));
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        String errMsgExp = dataSet.get(5).get(2);
        String errMsgAct = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertEquals(errMsgAct, errMsgExp);
    }

    @Test
    public void incorrectLoginTest() {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(dataSet.get(6).get(0));
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(dataSet.get(6).get(1));
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        String errMsgExp = dataSet.get(6).get(2);
        String errMsgAct = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertEquals(errMsgAct, errMsgExp);
    }

    @AfterClass (alwaysRun = true)
    public void tearDown()  {
        driver.quit();
    }
}
