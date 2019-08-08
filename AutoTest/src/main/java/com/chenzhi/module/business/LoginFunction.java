package com.chenzhi.module.business;

import com.chenzhi.module.domain.LoginPageElement;
import com.chenzhi.module.util.Methods;

public class LoginFunction {

    /**老师登录操作执行*/
    public static void teacherLoginTest(Methods methods, String userName, String password) {

        methods.getWebElement(LoginPageElement.TEACHER_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.TEACHER_BTN_LOGIN_LINK_XPATH.getPath()).click();

        methods.getWebElement(LoginPageElement.USERNAME_INPUT_XPATH.getKey(),LoginPageElement.USERNAME_INPUT_XPATH.getPath()).sendKeys(userName);

        methods.getWebElement(LoginPageElement.PASSWORD_INPUT_XPATH.getKey(),LoginPageElement.PASSWORD_INPUT_XPATH.getPath()).sendKeys(password);

        methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).click();

    }

    /**学生登录操作执行*/
    public static void studentLoginTest(Methods methods,String username, String password) {

        methods.getWebElement(LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getPath()).click();

        methods.getWebElement(LoginPageElement.USERNAME_INPUT_XPATH.getKey(),LoginPageElement.USERNAME_INPUT_XPATH.getPath()).sendKeys(username);

        methods.getWebElement(LoginPageElement.PASSWORD_INPUT_XPATH.getKey(),LoginPageElement.PASSWORD_INPUT_XPATH.getPath()).sendKeys(password);

        methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).click();
    }

    /**学生id登录操作执行*/
    public static void studentIDLoginExcute(Methods methods,String[] params) throws Exception{
        methods.getWebElement(LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getPath()).click();

        methods.getWebElement(LoginPageElement.STUDENT_IDLOGIN_LINK_XPATH.getKey(),LoginPageElement.STUDENT_IDLOGIN_LINK_XPATH.getPath()).click();

        Thread.sleep(5000);

        methods.getWebSelect(LoginPageElement.PROVINCE_SELECT_XPATH.getKey(),LoginPageElement.PROVINCE_SELECT_XPATH.getPath()).selectByVisibleText(params[0]);

        Thread.sleep(1000);

        methods.getWebSelect(LoginPageElement.CITY_SELECT_XPATH.getKey(),LoginPageElement.CITY_SELECT_XPATH.getPath()).selectByVisibleText(params[1]);

        Thread.sleep(1000);

        methods.getWebSelect(LoginPageElement.COUNTY_SELECT_XPATH.getKey(),LoginPageElement.COUNTY_SELECT_XPATH.getPath()).selectByVisibleText(params[2]);

        Thread.sleep(1000);

        methods.getWebSelect(LoginPageElement.SCHOOL_SELECT_XPATH.getKey(),LoginPageElement.SCHOOL_SELECT_XPATH.getPath()).selectByVisibleText(params[3]);

        methods.getWebElement(LoginPageElement.STUDENT_ID_INPUT_XPATH.getKey(),LoginPageElement.STUDENT_ID_INPUT_XPATH.getPath()).sendKeys(params[4]);

        methods.getWebElement(LoginPageElement.STUDENT_PASSWORD_INPUT_XPATH.getKey(),LoginPageElement.STUDENT_PASSWORD_INPUT_XPATH.getPath()).sendKeys(params[5]);

        methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).click();

    }

}
