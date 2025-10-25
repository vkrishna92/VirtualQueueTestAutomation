package com.virtualqueue.uitests;

import com.virtualqueue.pageobjects.pagefactory.AddToPageFactory;
import com.virtualqueue.pageobjects.pagefactory.ViewToCustomerStatusPageFactory;
import com.virtualqueue.pageobjects.pagerepository.IAddToQueuePage;
import com.virtualqueue.pageobjects.pagerepository.IViewToCustomerStatusPage;
import com.virtualqueue.utils.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToQueueTest extends BaseTest{

    private final Logger log = LoggerHelper.getLogger(BaseTest.class);
    private final String pageUrl = "p/add-to-queue/";
    IAddToQueuePage addToQueue;

    @BeforeClass
    public void testSetup() {
        driver.get(baseUrl + pageUrl + queueId);
        addToQueue = AddToPageFactory.getPage(driver, platform);
        // check if addToQueue is null
        if (addToQueue == null) {
            log.error("AddToQueue page is null");
            throw new RuntimeException("AddToQueue page is null");
        }
    }

    @Test
    public void verifyAddToQueue() {
        addToQueue.verifyPage();
        Assert.assertEquals(addToQueue.getBannerTitle(), "Test Store");
        Assert.assertEquals(addToQueue.getFormTitle(), "Reserve Your Table");
    }

    @Test
    public void verifyAddToQueueForm() {
        addToQueue.verifyPage();
        addToQueue.enterName("Test User");
        addToQueue.setPartySize(2);
        addToQueue.clickOnJoinQueueButton();
        IViewToCustomerStatusPage viewToCustomerStatus = ViewToCustomerStatusPageFactory.getPage(driver, platform);
        viewToCustomerStatus.verifyPage();
        Assert.assertEquals(viewToCustomerStatus.getName(), "Test User");
        Assert.assertEquals(viewToCustomerStatus.getPartySize(), "2");
        Assert.assertEquals(viewToCustomerStatus.getStatus(), "WAITING");
    }
}
