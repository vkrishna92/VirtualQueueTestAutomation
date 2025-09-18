package com.virtualqueue.pageobjects.tablet;

import com.virtualqueue.pageobjects.pagerepository.IAddToQueuePage;
import org.openqa.selenium.WebDriver;

public class AddToQueueTPage extends BaseTabletPage implements IAddToQueuePage {
    public AddToQueueTPage(WebDriver driver) {
        super(driver);
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
