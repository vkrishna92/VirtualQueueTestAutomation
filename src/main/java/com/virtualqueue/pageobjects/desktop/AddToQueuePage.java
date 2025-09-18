package com.virtualqueue.pageobjects.desktop;

import com.virtualqueue.pageobjects.pagerepository.IAddToQueuePage;
import com.virtualqueue.utils.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToQueuePage extends BaseDesktopPage implements IAddToQueuePage {

    // Banner elements
    private final By bannerImage = By.xpath("//div[@class='banner-image']");
    private final By queueTitle = By.xpath("//h1[@class='hero-title']");
    private final By location = By.xpath("//h1[@class='hero-title']/following-sibling::p");
    private final By subTitle = By.xpath("//p[@class='hero-subtitle']");

    // form elements
    private final By formTitle = By.xpath("//div[@class='container']/h2");
    private final By queueCount = By.xpath("//div[@class='container']/div[@class='queue-stats']/div[@class='stat-item'][1]/span[@class='stat-count']");
    private final By avgWaitTimeInMins = By.xpath("//div[@class='container']/div[@class='queue-stats']/div[@class='stat-item'][1]/span[@class='stat-count']");
    private final By nameInput = By.xpath("//input[@ng-reflect-name='customerName']");
    private final By partySizeList = By.xpath("//nz-radio-group/label");
    private final By joinQueueBtn = By.xpath("//button[contains(@class,'join-queue-button')]");

    // logger
    private final Logger log = LoggerHelper.getLogger(AddToQueuePage.class);
    //webdriver
    private final WebDriver driver;
    public AddToQueuePage(WebDriver _driver) {
        super(_driver);
        driver = _driver;
    }

    @Override
    public String getBannerTitle() {
        log.info("Getting banner title");
        return  driver.findElement(queueTitle).getText();
    }

    @Override
    public String getFormTitle() {
        log.info("Getting form title");
        return driver.findElement(formTitle).getText();
    }

    @Override
    public String getQueueCount() {
        log.info("Getting queue count.");
        return driver.findElement(queueCount).getText();
    }

    @Override
    public String getAvgWaitTimeInMins() {
        log.info("Getting avg wait time in mins.");
        return driver.findElement(avgWaitTimeInMins).getText();
    }

    @Override
    public void enterName(String name) {
        log.info(String.format("Entering name: %s", name));
        driver.findElement(nameInput).sendKeys(name);
    }

    @Override
    public void setPartySize(int partySize) {
        log.info(String.format("Setting party size to: %d", partySize));
        List<WebElement> sizes = driver.findElements(partySizeList);
        for (WebElement size : sizes) {
            if (size.getText().equals(String.valueOf(partySize))) {
                size.click();
                break;
            }
        }
    }

    @Override
    public void clickOnJoinQueueButton() {
        log.info("Clicking on Join Queue button");
        driver.findElement(joinQueueBtn).click();
    }
}
