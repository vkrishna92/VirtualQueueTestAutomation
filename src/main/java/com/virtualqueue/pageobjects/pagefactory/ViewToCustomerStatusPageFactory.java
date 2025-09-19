package com.virtualqueue.pageobjects.pagefactory;

import com.virtualqueue.pageobjects.desktop.ViewToCustomerStatusPage;
import com.virtualqueue.pageobjects.pagerepository.IViewToCustomerStatusPage;
import com.virtualqueue.utils.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ViewToCustomerStatusPageFactory {
    private static final Logger log = LoggerHelper.getLogger(AddToPageFactory.class);

    public static IViewToCustomerStatusPage getPage(WebDriver driver, String platForm) {
        log.info("Initializing ViewToCustomerStatus Page object for platform: " + platForm);
        switch (platForm) {
            default:
                return new ViewToCustomerStatusPage(driver);
        }
    }
}
