package com.chenzhi.test.base.course_manager;

import com.chenzhi.module.business.LoginFunction;
import com.chenzhi.module.domain.LoginPageElement;
import com.chenzhi.module.util.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CourseManager {

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

        chromeDriver.close();
    }


}