package com.academy.test;

import com.academy.telesens.util.PropertyProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class AutomationPracticeTests {
    private WebDriver driver;
    private String baseUrl = "http://automationpractice.com/index.php";

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

    @Test
    @Ignore
    public void testAuth() {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("aser@user");
        driver.findElement(By.xpath("//form[@id='login_form']/div")).click();
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("user");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();

        String errMsgExpected = "Invalid email address.";
        String errMsgActual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertEquals(errMsgActual, errMsgExpected);

    }

    @Test
    @Ignore
    public void testWomenCategory() {
        String expectedWord = "women";
        String expectedTextFromPicture = "You will find here all woman fashion collections.";
        String expectedAmountOfItems = "There are 7 products.";
        driver.findElement(By.linkText("Women")).click();
        String factTitle = driver.findElement(By.xpath("/html/head/title")).getAttribute("text").substring(0, 5).toLowerCase();
        String factPageNavigator = driver.findElement(By.className("navigation_page")).getText().toLowerCase();
        String categoryBlock = driver.findElement(By.className("title_block")).getText().toLowerCase();
        String nameFromPicture = driver.findElement(By.className("category-name")).getText().toLowerCase();
        String textFromPicture = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/div/p[1]/strong")).getText();
        String categoryName = driver.findElement(By.className("cat-name")).getText().toLowerCase().replaceAll("\\s", "");
        String amountOfItems = driver.findElement(By.className("heading-counter")).getText();
        String nameCategoryInFooter = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/section[2]/div/div/ul/li/a")).getText().toLowerCase();
        Assert.assertEquals(factTitle, expectedWord);
        Assert.assertEquals(factPageNavigator, expectedWord);
        Assert.assertEquals(categoryBlock, expectedWord);
        Assert.assertEquals(nameFromPicture, expectedWord);
        Assert.assertEquals(textFromPicture, expectedTextFromPicture);
        Assert.assertEquals(categoryName, expectedWord);
        Assert.assertEquals(amountOfItems, expectedAmountOfItems);
        Assert.assertEquals(nameCategoryInFooter, expectedWord);
    }

    @Test
    public void rangeTest() {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Women")).click();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[1]")); // получае нужный слайдер
        String currentRange = ""; // Переменная для цены
        String expectedCoast = "24.14"; // Ожидаемый результат
        Actions actions = new Actions(driver);
        actions.clickAndHold(element); // Захватываем слайдер
        int loc = 0; // Переменная для сдвига по оси х
        int locToScroll = element.getLocation().y; //получаем позицию слайдера по оси у для скрола
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, " + locToScroll + ");"); // Выглядит не очень(, тем не менее скролим к элементу
        while (!(currentRange.equals(expectedCoast))) { //Пока текущее значение не равно ожидаемому
            actions.moveByOffset(loc + 1, 0).perform(); //передвигаем захваченный элемент на 1px
            currentRange = driver.findElement(By.xpath("//*[@id=\"layered_price_range\"]")).getText().substring(1, 6); //Получаем текущий диапазон и выризаем только нижнюю его границу
            loc = loc + 1; // увеличиваем переменную для сдвига по оси х
        }
        Assert.assertEquals(currentRange, expectedCoast); // сравниваем ожидаемое и фактическое значение нижней границы диапазона, хотя это лешнее))
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver!=null) {
            driver.quit();
        }
    }

}

