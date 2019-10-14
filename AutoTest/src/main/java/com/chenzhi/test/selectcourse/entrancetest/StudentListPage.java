package com.chenzhi.test.selectcourse.entrancetest;

import com.chenzhi.module.business.HomeFunction;
import com.chenzhi.module.business.LoginFunction;
import com.chenzhi.module.business.SelectSubjectFunction;
import com.chenzhi.module.domain.LoginPageElement;
import com.chenzhi.module.domain.SelectSubjectElement;
import com.chenzhi.module.util.Methods;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;


public class StudentListPage {

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

        LoginFunction.teacherLoginTest(methods,"13772940987","111111");

        HomeFunction.enterSelectCourseTaskListPage(methods);

        Thread.sleep(5000);

        methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr/td[7]/a[1]").click();

    }


    @AfterMethod
    public void afterTest() throws Exception{

        Thread.sleep(5000);

         chromeDriver.close();
    }


    /**
     * 修改学生选课功能测试
     * @throws Exception
     */
    @Test
    public void updateSelectCourseData() throws Exception{

        SelectSubjectFunction.updateSelectCourseData(methods,0,9);

    }


    /**学生列表检索功能测试*/
    @Test
    public void checkStudentList() throws Exception{

        String result = SelectSubjectFunction.searchStudentsTest(methods,"李",1,"全部班级");

        Assert.assertEquals(result,"SUCCESS","Not equals: ");

    }

    /**学生列表导出功能测试*/
    @Test
    public void uploadStudentsList() throws Exception {

        SelectSubjectFunction.uploadStudentsList(methods);
    }

    /**学生列表：下载班主任模板测试*/
    @Test
    public void uploadClassTeacher() throws Exception {

        SelectSubjectFunction.uploadClassTeacher(methods);
    }


    /**应用数据功能测试,需要和基础信息进行对比*/
    @Test
    public void useDataTest() throws Exception{

        String result  = SelectSubjectFunction.useDataTest(methods);

        Assert.assertEquals(result,"成功应用本次选课","Not equals: ");
    }



}
