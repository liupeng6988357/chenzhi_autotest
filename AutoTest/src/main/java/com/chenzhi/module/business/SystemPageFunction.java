package com.chenzhi.module.business;

import com.chenzhi.module.util.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SystemPageFunction {


    /**鼠标悬浮显示*/
    public static void touchElement(Methods methods, String key, String path) throws InterruptedException {
        Thread.sleep(30000);

        Actions actions = new Actions(methods.getDriver());

        WebElement nav = methods.getWebElement(key,path);

        actions.moveToElement(nav).build().perform();
    }
}
