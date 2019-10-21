package com.chenzhi.module.domain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Locator{

    private static WebDriver driver;

    public Locator(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    /**通过xpath获取元素*/
    public WebElement getElementByXpath(String xpath){
        waitForLoad(driver,By.xpath(xpath),10,1);
        return driver.findElement(By.xpath(xpath));
    }

    /**通过CLASSNAME获取元素*/
    public WebElement getElementByClassName(String classname){
        waitForLoad(driver,By.className(classname),10,1);
        return driver.findElement(By.className(classname));
    }

    /**通过Link获取元素*/
    public WebElement getElementByLink(String linkPath){
        waitForLoad(driver,By.linkText(linkPath),10,1);
        return driver.findElement(By.linkText(linkPath));
    }

    /**通过id获取元素*/
    public WebElement getElementById(String id){
        waitForLoad(driver,By.id(id),10,1);
        return driver.findElement(By.id(id));
    }

    /**根据标签名获取元素*/
    public WebElement getElementByTagName(String tagname){
        waitForLoad(driver,By.tagName(tagname),10,1);
        return driver.findElement(By.tagName(tagname));
    }

    /**通过css_seclector定位元素*/
    public WebElement getElementByCss_Secltor(String css_selector){
        waitForLoad(driver,By.cssSelector(css_selector),10,1);
        return driver.findElement(By.cssSelector(css_selector));
    }

    /**通过CLASSNAME获取元素列表*/
    public List<WebElement> getElementsByClassName(String classname){
        waitForLoads(driver,By.className(classname),10,1);
        return driver.findElements(By.className(classname));
    }

    /**通过xpath获取Select对象*/
    public Select getSelectByXpath(String xpath){
        waitForLoad(driver,By.xpath(xpath),10,1);
        return new Select(driver.findElement(By.xpath(xpath)));
    }

    /**通过className获取Select对象*/
    public Select getSelectByClassName(String classname){
        waitForLoad(driver,By.className(classname),10,1);
        return new Select(driver.findElement(By.className(classname)));
    }

    /**通过LINK获取Select对象*/
    public Select getSelectByLink(String linkPath){
        waitForLoad(driver,By.linkText(linkPath),10,1);
        return new Select(driver.findElement(By.linkText(linkPath)));
    }

    /**通过id获取Select对象*/
    public Select getSelectById(String id){
        waitForLoad(driver, By.id(id),10,1);
        return new Select(driver.findElement(By.id(id)));
    }

    /**通过xpath获取webelement列表*/
    public List<WebElement> getElementsByXpath(String xpath){
        waitForLoads(driver,By.xpath(xpath),10,1);
        return driver.findElements(By.xpath(xpath));
    }

    /**通过linkText获取webelement列表*/
    public List<WebElement> getElementsByLink(String xpath){
        waitForLoads(driver,By.linkText(xpath),10,1);
        return driver.findElements(By.linkText(xpath));
    }

    /**页面框架切换方法封装【name,id】*/
    public void switchFrame(String path){
        driver.switchTo().frame(path);
    }

    /**页面加载等待时间设置*/
    public static void  waitPageDataLoad(){
        driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
    }

    /**定位元素在规定时间内一直查询*/
    public static void waitElementShowTime(){
        driver.manage().timeouts().implicitlyWait(15000,TimeUnit.SECONDS);
    }

    /**在设置规定的时间内，等待异步脚本的执行结束，而不是里面抛出错误。*/
    public void waitScriptExcuteTime(){
        driver.manage().timeouts().setScriptTimeout(15000,TimeUnit.SECONDS);
    }

    public static void waitForLoad(WebDriver driver, final By locator, long timeOut,long steps) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut,steps);  // timeOut为等待时间，单位秒
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                boolean loadcomplete = d.findElement(locator).isDisplayed();
                return loadcomplete;
            }
        });
    }

    public static void waitForLoads(WebDriver driver, final By locator, long timeOut,long steps) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut,steps);  // timeOut为等待时间，单位秒
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                boolean loadcomplete = !d.findElements(locator).isEmpty();
                return loadcomplete;
            }
        });
    }
}
