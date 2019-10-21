package com.chenzhi.test.selectcourse.entrancetest;


import com.chenzhi.module.business.HomeFunction;
import com.chenzhi.module.business.LoginFunction;
import com.chenzhi.module.business.SelectSubjectFunction;
import com.chenzhi.module.domain.LoginPageElement;
import com.chenzhi.module.domain.SelectSubjectElement;
import com.chenzhi.module.util.Methods;
import com.chenzhi.module.util.RandomString;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SelectCourseTaskList {

    private String url = LoginPageElement.TEST_WEB_PATH.getPath();
    private WebDriver chromeDriver;
    private Methods methods;
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @BeforeMethod
    public void beforeTest() throws Exception{
        chromeDriver = new ChromeDriver();
        chromeDriver.get(url);
        Dimension dimension = new Dimension(1366,768);
        chromeDriver.manage().window().setSize(dimension);
        methods = new Methods(chromeDriver);
        methods.getWebElement(LoginPageElement.TEACHER_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.TEACHER_BTN_LOGIN_LINK_XPATH.getPath()).click();
        LoginFunction.teacherLoginTest(methods,"13772940987","111111");
        HomeFunction.enterSelectCourseTaskListPage(methods);
    }
    @AfterMethod
    public void afterTest() throws Exception{
        //chromeDriver.close();
    }

    /**
     * 创建高考选科功能【自由选课,不分组】测试
     * @throws Exception
     */
    @Test
    public void createTask() throws Exception{
        String result = SelectSubjectFunction.createTask(methods, RandomString.getRandomString(4),"高一",
                "",df.format(new Date().getTime()+3000000),false,false);
        Assert.assertEquals(result,"SUCCESS","Not equals: ");
    }
    /**
     * 更新高考选科任务姓名功能测试
     * @throws Exception
     */
    @Test
    public void updateTask() throws Exception{
        String result = SelectSubjectFunction.updateTask(methods,RandomString.getRandomString(4));
        Assert.assertEquals(result,"SUCCESS","Not equals: ");
    }
    /**
     * 删除高考选考任务功能测试
     * @throws Exception
     */
    @Test
    public void deleteTask() throws Exception{
        Thread.sleep(5000);
        String rel_tr_number = methods.getWebElement(SelectSubjectElement.COMMON_TR_Number_PATH.getKey(),
                SelectSubjectElement.COMMON_TR_Number_PATH.getPath()).getText();
        String[] list = rel_tr_number.split(" ");
        int  number  = Integer.valueOf(list[1]);
        System.out.println(number);
        for (int i = 0; i < number-1; i++) {
            String result = SelectSubjectFunction.deleteTask(methods);
            Assert.assertEquals(result,"SUCCESS","Not equals: ");
        }

    }

}
