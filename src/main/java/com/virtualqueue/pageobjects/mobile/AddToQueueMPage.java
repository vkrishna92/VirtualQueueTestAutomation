package com.virtualqueue.pageobjects.mobile;

import com.virtualqueue.pageobjects.pagerepository.IAddToQueuePage;
import org.openqa.selenium.WebDriver;

public class AddToQueueMPage extends BaseMobilePage implements IAddToQueuePage {
    public AddToQueueMPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {

    }

    @Override
    public String getBannerTitle() {
        return "";
    }

    @Override
    public String getFormTitle() {
        return "";
    }

    @Override
    public String getQueueCount() {
        return "";
    }

    @Override
    public String getAvgWaitTimeInMins() {
        return "";
    }

    @Override
    public void enterName(String name) {

    }

    @Override
    public void setPartySize(int partySize) {

    }

    @Override
    public void clickOnJoinQueueButton() {

    }
}
