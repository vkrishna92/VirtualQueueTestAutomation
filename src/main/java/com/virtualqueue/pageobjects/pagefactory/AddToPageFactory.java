package com.virtualqueue.pageobjects.pagefactory;

import com.virtualqueue.pageobjects.desktop.AddToQueuePage;
import com.virtualqueue.pageobjects.mobile.AddToQueueMPage;
import com.virtualqueue.pageobjects.pagerepository.IAddToQueuePage;
import com.virtualqueue.pageobjects.tablet.AddToQueueTPage;
import com.virtualqueue.utils.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AddToPageFactory {
    private static final Logger log = LoggerHelper.getLogger(AddToPageFactory.class);
    public static IAddToQueuePage getPage(WebDriver driver, String platForm) {
        log.info("Initializing AddToQueue Page object for platform: " + platForm);
        switch (platForm) {
            case "Mobile":
                return new AddToQueueMPage(driver);
            case "Table":
                return new AddToQueueTPage(driver);
            default:
                return new AddToQueuePage(driver);
        }
    }
}
