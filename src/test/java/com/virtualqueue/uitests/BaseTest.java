package com.virtualqueue.uitests;

import com.virtualqueue.pageobjects.desktop.AddToQueuePage;
import com.virtualqueue.utils.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;
    protected final String baseUrl = "http://localhost:4200/";
    protected final String platform = "Desktop";
    private final Logger log = LoggerHelper.getLogger(BaseTest.class);
    @BeforeSuite
    public void setupSuite() {
        log.info("Initializing webdriver.");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }


    @AfterSuite
    public void afterSuite() {
        log.info("After suite.");
        driver.quit();
    }




}
