package com.chenzhi.test.account;

import com.chenzhi.module.business.LoginFunction;
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
    private Methods methods;

    @BeforeMethod
    public void beforeMethod() {
        chromeDriver = new ChromeDriver();
        chromeDriver.get(url);
        methods = new Methods(chromeDriver);
        methods.getWebElement(LoginPageElement.TEACHER_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.TEACHER_BTN_LOGIN_LINK_XPATH.getPath()).click();
    }
    @AfterMethod
    public void afterMethod() throws Exception {
        Thread.sleep(5000);
        chromeDriver.close();
    }

    /**
     * 登录正常功能测试【判断是否登录成功，检查账户信息是否与期望一致】
     *
     * @throws Exception
     */
    @Test(description = "登录功能正常测试")
    public void tea_LoginTest() throws Exception {
        LoginFunction.teacherLoginTest(methods, "13022862399", "111111");
        methods.waitElementShowTime();
        String icoText = methods.getWebElement(HomePageElement.TEACHER_ACCOUNTNAME_ICO_XPATH.getKey(),
                HomePageElement.TEACHER_ACCOUNTNAME_ICO_XPATH.getPath()).getText();
        Assert.assertEquals(icoText, "高新一中 赵四", "Not equals: ");
    }
    /**
     * 登录账号和密码为空
     * @throws Exception
     */
    @Test(description = "账号密码均为空登录功能测试")
    public void tea_LoginAccountAndPwdIsNullTest() throws Exception {
        LoginFunction.teacherLoginTest(methods, "", "");
        methods.waitElementShowTime();
        String errorText = methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),
                LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).getText();
        Assert.assertEquals(errorText, "登录", "Not equals: ");
    }
    /**
     * 登录密码为空
     * @throws Exception
     */
    @Test(description = "密码为空登录功能测试")
    public void tea_LoginPwdIsNullTest() throws Exception {
        LoginFunction.teacherLoginTest(methods, "13022862399", "");
        methods.waitElementShowTime();
        String errorText = methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),
                LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).getText();
        Assert.assertEquals(errorText, "登录", "Not equals: ");
    }
    /**
     * 登录账号为空
     * @throws Exception
     */
    @Test(description = "账号为空登录功能测试")
    public void tea_LoginAccountIsNullTest() throws Exception {
        LoginFunction.teacherLoginTest(methods, "", "111111");
        methods.waitElementShowTime();
        String errorText = methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),
                LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).getText();
        Assert.assertEquals(errorText, "登录", "Not equals: ");
    }
    /**
     * 登录异常功能测试【密码错误】【判断是否登录成功，检查提示信息是否与期望一致】
     * @throws Exception
     */
    @Test(description = "账户错误登录功能测试")
    public void tea_LoginAccountErrorTest() throws Exception {
        LoginFunction.teacherLoginTest(methods, "66666", "111111");
        methods.waitElementShowTime();
        String errorText = methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),
                LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).getText();
        Assert.assertEquals(errorText, "登录", "Not equals: ");
    }
    /**
     * 登录异常功能测试【账号错误】【判断是否登录成功，检查提示信息是否与期望一致】
     * @throws Exception
     */
    @Test(description = "密码错误登录功能测试")
    public void tea_LoginPasswordErrorTest() throws Exception {
        LoginFunction.teacherLoginTest(methods, "13022862399", "120");
        methods.waitElementShowTime();
        String errorText = methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),
                LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).getText();
        Assert.assertEquals(errorText, "登录", "Not equals: ");
    }

}

