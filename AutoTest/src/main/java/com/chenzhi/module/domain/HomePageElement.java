package com.chenzhi.module.domain;

public enum HomePageElement {


    /**老师账户信息*/
    TEACHER_ACCOUNTNAME_ICO_XPATH("xpath","/html/body/div[1]/div/div[2]/div[2]/ul/li[7]/a/i[2]"),
    /**学生账户信息*/
    STUDENT_ACCOUNTNAME_ICO_XPATH("xpath","html/body/div[1]/div/div[2]/div[2]/ul/li[1]/a/i[2]"),

    /**分班链接元素*/
    DEVIDED_CLASS_TITLE_LINK("Link","分班"),
    /**选科分班*/
    SELECT_DEVIDED_CLASS_LINK("Link","选科分班"),
    /**入学分班*/
    GET_IN_SCHOOL_DEVIDED_CLASS_LINK("Link","入学分班"),


    /**选科链接元素*/
    SELECT_COURSE_TITLE_LINK("Link","选课"),
    /**高考选科*/
    TEST_SELECT_COURSE_LINK("Link","高考选科"),
    /**校内选科*/
    IN_SCHOOL_SELECT_COURSE_LINK("Link","校内选课"),



    /**基础信息设置*/
    BASE_INFORMATION_LINK("Link","基础信息设置"),
    /**基础信息_学生管理*/
    BASE_INFORMATION_STUDENT_LINK("Link","学生管理"),
    /**基础信息_教师管理*/
    BASE_INFORMATION_TEACHER_LINK("Link","教师管理"),
    /**基础信息_成绩管理*/
    BASE_INFORMATION_GRADE_LINK("Link","成绩管理"),
    /**基础信息_教室管理*/
    BASE_INFORMATION_CLASSADDRESS_LINK("Link","教室管理"),
    /**基础信息_课程管理*/
    BASE_INFORMATION_COURSE_LINK("Link","课程管理")
    ;

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
