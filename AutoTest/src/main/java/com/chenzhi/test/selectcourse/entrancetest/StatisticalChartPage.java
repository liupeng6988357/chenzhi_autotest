package com.chenzhi.test.selectcourse.entrancetest;

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
        Thread.sleep(5000);
        methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr/td[7]/a[1]").click();
    }
    @AfterMethod
    public void afterTest() throws Exception{
        Thread.sleep(5000);
        chromeDriver.close();
    }

    /**
     *页面跳转，学科分析-->学生列表
     * @throws Exception
     */
    @Test
    public void testPageChange() throws Exception{
        String result = SelectSubjectFunction.pageChange(methods);
        Assert.assertEquals(result,"应用数据","Not equals:");
    }
    /**
     * 学科分析：单科分析数据正确性验证
     * @throws Exception
     */
    @Test
    public void testChartOne() throws Exception{
        String result = SelectSubjectFunction.checkCourseAnalyze(methods);
        Assert.assertEquals(result,"SUCCESS","Not equals:");
    }
    /**
     * 学科分析：双科分析数据正确性验证
     * @throws Exception
     */
    @Test
    public void testChartTwo() throws  Exception{
        String result = SelectSubjectFunction.checkTwoCourseAnalyze(methods);
        Assert.assertEquals(result,"SUCCESS","Not equals:");
    }
    /**
     * 学科分析：三科组合数据正确性验证
     * @throws Exception
     */
    @Test
    public void testChartThree() throws Exception{
        String result = SelectSubjectFunction.checkThreeCourseAnalyse(methods);
        Assert.assertEquals(result,"SUCCESS","Not equals:");
    }
    /**
     * 学科分析：班级选课数据正确性验证
     * @throws Exception
     */
    @Test
    public void testClassChartData() throws Exception{
        SelectSubjectFunction.checkClassCourseAnalyse(methods);
    }


}
