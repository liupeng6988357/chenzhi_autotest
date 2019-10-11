package com.chenzhi.module.domain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Locator{

    private WebDriver driver;

    public Locator(WebDriver driver) {
        this.driver = driver;
    }


    public WebDriver getDriver() {
        return driver;
    }

    /**通过xpath获取元素*/
    public WebElement getElementByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }

    /**通过CLASSNAME获取元素*/
    public WebElement getElementByClassName(String classname){
        return driver.findElement(By.className(classname));
    }

    /**通过Link获取元素*/
    public WebElement getElementByLink(String linkPath){
        return driver.findElement(By.linkText(linkPath));
    }

    /**通过id获取元素*/
    public WebElement getElementById(String id){
        return driver.findElement(By.id(id));
    }

    /**根据标签名获取元素*/
    public WebElement getElementByTagName(String tagname){
        return driver.findElement(By.tagName(tagname));
    }

    /**通过css_seclector定位元素*/
    public WebElement getElementByCss_Secltor(String css_selector){
        return driver.findElement(By.cssSelector(css_selector));
    }

    /**通过CLASSNAME获取元素列表*/
    public List<WebElement> getElementsByClassName(String classname){
        return driver.findElements(By.className(classname));
    }

    /**通过xpath获取Select对象*/
    public Select getSelectByXpath(String xpath){
        return new Select(driver.findElement(By.xpath(xpath)));
    }

    /**通过xpath获取Select对象*/
    public Select getSelectByClassName(String classname){
        return new Select(driver.findElement(By.className(classname)));
    }

    /**通过xpath获取Select对象*/
    public Select getSelectByLink(String linkPath){
        return new Select(driver.findElement(By.linkText(linkPath)));
    }


    /**通过xpath获取webelement列表*/
    public List<WebElement> getElementsByXpath(String xpath){
        return driver.findElements(By.xpath(xpath));
    }

    /**通过linkText获取webelement列表*/
    public List<WebElement> getElementsByLink(String xpath){
        return driver.findElements(By.linkText(xpath));
    }

    /**页面框架切换方法封装【name,id】*/
    public  void switchFrame(String path){
        driver.switchTo().frame(path);
    }


}
