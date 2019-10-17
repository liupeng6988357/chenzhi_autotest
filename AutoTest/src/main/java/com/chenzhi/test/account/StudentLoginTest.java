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

import java.util.List;
import java.util.Map;

public class StudentLoginTest {
    private String url = LoginPageElement.TEST_WEB_PATH.getPath();
    private WebDriver chromeDriver;
    private Methods methods;

    @BeforeMethod
    public void beforeTest() {
        chromeDriver = new ChromeDriver();
        chromeDriver.get(url);
        methods = new Methods(chromeDriver);
    }
    @AfterMethod
    public void afterTest() throws Exception {
        chromeDriver.close();
    }

    /**
     * 学生pc端手机号登录正常功能测试
     *
     * @throws Exception
     */
    @Test(description = "学生登录功能测试")
    public void student_LoginPhoneTest() throws Exception {
        LoginFunction.studentLoginTest(methods, "13022862396", "111111");
        methods.waitPageDataLoad();
        String icoText = methods.getWebElement(HomePageElement.STUDENT_ACCOUNTNAME_ICO_XPATH.getKey(),
                HomePageElement.STUDENT_ACCOUNTNAME_ICO_XPATH.getPath()).getText();
        Assert.assertEquals(icoText, "刘邦纳", "Not equals: ");
    }
    /**
     * 学生pc端手机号登录功能异常测试
     * @throws Exception
     */
    @Test(description = "学生登录功能异常测试")
    public void student_LoginPhoneExceptionTest() throws Exception {
        LoginFunction.studentLoginTest(methods, "", "");
        methods.waitPageDataLoad();
        String errorMessage = methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),
                LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).getText();
        Assert.assertEquals(errorMessage, "登录", "Not equals: ");
    }
    /**
     * 学生PC端学号登录正常功能测试
     *
     * @throws Exception
     */
    @Test(description = "学生登录功能测试")
    public void student_LoginWorkIDTest() throws Exception {
        String[] params = new String[]{"浙江省", "杭州市", "富阳市", "浙江测试学校", "201704", "lp6988357"};
        LoginFunction.studentIDLoginExcute(methods, params);
        methods.waitPageDataLoad();
        String errorMessage = methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),
                LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).getText();
        Assert.assertEquals(errorMessage, "登录", "Not equals: ");
    }
    /**
     * 测试省份下拉框值集
     *
     * @throws Exception
     */
    @Test
    public void provinceValuesTest() throws Exception {
        List<String> selectValuesList = LoginFunction.getProvinceValues(methods);
        for (int i = 0; i < selectValuesList.size(); i++) {
            System.out.println(selectValuesList.get(i));
        }
    }
    /**
     * 测试城市下拉框值集
     * @throws Exception
     */
    @Test
    public void cityValuesTest() throws Exception {
        Map<String, List<String>> cityValuesMap = LoginFunction.getCityValues(methods);
        for (Map.Entry<String, List<String>> entry : cityValuesMap.entrySet()) {
            System.out.println("===========key = " + entry.getKey() + "===============");
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print(entry.getValue().get(i));
            }
            System.out.println("");
        }
    }

    /**
     * 测试县区下拉框值集
     * @throws Exception

     @Test public void countyValuesTest() throws Exception{

     Map<String,Map<String,List<String>>> countyValuesMap = LoginFunction.getCountyValues(methods);

     for (Map.Entry<String,Map<String,List<String>>> entry : countyValuesMap.entrySet()) {
     System.out.println("===========province = " + entry.getKey()+"===============");
     for (Map.Entry<String,List<String>> entrys : entry.getValue().entrySet()) {
     System.out.println("*****city = "+ entrys.getKey()+"*****");
     for (int i = 0; i < entrys.getValue().size(); i++) {
     System.out.println(entrys.getValue().get(i));
     }
     }
     System.out.println("");
     }
     }
     */

    /**
     * 测试学校下拉框值集
     * @throws Exception

     @Test public void schoolValuesTest() throws Exception{

     LoginFunction.getSchoolValues(methods);

     }
     */
}
