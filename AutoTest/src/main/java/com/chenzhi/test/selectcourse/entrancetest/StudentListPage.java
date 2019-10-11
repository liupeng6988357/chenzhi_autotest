package com.chenzhi.test.selectcourse.entrancetest;

import com.chenzhi.module.business.HomeFunction;
import com.chenzhi.module.business.LoginFunction;
import com.chenzhi.module.business.SelectSubjectFunction;
import com.chenzhi.module.domain.LoginPageElement;
import com.chenzhi.module.domain.SelectSubjectElement;
import com.chenzhi.module.util.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.List;

public class StudentListPage {

    private String url = LoginPageElement.TEST_WEB_PATH.getPath();

    private WebDriver chromeDriver;

    private Methods methods;

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");


    @BeforeMethod
    public void beforeTest() throws Exception{

        chromeDriver = new ChromeDriver();

        chromeDriver.get(url);

        methods = new Methods(chromeDriver);

        LoginFunction.teacherLoginTest(methods,"13772940987","111111");

        HomeFunction.enterSelectCourseTaskListPage(methods);

        Thread.sleep(5000);

        methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr/td[7]/a[1]").click();

    }


    @AfterMethod
    public void afterTest() throws Exception{

        Thread.sleep(5000);

        // chromeDriver.close();
    }


    /**
     * 修改学生选课功能测试
     * @throws Exception
     */
    @Test
    public void createTask() throws Exception{

        Select select = methods.getWebSelect(SelectSubjectElement.STUDENT_SELECT_PATH.getKey(),SelectSubjectElement.STUDENT_SELECT_PATH.getPath());

        Thread.sleep(3000);

        String[] options = {"0","1","2"};

        select.selectByValue(options[2]);

        for (int i = 0; i <100 ; i++) {

            Thread.sleep(3000);

            methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(),SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath()+"/tr[1]/td[6]/a").click();

            Thread.sleep(3000);

            List<WebElement> elementList = methods.getWebElementList(SelectSubjectElement.COURSE_LABLE_PATH.getKey(),SelectSubjectElement.COURSE_LABLE_PATH.getPath());

            elementList.get(10).click();

            methods.getWebElement(SelectSubjectElement.UPDATE_COURSE_OK_BUTTON.getKey(),SelectSubjectElement.UPDATE_COURSE_OK_BUTTON.getPath()).click();

        }

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
