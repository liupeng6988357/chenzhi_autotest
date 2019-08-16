package com.chenzhi.test.base.teacher_manager;

import com.chenzhi.module.business.Base_StudentManagerFunction;
import com.chenzhi.module.business.Base_TeacherManagerFunction;
import com.chenzhi.module.business.HomeFunction;
import com.chenzhi.module.business.LoginFunction;
import com.chenzhi.module.domain.LoginPageElement;
import com.chenzhi.module.domain.SystemUploadFilePath;
import com.chenzhi.module.util.Methods;
import com.chenzhi.module.util.ReadExcel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeacherManager {

    private String url = LoginPageElement.TEST_WEB_PATH.getPath();

    private WebDriver chromeDriver;

    private Methods methods;


    @BeforeMethod
    public void beforeTest(){

        chromeDriver = new ChromeDriver();

        chromeDriver.get(url);

        methods = new Methods(chromeDriver);

        LoginFunction.teacherLoginTest(methods,"17088263562","111111");

    }


    @AfterMethod
    public void afterTest() throws Exception{

        Thread.sleep(5000);

       // chromeDriver.close();
    }


    /**
     * 上传老师功能测试
     * @throws Exception
     */
    @Test
    public void uploadTeachers() throws Exception{

        String filePath = SystemUploadFilePath.Teacher_FILE_PATH.getPath();

        int excelNumber = ReadExcel.getExcelRows(filePath,"教师详情")-1;

        /**进入教师管理页面*/
        HomeFunction.enterTeacherManagerPage(methods);

        /**上传功能执行*/
        String resultText = Base_TeacherManagerFunction.uploadStudentS(methods);

        /**判断执行是否成功*/
        Assert.assertEquals(resultText,"共 "+ excelNumber +" 条","Not equals: ");
    }
}
