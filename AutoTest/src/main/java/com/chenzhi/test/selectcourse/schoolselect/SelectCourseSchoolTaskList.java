package com.chenzhi.test.selectcourse.schoolselect;

import com.chenzhi.module.business.HomeFunction;
import com.chenzhi.module.business.LoginFunction;
import com.chenzhi.module.business.SelectSubjectFunction;
import com.chenzhi.module.domain.LoginPageElement;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SelectCourseSchoolTaskList {

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
        HomeFunction.enterSchoolSelectCourseTaskList(methods);
    }


    @AfterMethod
    public void afterTest() throws Exception{
         chromeDriver.close();
    }

    /**
     * 创建校内选科任务
     * @throws Exception
     */
    @Test
    public void addSelectCourseTaskTest() throws Exception{
        methods.waitElementShowTime();
        List<String> list = new ArrayList<String>();
        list.add("语文");
        list.add("语文");
        list.add("语文阅读理解");
        list.add("语文1");
        SelectSubjectFunction.addSelectCourseTaskTest(methods, RandomString.getRandomString(4),"高一",
                "",df.format(new Date().getTime()+3000000),
                1,list,30);
    }

    /**
     * 删除选科任务
     * @throws Exception
     */
    @Test
    public void deleteSchoolTask() throws Exception{
        String result = SelectSubjectFunction.deleteSelectCourseTaskTest(methods);
        Assert.assertEquals(result,"SUCCESS","Not equals: ");
    }
    /**
     * 修改校内选科任务的名称
     * @throws Exception
     */
    @Test
    public void updateSchoolTaskName() throws Exception{
        String result = SelectSubjectFunction.updateSchoolSelectCourseData(methods,"XIAOXIAO");
        Assert.assertEquals(result,"SUCCESS","Not equals: ");
    }

}
