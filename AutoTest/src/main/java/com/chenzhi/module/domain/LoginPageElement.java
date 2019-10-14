package com.chenzhi.module.domain;


public enum LoginPageElement {

    /**测试网址*/
    TEST_WEB_PATH("testpath","http://test.91chenzhi.cn"),

    /**学生登录页面元素路径*/
    STUDENT_BTN_LOGIN_LINK_XPATH("xpath","/html/body/div[4]/div[2]/a[2]"),
    /**老师登录页面元素路径*/
    TEACHER_BTN_LOGIN_LINK_XPATH("xpath","/html/body/div[4]/div[2]/a[1]"),
    /**账户输入框元素路径*/
    USERNAME_INPUT_XPATH("xpath","//input[@placeholder='手机号']"),
    /**密码输入框元素路径*/
    PASSWORD_INPUT_XPATH("xpath","//input[@placeholder='密码']"),
    /**登录按钮*/
    LOGIN_BTN_CLASSNAME("ClassName","t_btn"),
    /**学生学号登录链接页签*/
    STUDENT_IDLOGIN_LINK_XPATH("xpath","/html/body/div[1]/div/div[1]/div/div/div[2]"),
    /**省会下拉框元素路径*/
    PROVINCE_SELECT_XPATH("xpath",".//*[@id='loginFather']/div[1]/div[1]/select"),
    /**市级下拉框元素路径*/
    CITY_SELECT_XPATH("xpath",".//*[@id=\"loginFather\"]/div[1]/div[2]/select"),
    /**县区下拉框元素路径*/
    COUNTY_SELECT_XPATH("xpath",".//*[@id=\"loginFather\"]/div[1]/div[3]/select"),
    /**学校下拉框元素路径*/
    SCHOOL_SELECT_XPATH("xpath",".//*[@id=\"loginFather\"]/div[2]/select"),
    /**学生学号输入框*/
    STUDENT_ID_INPUT_XPATH("xpath",".//*[@id=\"loginFather\"]/div[3]/input"),
    /**学生密码输入框*/
    STUDENT_PASSWORD_INPUT_XPATH("xpath",".//*[@id=\"loginFather\"]/div[4]/input");

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
