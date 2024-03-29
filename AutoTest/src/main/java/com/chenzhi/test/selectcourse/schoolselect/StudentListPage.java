package com.chenzhi.test.selectcourse.schoolselect;

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
        methods.getWebElement(LoginPageElement.TEACHER_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.TEACHER_BTN_LOGIN_LINK_XPATH.getPath()).click();
        LoginFunction.teacherLoginTest(methods,"13772940987","111111");
        HomeFunction.enterSchoolSelectCourseTaskList(methods);
        methods.waitElementShowTime();
        methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr/td[7]/a[1]").click();
    }

    @AfterMethod
    public void afterTest() throws Exception{
        chromeDriver.close();
    }

    /**
     * 学生列表检索测试
     * @throws Exception
     */
    @Test
    public void checkStudentListTest() throws Exception{
        SelectSubjectFunction.searchStudentsTest(methods,"张",0,"全部班级");
    }

    /**
     * 下载学生功能测试
     * @throws Exception
     */
    @Test
    public void uploadStudents() throws Exception{
        String result = SelectSubjectFunction.uploadsStudentsList(methods);
        System.out.println(result);
        Assert.assertEquals(result,"SUCCESS","Not equals: ");
    }

    /**
     * 修改学生选科信息功能测试
     * @throws Exception
     */
    @Test
    public void updateStudentCourse() throws Exception{
        SelectSubjectFunction.updateStudentCourseData(methods);
    }

    /**课程列表显示测试*/

}
