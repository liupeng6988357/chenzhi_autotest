package com.chenzhi.module.business;


import com.chenzhi.module.domain.HomePageElement;
import com.chenzhi.module.util.Methods;

public class HomeFunction {


    /**进入分班任务列表页面*/
    public static void enterDevideClassPage(Methods methods) {

        methods.getWebElement(HomePageElement.DEVIDED_CLASS_TITLE_LINK.getKey(),HomePageElement.DEVIDED_CLASS_TITLE_LINK.getPath()).click();
        System.out.println("===========分班链接点了==============");
    }

    /**进入基础信息_学生管理页面*/
    public static void enterStudentManagerPage(Methods methods) throws Exception{

        SystemPageFunction.touchElement(methods,HomePageElement.BASE_INFORMATION_XPATH.getKey(),HomePageElement.BASE_INFORMATION_XPATH.getPath());

        methods.getWebElement(HomePageElement.BASE_INFORMATION_STUDENT_XPATH.getKey(),HomePageElement.BASE_INFORMATION_STUDENT_XPATH.getPath()).click();

        Thread.sleep(30000);

    }

    /**进入基础信息_教师管理页面*/
    public static void enterTeacherManagerPage(Methods methods) throws Exception{

        SystemPageFunction.touchElement(methods,HomePageElement.BASE_INFORMATION_XPATH.getKey(),HomePageElement.BASE_INFORMATION_XPATH.getPath());

        methods.getWebElement(HomePageElement.BASE_INFORMATION_TEACHER_XPATH.getKey(),HomePageElement.BASE_INFORMATION_TEACHER_XPATH.getPath()).click();

        Thread.sleep(30000);
    }

    /**进入基础信息_成绩管理页面*/
    public static void enterGradeManagerPage(Methods methods) throws Exception{

        SystemPageFunction.touchElement(methods,HomePageElement.BASE_INFORMATION_XPATH.getKey(),HomePageElement.BASE_INFORMATION_XPATH.getPath());

        methods.getWebElement(HomePageElement.BASE_INFORMATION_GRADE_XPATH.getKey(),HomePageElement.BASE_INFORMATION_GRADE_XPATH.getPath()).click();

        Thread.sleep(30000);
    }

    /**进入基础信息_教室管理页面*/
    public static void enterClassAddressManagerPage(Methods methods) throws Exception{

        SystemPageFunction.touchElement(methods,HomePageElement.BASE_INFORMATION_XPATH.getKey(),HomePageElement.BASE_INFORMATION_XPATH.getPath());

        methods.getWebElement(HomePageElement.BASE_INFORMATION_CLASSADDRESS_XPATH.getKey(),HomePageElement.BASE_INFORMATION_CLASSADDRESS_XPATH.getPath()).click();

        Thread.sleep(30000);
    }

    /**进入基础信息_课程管理页面*/
    public static void enterCourseManagerPage(Methods methods) throws Exception{

        SystemPageFunction.touchElement(methods,HomePageElement.BASE_INFORMATION_XPATH.getKey(),HomePageElement.BASE_INFORMATION_XPATH.getPath());

        methods.getWebElement(HomePageElement.BASE_INFORMATION_COURSE_XPATH.getKey(),HomePageElement.BASE_INFORMATION_COURSE_XPATH.getPath()).click();

        Thread.sleep(30000);
    }




}
