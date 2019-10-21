package com.chenzhi.module.util;

import com.chenzhi.module.domain.Locator;
import org.openqa.selenium.WebDriver;


public class BrowserEmulator{

    /**获取当前driver*/
    public static WebDriver getWebDriver(){
        return Locator.getDriver();
    }
}

