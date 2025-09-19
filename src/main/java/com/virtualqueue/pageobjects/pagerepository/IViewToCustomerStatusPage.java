package com.virtualqueue.pageobjects.pagerepository;

public interface IViewToCustomerStatusPage {
    public void verifyPage();

    public String formTitle();

    public String getStatus();

    public int getPosition();

    public int getAvgWaitTime();

    public String getName();

    public String getPartySize();

    public String getJoinedAt();

    public String getServedAt();

    public void clickRefreshButton();

    public void clickLeaveQueue();
}
