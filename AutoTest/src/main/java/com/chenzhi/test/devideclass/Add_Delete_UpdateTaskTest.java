package com.chenzhi.test.devideclass;


import com.chenzhi.module.util.PropertyValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class Add_Delete_UpdateTaskTest {

//
//    private String url = PropertyValue.getValue("chenzhi_link");
//
//    private WebDriver chromeDriver;
//
//
//    @BeforeMethod
//    public void beforeTest(){
//
//        init("","");
//
//    }
//
//    private void init(String userName,String password) {
//
//        chromeDriver = new ChromeDriver();
//
//        chromeDriver.get(url);
//
//        SystemLoginPage systemLoginPage = new SystemLoginPage(chromeDriver);
//
//        systemLoginPage.teacherLoginLinkBtn().click();
//
//        systemLoginPage.userNameInput().sendKeys(userName);
//
//        systemLoginPage.passwordInput().sendKeys(password);
//
//        systemLoginPage.loginBtn().click();
//
//        SystemHomePage systemHomePage = new SystemHomePage(chromeDriver);
//
//        systemHomePage.devideClassLink().click();
//    }
//
//
//    @AfterMethod
//    public void afterTest() throws Exception{
//
//        Thread.sleep(5000);
//
//        chromeDriver.close();
//    }
//
//
//    /**
//     * 创建分班任务正常功能测试
//     * @throws Exception
//     * */
//    @Test
//    public void createTask() throws Exception{
//
////
////        Thread.sleep(10000);
////
////        DevideClassTaskListpage devideClassTaskListpage = new DevideClassTaskListpage(chromeDriver);
////
////        chromeDriver.switchTo().frame("iframe");
////
////        devideClassTaskListpage.addDevideClassTaskBtn().click();
////
////        devideClassTaskListpage.DevideClassTaskNameInput().sendKeys("高一年级分行政班");
////
////        Thread.sleep(5000);
////
////        chromeDriver.findElement(By.id("select1")).click();
////
////        chromeDriver.findElements(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li")).get(0).click();
////
////        Thread.sleep(5000);
////
////        chromeDriver.findElement(By.xpath("//*[@id=\"taskList\"]/div[2]/div/div[2]/div/div/div[3]/div/div/div/input")).click();
////
////        chromeDriver.findElements(By.xpath("/html/body/div[4]/div[1]/div[1]/ul/li")).get(0).click();
////
////        Thread.sleep(10000);
////
////        chromeDriver.findElement(By.xpath("//*[@id=\"taskList\"]/div[2]/div/div[2]/div/div/div[4]/div/div/div[1]/input")).click();
////
////        chromeDriver.findElements(By.xpath("/html/body/div[5]/div[1]/div[1]/ul/li")).get(0).click();
////
////        Thread.sleep(5000);
////
////        chromeDriver.findElement(By.xpath("//*[@id=\"taskList\"]/div[2]/div/div[2]/div/button")).click();
////
////        Assert.assertEquals(chromeDriver.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div[1]/p[3]")).getText(),"确认学生数据","Not equals:");
////
////        Thread.sleep(5000);
//
//    }
//
//
//
//    /**创建分班任务页面输入框校验测试*/
//    @Test
//    public void checkRule() throws Exception{
//
//        Thread.sleep(5000);
//
//        chromeDriver.findElement(By.linkText("分班")).click();
//
//        Thread.sleep(10000);
//
//        chromeDriver.switchTo().frame("iframe");
//
//        List<WebElement> list = chromeDriver.findElements(By.className("mainBtn"));
//
//        list.get(0).click();
//
//        chromeDriver.findElement(By.xpath(PropertyValue.getValue("task_name_input"))).sendKeys("com/chenzhi/test");
//
//        Thread.sleep(5000);
//
//        chromeDriver.findElement(By.id("select1")).click();
//
//        chromeDriver.findElements(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li")).get(0).click();
//
//        Thread.sleep(5000);
//
//        chromeDriver.findElement(By.xpath("//*[@id=\"taskList\"]/div[2]/div/div[2]/div/div/div[3]/div/div/div/input")).click();
//
//        chromeDriver.findElements(By.xpath("/html/body/div[4]/div[1]/div[1]/ul/li")).get(0).click();
//
//        Thread.sleep(10000);
//
//        chromeDriver.findElement(By.xpath("//*[@id=\"taskList\"]/div[2]/div/div[2]/div/div/div[4]/div/div/div[1]/input")).click();
//
//        chromeDriver.findElements(By.xpath("/html/body/div[5]/div[1]/div[1]/ul/li")).get(0).click();
//
//        Thread.sleep(5000);
//
//        chromeDriver.findElement(By.xpath("//*[@id=\"taskList\"]/div[2]/div/div[2]/div/button")).click();
//
//        Assert.assertEquals(chromeDriver.findElement(By.xpath("//*[@id=\"main-container\"]/div[1]/div/div[1]/p[3]")).getText(),"确认学生数据","Not equals:");
//
//        Thread.sleep(5000);
//
//    }

}
