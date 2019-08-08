package com.chenzhi.test.account;


import com.chenzhi.module.business.LoginFunction;
import com.chenzhi.module.domain.HomePageElement;
import com.chenzhi.module.domain.LoginPageElement;
import com.chenzhi.module.util.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentLoginTest {

    private String url = LoginPageElement.TEST_WEB_PATH.getPath();

    private WebDriver chromeDriver;

    private Methods methods;


    @BeforeMethod
    public void beforeTest(){

        chromeDriver = new ChromeDriver();

        chromeDriver.get(url);

        methods = new Methods(chromeDriver);

    }


    @AfterMethod
    public void afterTest() throws Exception{

        Thread.sleep(5000);

        chromeDriver.close();
    }

    /**
     * 学生pc端手机号登录正常功能测试
     * @throws Exception
     */
    @Test(description = "学生登录功能测试")
    public void student_LoginPhoneTest() throws Exception {

        LoginFunction.studentLoginTest(methods,"13022862396","111111");

        String icoText = methods.getWebElement(HomePageElement.STUDENT_ACCOUNTNAME_ICO_XPATH.getKey(),
                HomePageElement.STUDENT_ACCOUNTNAME_ICO_XPATH.getPath()).getText();

        Assert.assertEquals(icoText,"高新一中 赵四","Not equals: ");
    }

    /**
     * 学生pc端手机号登录功能异常测试
     * @throws Exception
     */
    @Test(description = "学生登录功能异常测试")
    public void student_LoginPhoneExceptionTest() throws Exception {

        LoginFunction.studentLoginTest(methods,"","");

        Thread.sleep(1000);

        String errorMessage = methods.getWebElement(LoginPageElement.EXCEPTIONG_MESSAGE_XPATH.getKey(),
                LoginPageElement.EXCEPTIONG_MESSAGE_XPATH.getPath()).getText();

        Assert.assertEquals(errorMessage,"请输入手机号","Not equals: ");
    }


    /**
     * 学生PC端学号登录正常功能测试
     * @throws Exception
     */
    @Test(description = "学生登录功能测试")
    public void student_LoginWorkIDTest() throws Exception{

        String[] params = new String[]{"浙江省","杭州市","富阳市","浙江测试学校","201704","lp6988357"};

        LoginFunction.studentIDLoginExcute(methods,params);

        Thread.sleep(1000);

        String errorMessage = methods.getWebElement(LoginPageElement.EXCEPTIONG_MESSAGE_XPATH.getKey(),
                LoginPageElement.EXCEPTIONG_MESSAGE_XPATH.getPath()).getText();

        Assert.assertEquals(errorMessage,"登录信息有误","Not equals: ");
    }


}
