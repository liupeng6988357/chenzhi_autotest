package com.chenzhi.test.pagetest;

import com.chenzhi.module.business.LoginFunction;
import com.chenzhi.module.business.PageTestFunction;
import com.chenzhi.module.domain.LoginPageElement;
import com.chenzhi.module.domain.PageFilePath;
import com.chenzhi.module.util.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePage {

    private String url = LoginPageElement.TEST_WEB_PATH.getPath();

    private WebDriver chromeDriver;

    private Methods methods;


    @BeforeMethod
    public void beforeTest(){

        chromeDriver = new ChromeDriver();

        chromeDriver.get(url);

        methods = new Methods(chromeDriver);

        LoginFunction.teacherLoginTest(methods,"13022862328","111111");

    }


    @AfterMethod
    public void afterTest() throws Exception{

        Thread.sleep(5000);

        chromeDriver.close();
    }

    /**
     * home页进行对比
     * @throws Exception
     */
    @Test
    public void testImageComparison() throws Exception{
        PageTestFunction.homePageCompare(methods, PageFilePath.HOME_PAGE_EXPECT_PATH.getPath(),PageFilePath.HOME_PAGE_ACTUAL_PATH.getPath());
    }


}
