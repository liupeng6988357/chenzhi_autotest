package com.chenzhi.test.account;


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

        studentIDLoginTest("","");

        String icoText = methods.getWebElement(HomePageElement.STUDENT_ACCOUNTNAME_ICO_XPATH.getKey(),HomePageElement.STUDENT_ACCOUNTNAME_ICO_XPATH.getPath()).getText();

        Assert.assertEquals(icoText,"高新一中 赵四","Not equals: ");
    }

    /**
     * 学生pc端手机号登录功能异常测试
     * @throws Exception
     */
    @Test(description = "学生登录功能异常测试")
    public void student_LoginPhoneExceptionTest() throws Exception {

        studentIDLoginTest("","");

        String errorMessage = methods.getWebElement(LoginPageElement.EXCEPTIONG_MESSAGE_XPATH.getKey(),LoginPageElement.EXCEPTIONG_MESSAGE_XPATH.getPath()).getText();

        Assert.assertEquals(errorMessage,"账号信息有误","Not equals: ");
    }


    /**
     * 学生PC端学号登录正常功能测试
     * @throws Exception
     */
    @Test(description = "学生登录功能测试")
    public void student_LoginWorkIDTest() throws Exception{

        methods.getWebElement(LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getPath()).click();

        methods.getWebElement(LoginPageElement.STUDENT_IDLOGIN_LINK_XPATH.getKey(),LoginPageElement.STUDENT_IDLOGIN_LINK_XPATH.getPath()).click();

        Thread.sleep(5000);

        methods.getWebSelect(LoginPageElement.PROVINCE_SELECT_XPATH.getKey(),LoginPageElement.PROVINCE_SELECT_XPATH.getPath()).selectByVisibleText("浙江省");

        Thread.sleep(2000);

        methods.getWebSelect(LoginPageElement.CITY_SELECT_XPATH.getKey(),LoginPageElement.CITY_SELECT_XPATH.getPath()).selectByVisibleText("杭州市");

        Thread.sleep(2000);

        methods.getWebSelect(LoginPageElement.COUNTY_SELECT_XPATH.getKey(),LoginPageElement.COUNTY_SELECT_XPATH.getPath()).selectByVisibleText("富阳市");

        Thread.sleep(2000);

        methods.getWebSelect(LoginPageElement.SCHOOL_SELECT_XPATH.getKey(),LoginPageElement.SCHOOL_SELECT_XPATH.getPath()).selectByVisibleText("浙江测试学校");

        methods.getWebElement(LoginPageElement.STUDENT_ID_INPUT_XPATH.getKey(),LoginPageElement.STUDENT_ID_INPUT_XPATH.getPath()).sendKeys("201704");

        methods.getWebElement(LoginPageElement.STUDENT_PASSWORD_INPUT_XPATH.getKey(),LoginPageElement.STUDENT_PASSWORD_INPUT_XPATH.getPath()).sendKeys("lp6988357");

        methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).click();

        Thread.sleep(5000);

        Assert.assertEquals(methods.getWebElement(HomePageElement.STUDENT_ACCOUNTNAME_ICO_XPATH.getKey(),HomePageElement.STUDENT_ACCOUNTNAME_ICO_XPATH.getPath()).getText()," 学生3 ","Not equals: ");
    }



    private void studentIDLoginTest(String username, String password) {

        methods.getWebElement(LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getPath()).click();

        methods.getWebElement(LoginPageElement.USERNAME_INPUT_XPATH.getKey(),LoginPageElement.USERNAME_INPUT_XPATH.getPath()).sendKeys(username);

        methods.getWebElement(LoginPageElement.PASSWORD_INPUT_XPATH.getKey(),LoginPageElement.PASSWORD_INPUT_XPATH.getPath()).sendKeys(password);

        methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).click();
    }
}
