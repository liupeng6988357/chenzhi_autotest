package com.chenzhi.test.courseschedul;

import com.chenzhi.module.util.PropertyValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateTask {

    private String url = PropertyValue.getValue("chenzhi_link");

    private WebDriver chromeDriver;


    @BeforeMethod
    public void beforeTest(){

        chromeDriver = new ChromeDriver();

        chromeDriver.get(url);

    }


    @AfterMethod
    public void afterTest() throws Exception{

        Thread.sleep(5000);

        chromeDriver.close();
    }


    /**
     * 登录正常功能测试【判断是否登录成功，检查账户信息是否与期望一致】
     * @throws Exception
     */
    @Test
    public void tea_LoginTest() throws Exception{


        chromeDriver.findElement(By.xpath(PropertyValue.getValue("teacherlogin_xpath"))).click();

        chromeDriver.findElement(By.xpath(PropertyValue.getValue("username_xpath"))).sendKeys("13022862399");

        chromeDriver.findElement(By.xpath(PropertyValue.getValue("password_xpath"))).sendKeys("111111");

        chromeDriver.findElement(By.className(PropertyValue.getValue("submit_className"))).click();

        Thread.sleep(5000);

        Assert.assertEquals(chromeDriver.findElement(By.xpath(PropertyValue.getValue("accountname_xpath"))).getText(),"高新一中 赵四","Not equals: ");

    }


    /**
     * 登录异常功能测试【密码错误】【判断是否登录成功，检查提示信息是否与期望一致】
     * @throws Exception
     */
    @Test(description = "密码错误登录功能测试")
    public void tea_LoginAccountTest() throws Exception{

        chromeDriver.findElement(By.xpath(PropertyValue.getValue("teacherlogin_xpath"))).click();

        chromeDriver.findElement(By.xpath(PropertyValue.getValue("username_xpath"))).sendKeys("13022862221");

        chromeDriver.findElement(By.xpath(PropertyValue.getValue("password_xpath"))).sendKeys("111111");

        chromeDriver.findElement(By.className(PropertyValue.getValue("submit_className"))).click();

        Thread.sleep(1000);

        Assert.assertEquals(chromeDriver.findElement(By.xpath(PropertyValue.getValue("exceptionmassage_xpath"))).getText(),"账号或密码错误","Not equals: ");

    }


    /**
     * 登录异常功能测试【账号错误】【判断是否登录成功，检查提示信息是否与期望一致】
     * @throws Exception
     */
    @Test(description = "密码错误登录功能测试")
    public void tea_LoginPasswordTest() throws Exception{

        chromeDriver.findElement(By.xpath(PropertyValue.getValue("teacherlogin_xpath"))).click();

        chromeDriver.findElement(By.xpath(PropertyValue.getValue("username_xpath"))).sendKeys("13022862000");

        chromeDriver.findElement(By.xpath(PropertyValue.getValue("password_xpath"))).sendKeys("111111");

        chromeDriver.findElement(By.className(PropertyValue.getValue("submit_className"))).click();

        Thread.sleep(1000);

        Assert.assertEquals(chromeDriver.findElement(By.xpath(PropertyValue.getValue("exceptionmassage_xpath"))).getText(),"账号或密码错误","Not equals: ");

    }


}

