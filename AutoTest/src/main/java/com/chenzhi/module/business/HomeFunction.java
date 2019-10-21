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

        SystemPageFunction.touchElement(methods,HomePageElement.BASE_INFORMATION_LINK.getKey(),HomePageElement.BASE_INFORMATION_LINK.getPath());

        methods.getWebElement(HomePageElement.BASE_INFORMATION_STUDENT_LINK.getKey(),HomePageElement.BASE_INFORMATION_STUDENT_LINK.getPath()).click();

        Thread.sleep(30000);

    }

    /**进入基础信息_教师管理页面*/
    public static void enterTeacherManagerPage(Methods methods) throws Exception{

        SystemPageFunction.touchElement(methods,HomePageElement.BASE_INFORMATION_LINK.getKey(),HomePageElement.BASE_INFORMATION_LINK.getPath());

        methods.getWebElement(HomePageElement.BASE_INFORMATION_TEACHER_LINK.getKey(),HomePageElement.BASE_INFORMATION_TEACHER_LINK.getPath()).click();

        Thread.sleep(30000);
    }

    /**进入基础信息_成绩管理页面*/
    public static void enterGradeManagerPage(Methods methods) throws Exception{

        SystemPageFunction.touchElement(methods,HomePageElement.BASE_INFORMATION_LINK.getKey(),HomePageElement.BASE_INFORMATION_LINK.getPath());

        methods.getWebElement(HomePageElement.BASE_INFORMATION_GRADE_LINK.getKey(),HomePageElement.BASE_INFORMATION_GRADE_LINK.getPath()).click();

        Thread.sleep(30000);
    }

    /**进入基础信息_教室管理页面*/
    public static void enterClassAddressManagerPage(Methods methods) throws Exception{

        SystemPageFunction.touchElement(methods,HomePageElement.BASE_INFORMATION_LINK.getKey(),HomePageElement.BASE_INFORMATION_LINK.getPath());

        methods.getWebElement(HomePageElement.BASE_INFORMATION_CLASSADDRESS_LINK.getKey(),HomePageElement.BASE_INFORMATION_CLASSADDRESS_LINK.getPath()).click();

        Thread.sleep(30000);
    }

    /**进入基础信息_课程管理页面*/
    public static void enterCourseManagerPage(Methods methods) throws Exception{

        SystemPageFunction.touchElement(methods,HomePageElement.BASE_INFORMATION_LINK.getKey(),HomePageElement.BASE_INFORMATION_LINK.getPath());

        methods.getWebElement(HomePageElement.BASE_INFORMATION_COURSE_LINK.getKey(),HomePageElement.BASE_INFORMATION_COURSE_LINK.getPath()).click();

        Thread.sleep(30000);
    }


    /**进入选课任务页面*/
    public static void enterSelectCourseTaskListPage(Methods methods) throws Exception {
        SystemPageFunction.touchElement(methods, HomePageElement.SELECT_COURSE_TITLE_LINK.getKey(),HomePageElement.SELECT_COURSE_TITLE_LINK.getPath());
        methods.waitElementShowTime();
        methods.getWebElement(HomePageElement.TEST_SELECT_COURSE_LINK.getKey(),HomePageElement.TEST_SELECT_COURSE_LINK.getPath()).click();
    }

    /**进入校内选课任务页面*/
    public static void enterSchoolSelectCourseTaskList(Methods methods) throws Exception{
        SystemPageFunction.touchElement(methods, HomePageElement.SELECT_COURSE_TITLE_LINK.getKey(),HomePageElement.SELECT_COURSE_TITLE_LINK.getPath());
        Thread.sleep(2000);
        methods.getWebElement(HomePageElement.IN_SCHOOL_SELECT_COURSE_LINK.getKey(),HomePageElement.IN_SCHOOL_SELECT_COURSE_LINK.getPath()).click();
        Thread.sleep(5000);
    }

}
