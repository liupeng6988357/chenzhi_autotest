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

}
