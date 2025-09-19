package com.virtualqueue.pageobjects.desktop;

import com.virtualqueue.pageobjects.pagerepository.IViewToCustomerStatusPage;
import com.virtualqueue.utils.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewToCustomerStatusPage extends BaseDesktopPage implements IViewToCustomerStatusPage {

    private final By formTitle = By.xpath("//h2[@class='text-center']");
    private final By status = By.xpath("//div[contains(@class,'status-badge')]");
    private final By position = By.xpath("//div[@class='container']/div[@class='queue-stats']/div[@class='stat-item'][1]/span[@class='stat-count']");
    private final By avgWaitTime = By.xpath("//div[@class='container']/div[@class='queue-stats']/div[@class='stat-item'][1]/span[@class='stat-count']");

    // form elements
    private final By name = By.xpath("//div[@class='customer-details']/div[1]/span[2]");
    private final By partySize = By.xpath("//div[@class='customer-details']/div[2]/span[2]");
    private final By joinedAt = By.xpath("//div[@class='customer-details']/div[3]/span[2]");
    private final By servedAt = By.xpath("//div[@class='customer-details']/div[4]/span[2]");
    private final By refreshButton = By.xpath("//button/span[text()='Refresh ']");
    private final By leaveQueueButton = By.xpath("//button/span[text()='Leave Queue ']");

    // logger
    private final Logger log = LoggerHelper.getLogger(AddToQueuePage.class);

    // driver
    private WebDriver driver;

    public ViewToCustomerStatusPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public void verifyPage() {
        waitForElementToBePresent(formTitle);
        waitForElementToBePresent(status);
        waitForElementToBePresent(position);
        waitForElementToBePresent(avgWaitTime);
        waitForElementToBePresent(name);
        waitForElementToBePresent(partySize);
        waitForElementToBePresent(joinedAt);
        waitForElementToBePresent(servedAt);
        waitForElementToBePresent(refreshButton);
        waitForElementToBePresent(leaveQueueButton);
    }

    @Override
    public String formTitle() {
        log.info("Getting form title");
        return driver.findElement(formTitle).getText();
    }

    @Override
    public String getStatus() {
        log.info("Getting status");
        return driver.findElement(status).getText();
    }

    @Override
    public int getPosition() {
        log.info("Getting position");
        return Integer.parseInt(driver.findElement(position).getText());
    }

    @Override
    public int getAvgWaitTime() {
        log.info("Getting avg wait time");
        return Integer.parseInt(driver.findElement(avgWaitTime).getText());
    }

    @Override
    public String getName() {
        log.info("Getting name");
        return driver.findElement(name).getText();
    }

    @Override
    public String getPartySize() {
        log.info("Getting party size");
        return driver.findElement(partySize).getText();
    }

    @Override
    public String getJoinedAt() {
        log.info("Getting joined at");
        return driver.findElement(joinedAt).getText();
    }

    @Override
    public String getServedAt() {
        log.info("Getting served at");
        return driver.findElement(servedAt).getText();
    }

    @Override
    public void clickRefreshButton() {
        log.info("Clicking on refresh button");
        driver.findElement(refreshButton).click();
    }

    @Override
    public void clickLeaveQueue() {
        log.info("Clicking on leave queue button");
        driver.findElement(leaveQueueButton).click();
    }
}
