package com.chenzhi.module.business;


import com.chenzhi.module.domain.HomePageElement;
import com.chenzhi.module.util.Methods;

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
}
