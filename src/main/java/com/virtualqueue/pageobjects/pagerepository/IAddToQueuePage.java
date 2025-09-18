package com.virtualqueue.pageobjects.pagerepository;

public interface IAddToQueuePage {

    public String getBannerTitle();

    public String getFormTitle();

    public String getQueueCount();

    public String getAvgWaitTimeInMins();

    public void enterName(String name);

    public void setPartySize(int partySize);

    public void clickOnJoinQueueButton();

}
