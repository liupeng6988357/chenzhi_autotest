package com.chenzhi.module.util;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TakeScreenshotListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        // TODO Auto-generated method stub
        super.onTestFailure(tr);
        // 类名为全类名，包含包名：com.testcases.LoginTest
        String classname = tr.getTestClass().getName();
        // 方法名为执行的方法：testWrongPasswordLogin
        String methodname = tr.getMethod().getMethodName();
        // 此处为获取当前的driver，可以写一个静态方法来获取当前driver，然后来调用
        WebDriver driver = BrowserEmulator.getWebDriver();
        TakeScreenshot shot = new TakeScreenshot(driver);
        shot.takeScreenShot(classname, methodname);
    }

}
