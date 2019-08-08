package com.chenzhi.module.domain;


public enum LoginPageElement {

    /**测试网址*/
    TEST_WEB_PATH("chenzhi_link","http://test.91chenzhi.cn"),

    /**学生登录页面元素路径*/
    STUDENT_BTN_LOGIN_LINK_XPATH("studentlogin_xpath","/html/body/div[4]/div[2]/a[2]"),
    /**老师登录页面元素路径*/
    TEACHER_BTN_LOGIN_LINK_XPATH("teacherlogin_xpath","/html/body/div[4]/div[2]/a[1]"),
    /**账户输入框元素路径*/
    USERNAME_INPUT_XPATH("username_xpath","//input[@placeholder='手机号']"),
    /**密码输入框元素路径*/
    PASSWORD_INPUT_XPATH("password_xpath","//input[@placeholder='密码']"),
    /**登录按钮*/
    LOGIN_BTN_CLASSNAME("submit_ClassName","t_btn"),
    /**异常信息弹框*/
    EXCEPTIONG_MESSAGE_XPATH("exceptionmassage_xpath","/html/body/div[1]/ng-tip/div/span"),
    /**学生学号登录链接页签*/
    STUDENT_IDLOGIN_LINK_XPATH("student_id_login_xpath","/html/body/div[1]/div/div[1]/div/div/div[2]"),
    /**省会下拉框元素路径*/
    PROVINCE_SELECT_XPATH("province_select_xpath",".//*[@id='loginFather']/div[1]/div[1]/select"),
    /**市级下拉框元素路径*/
    CITY_SELECT_XPATH("city_select_xpath",".//*[@id=\"loginFather\"]/div[1]/div[2]/select"),
    /**县区下拉框元素路径*/
    COUNTY_SELECT_XPATH("county_select_xpath",".//*[@id=\"loginFather\"]/div[1]/div[3]/select"),
    /**学校下拉框元素路径*/
    SCHOOL_SELECT_XPATH("school_select_xpath",".//*[@id=\"loginFather\"]/div[2]/select"),
    /**学生学号输入框*/
    STUDENT_ID_INPUT_XPATH("student_id_input_xpath",".//*[@id=\"loginFather\"]/div[3]/input"),
    /**学生密码输入框*/
    STUDENT_PASSWORD_INPUT_XPATH("student_password_input_xpath",".//*[@id=\"loginFather\"]/div[4]/input");

    private final String key;
    private final String path;

    LoginPageElement(String key, String path){
        this.key = key;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public  String getKey(){
        return key;
    }

}
