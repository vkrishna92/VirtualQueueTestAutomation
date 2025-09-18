package com.virtualqueue.uitests;

import com.virtualqueue.pageobjects.pagefactory.AddToPageFactory;
import com.virtualqueue.pageobjects.pagerepository.IAddToQueuePage;
import com.virtualqueue.utils.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToQueueTest extends BaseTest{

    private final Logger log = LoggerHelper.getLogger(BaseTest.class);
    private final String pageUrl = "p/add-to-queue/3fa85f64-5717-4562-b3fc-2c963f66afa6";
    IAddToQueuePage addToQueue;
    @BeforeTest
    public void testSetup() {
        driver.get(baseUrl + pageUrl);
        addToQueue = AddToPageFactory.getPage(driver, platform);
        if (addToQueue == null) {
            log.info("Unable to initialize AddToQueue Page object for platform " + platform);
        }
    }

    @Test
    public void verifyAddToQueue() {
        Assert.assertEquals(addToQueue.getBannerTitle(), "Bella Vista Bistro");
        Assert.assertEquals(addToQueue.getQueueCount(), "0");
        Assert.assertEquals(addToQueue.getAvgWaitTimeInMins(), "0");
    }
}
