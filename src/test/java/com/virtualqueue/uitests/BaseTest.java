package com.virtualqueue.uitests;

import com.virtualqueue.utils.LoggerHelper;
import com.virtualqueue.utils.PropertyReader;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;
    protected String platform;
    protected String queueId;
    private final Logger log = LoggerHelper.getLogger(BaseTest.class);

    @Parameters({"env", "platform"})
    @BeforeClass(alwaysRun = true)
    public void setupClass(String env, String _platform) {
        log.info("Initializing webdriver.");
        log.info("Environment {}", env);
        PropertyReader.loadProperties(env);

        // set base variables
        baseUrl = getBaseUrl();
        queueId = getQueueId();
        platform = _platform;

        log.info("Base Url: {} queueId: {} platform: {}", baseUrl, queueId, platform);

        // initializing driver
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            
            log.info("Driver initialized successfully.");
        }
        catch (Exception e) {
            log.error("Error initializing driver.", e);
            throw e;
        }

    }


    @AfterClass(alwaysRun = true)
    public void teardownClass() {
        log.info("After suite.");
        if (driver != null) {
            driver.quit();
        }
    }
    
    protected void navigateToPage(String path) {
        String fullUrl = baseUrl + path + queueId;
        log.info("Navigating to: {}", fullUrl);
        driver.get(fullUrl);
    }

    private String getBaseUrl() {
        return PropertyReader.getProperty("app.baseUrl");
    }

    private String getQueueId() {
        return PropertyReader.getProperty("app.queueId");
    }






}
