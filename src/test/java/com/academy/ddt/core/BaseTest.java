package com.academy.ddt.core;

import com.academy.telesens.util.PropertyProvider;
import io.qameta.allure.Attachment;
import junit.framework.TestListener;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@Listeners(TestListenerImpl.class)
public class BaseTest {
    private static Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    private static Logger LOG_TRAFFIC = LoggerFactory.getLogger("TRAFFIC");
    private DetailWebDriverEventListener eventListener;
    protected EventFiringWebDriver driver;
    private BrowserMobProxy proxy;

    private boolean logPerformance;
    private boolean logBrowser;
    private boolean logTraffic;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        initCfg();
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", PropertyProvider.get("chrome.driver"));
                ChromeOptions options = new ChromeOptions();

               if (logTraffic) {
                   initProxyForTrafic(options);
               }

               if (logPerformance) {
                   initLogPerformance(options);
               }

                driver = new EventFiringWebDriver(new ChromeDriver(options));
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", PropertyProvider.get("firefox.driver"));
                driver = new EventFiringWebDriver(new  FirefoxDriver());
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Browser %s is not supported", browser)
                );
        }
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // selenium 4...
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // selenium 3...
        driver.manage().window().maximize();
        eventListener = new DetailWebDriverEventListener(logPerformance,logBrowser);
        driver.register(eventListener);
    }



    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        if (logTraffic) {
            makeLogTraffic();
        }
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

    protected void makeScreenShot() {
        eventListener.makeScreenshot(driver); // можно вызывать где нужно в тесте и делать скрин, но ноужно передать куда сохранить скрин иначе сохранит куда прописано по умолчанию
    }
    @Attachment()
    protected byte[] makeScreenshotForReport() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    private void initCfg() {
        logPerformance = PropertyProvider.getBoolean("log.performance");
        logBrowser = PropertyProvider.getBoolean("log.browser");
        logTraffic = PropertyProvider.getBoolean("log.traffic");
    }

    private  void initProxyForTrafic(ChromeOptions options) {
        proxy = new BrowserMobProxyServer();
        proxy.start(1001);

        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // configure it as a desired capability
        options.setCapability(CapabilityType.PROXY, seleniumProxy);
        options.addArguments("--ignore-certificate-errors");
        proxy.newHar("automation");
    }

    private void initLogPerformance(ChromeOptions options) {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        //options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        options.setCapability("goog:loggingPrefs", logPrefs);
    }

    private void makeLogTraffic() {
        Har har = proxy.endHar();
        List<HarEntry> entries = har.getLog().getEntries();
        for (int i = 0; i < entries.size(); i++) {
            HarEntry item = entries.get(i);
            LOG_TRAFFIC.debug(item.getResponse().getStatus() + ":" + item.getRequest().getUrl());
            //LOG_TRAFFIC.debug(item.getRequest().getHeaders().toString());
        }
    }
}
