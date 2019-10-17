package com.chenzhi.module.util;

import com.chenzhi.module.domain.Locator;
import org.openqa.selenium.WebDriver;


public class BrowserEmulator {

    public static WebDriver getWebDriver(){

        return Locator.getDriver();
    }
}

