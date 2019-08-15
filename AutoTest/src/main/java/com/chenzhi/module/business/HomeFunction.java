package com.chenzhi.module.business;


import com.chenzhi.module.domain.HomePageElement;
import com.chenzhi.module.util.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomeFunction {


    /**进入分班任务列表页面*/
    public static void enterDevideClassPage(Methods methods) {

        methods.getWebElement(HomePageElement.DEVIDED_CLASS_TITLE_LINK.getKey(),HomePageElement.DEVIDED_CLASS_TITLE_LINK.getPath()).click();
        System.out.println("===========分班链接点了==============");
    }


    /**进入高考选科任务列表页面*/
    public static void enterSelectCourseFirstPage(Methods methods) {

       // methods.getWebElement(HomePageElement.DEVIDED_CLASS_TITLE_LINK.getKey(),HomePageElement.DEVIDED_CLASS_TITLE_LINK.getPath()).click();

    }

    /**进入校内选课任务列表页面*/
    public static void enterSelectCourseSecondPage(Methods methods) {

        // methods.getWebElement(HomePageElement.DEVIDED_CLASS_TITLE_LINK.getKey(),HomePageElement.DEVIDED_CLASS_TITLE_LINK.getPath()).click();

    }
    /**进入基础信息_学生管理页面*/
    public static void enterStudentManagerPage(Methods methods) throws Exception{

        touchElement(methods);

        methods.getWebElement(HomePageElement.BASE_INFORMATION_STUDENT_XPATH.getKey(),HomePageElement.BASE_INFORMATION_STUDENT_XPATH.getPath()).click();

        Thread.sleep(30000);

    }

    private static void touchElement(Methods methods) throws InterruptedException {
        Thread.sleep(30000);

        Actions actions = new Actions(methods.getDriver());

        WebElement nav = methods.getWebElement(HomePageElement.BASE_INFORMATION_XPATH.getKey(),HomePageElement.BASE_INFORMATION_XPATH.getPath());

        actions.moveToElement(nav).build().perform();
    }
}
