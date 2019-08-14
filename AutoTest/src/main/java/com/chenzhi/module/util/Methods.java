package com.chenzhi.module.util;

import com.chenzhi.module.domain.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class Methods extends Locator {

    public Methods(WebDriver webDriver){
        super(webDriver);
    }


    /**封装获取WebElement对象的方法*/
    public WebElement getWebElement(String key,String path){
        if (key.contains("xpath")){

            return getElementByXpath(path);

        }else if (key.contains("ClassName")){

            return getElementByClassName(path);

        }else if (key.contains("Link")){

            return getElementByLink(path);
        }else if(key.contains("id")){
            return  getElementById(path);
        }else {
            return null;
        }
    }

    /**封装获取Select对象的方法*/
    public Select getWebSelect(String key, String path){
        if (key.contains("xpath")){

            return getSelectByXpath(path);

        }else if (key.contains("ClassName")){

            return getSelectByClassName(path);

        }else if (key.contains("Link")){

            return getSelectByLink(path);
        }else {
            return null;
        }
    }

    /**封装获取WebElement对象的方法*/
    public List<WebElement> getWebElementList(String key, String path){
        if (key.contains("xpath")){

            return getElementsByXpath(path);

        }else if (key.contains("ClassName")){

            return getElementsByClassName(path);

        }else if (key.contains("Link")){

            return getElementsByLink(path);
        }else {
            return null;
        }
    }

    @Override
    public void switchFrame(String IFrame) {
        super.switchFrame(IFrame);
    }
}
