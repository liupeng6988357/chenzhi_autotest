package com.chenzhi.test.selectcourse.entrancetest;

import com.chenzhi.module.business.HomeFunction;
import com.chenzhi.module.business.LoginFunction;
import com.chenzhi.module.domain.LoginPageElement;
import com.chenzhi.module.util.Methods;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;

public class StatisticalChartPage {

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

        /**进入选科统计图页面*/

    }


    @AfterMethod
    public void afterTest() throws Exception{

        Thread.sleep(5000);

        chromeDriver.close();
    }




}
