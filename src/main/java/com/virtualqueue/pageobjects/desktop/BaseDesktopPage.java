package com.virtualqueue.pageobjects.desktop;

import com.virtualqueue.pageobjects.BasePage;
import com.virtualqueue.utils.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class BaseDesktopPage extends BasePage {
    public BaseDesktopPage(WebDriver driver) {
        super(driver);
    }
}
