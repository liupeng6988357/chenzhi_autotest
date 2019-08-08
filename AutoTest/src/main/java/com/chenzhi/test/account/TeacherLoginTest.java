package com.chenzhi.test.account;

import com.chenzhi.module.domain.HomePageElement;
import com.chenzhi.module.domain.LoginPageElement;
import com.chenzhi.module.util.Methods;
import com.chenzhi.module.util.PropertyValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TeacherLoginTest {


        private String url = LoginPageElement.TEST_WEB_PATH.getPath();

        private WebDriver chromeDriver;

        private  Methods methods;


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
         * 登录正常功能测试【判断是否登录成功，检查账户信息是否与期望一致】
         * @throws Exception
         */
        @Test
        public void tea_LoginTest() throws Exception{

            loginTest("13022862399","111111");

            Thread.sleep(5000);

            String icoText = methods.getWebElement(HomePageElement.TEACHER_ACCOUNTNAME_ICO_XPATH.getKey(),HomePageElement.TEACHER_ACCOUNTNAME_ICO_XPATH.getPath()).getText();

            Assert.assertEquals(icoText,"高新一中 赵四","Not equals: ");

        }


        /**
         * 登录异常功能测试【密码错误】【判断是否登录成功，检查提示信息是否与期望一致】
         * @throws Exception
         */
        @Test(description = "密码错误登录功能测试")
        public void tea_LoginAccountTest() throws Exception{

            loginTest("111","120");

            Thread.sleep(1000);

            Assert.assertEquals(methods.getWebElement(LoginPageElement.EXCEPTIONG_MESSAGE_XPATH.getKey(),LoginPageElement.EXCEPTIONG_MESSAGE_XPATH.getPath()).getText(),"账号信息有误","Not equals: ");

        }


        /**
         * 登录异常功能测试【账号错误】【判断是否登录成功，检查提示信息是否与期望一致】
         * @throws Exception
         */
        @Test(description = "密码错误登录功能测试")
        public void tea_LoginPasswordTest() throws Exception{

            loginTest("111","120");

            Thread.sleep(1000);

            Assert.assertEquals(methods.getWebElement(LoginPageElement.EXCEPTIONG_MESSAGE_XPATH.getKey(),LoginPageElement.EXCEPTIONG_MESSAGE_XPATH.getPath()).getText(),"账号信息有误","Not equals: ");

        }

        /**登录操作执行*/
        private void loginTest(String userName, String password) {

            methods.getWebElement(LoginPageElement.TEACHER_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.TEACHER_BTN_LOGIN_LINK_XPATH.getPath()).click();

            methods.getWebElement(LoginPageElement.USERNAME_INPUT_XPATH.getKey(),LoginPageElement.USERNAME_INPUT_XPATH.getPath()).sendKeys(userName);

            methods.getWebElement(LoginPageElement.PASSWORD_INPUT_XPATH.getKey(),LoginPageElement.PASSWORD_INPUT_XPATH.getPath()).sendKeys(password);

            methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).click();

        }


}

