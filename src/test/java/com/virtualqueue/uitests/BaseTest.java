package com.virtualqueue.uitests;

import com.virtualqueue.utils.LoggerHelper;
import com.virtualqueue.utils.PropertyReader;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;
    protected String platform;
    protected String queueId;
    private final Logger log = LoggerHelper.getLogger(BaseTest.class);
    @BeforeSuite
    @Parameters({"env", "platform"})
    public void setupSuite(String env, String platform) {
        log.info("Initializing webdriver.");
        log.info("Environment {}", env);
        PropertyReader.loadProperties(env);

        // set base variables
        this.baseUrl = getBaseUrl();
        this.queueId = getQueueId();
        this.platform = platform;

        log.info("Base Url: {}%n queueId: {}%n platform: {}%n", baseUrl, queueId, platform);;

        // initializing driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }


    @AfterSuite
    public void afterSuite() {
        log.info("After suite.");
        driver.quit();
    }

    private String getBaseUrl() {
        return PropertyReader.getProperty("app.baseUrl");
    }

    private String getQueueId() {
        return PropertyReader.getProperty("app.queueId");
    }






}
