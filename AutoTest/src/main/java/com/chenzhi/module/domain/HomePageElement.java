package com.chenzhi.module.domain;

public enum HomePageElement {


    /**老师账户信息*/
    TEACHER_ACCOUNTNAME_ICO_XPATH("teacher_accountname_xpath","/html/body/div[1]/div/div[2]/div[2]/ul/li[7]/a/i[2]"),
    /**学生账户信息*/
    STUDENT_ACCOUNTNAME_ICO_XPATH("student_accountName_xpath","html/body/div[1]/div/div[2]/div[2]/ul/li[1]/a/i[2]"),
    /**分班链接元素*/
    DEVIDED_CLASS_TITLE_LINK("devided_class_title_Link","分班"),
    /**基础信息设置*/
    BASE_INFORMATION_XPATH("base_information_xpath","/html/body/div[1]/div/div[2]/div[2]/ul/li[5]/a[3]"),
    /**基础信息_学生管理*/
    BASE_INFORMATION_STUDENT_XPATH("student_information_xpath","/html/body/div[1]/div/div[2]/div[2]/ul/li[5]/ul/li[4]/a");

    private final String key;
    private final String path;

    HomePageElement(String key, String path){
        this.key = key;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getKey(){
        return key;
    }
}
