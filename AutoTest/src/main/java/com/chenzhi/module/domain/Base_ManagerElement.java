package com.chenzhi.module.domain;

public enum Base_ManagerElement {


    /**上传文件按钮*/
    UPLOAD_FILE_XPATH("xpath","/html/body/div[1]/div/div/div/div[2]/form/div/div[3]/button"),
    /**弹框关闭按钮*/
    UPLOAD_PAGE_CLOSE_BUTTON_XPATH("xpath","/html/body/div[1]/div/div/div/div[1]/button"),



    /**上传学生详情按钮*/
    UPLOAD_STUDENT_INFORMATION_XPATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[1]/div/button[2]"),
    /**上传结果文案*/
    UPLOAD_RESULT_TEXT_XPATH("xpath","/html/body/div[1]/div/div/div/div[2]/form/span/div/div"),
    /**学生总人数*/
    STUDENT_SUM_NUMBER_XPATH("xpath","//*[@id=\"layui-laypage-2\"]/span[1]"),
    /**上传学生页面，关闭按钮*/
    STUDENT_UPLOAD_PAGE_CLOSE_BUTTON_XPATH("xpath","/html/body/div[1]/div/div/div/div[1]/button"),
    /**上传学生文件按钮*/
    UPLOAD_STUDENT_FILE_XPATH("xpath","/html/body/div[1]/div/div/div/div[2]/form/div[1]/div[2]/button"),

    /**上传老师按钮*/
    UPLOAD_TEACHER_INFORMATION_XPATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[1]/div/button[5]"),
    /**老师总人数*/
    TEACHER_SUM_NUMBER_XPATH("xpath","//*[@id=\"layui-laypage-1\"]/span[1]"),


    /**进入上传成绩页面按钮*/
    UPLOAD_GRADE_INFORMATION_XPATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[2]/div/div/button[3]"),
    /**选择年级下拉框Select*/
    SELECT_GRADE_XPATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[3]/div/div/div[2]/div[1]/div[2]/select"),
    /**选择学年下拉框Select*/
    SELECT_STUDY_YEAR_XPATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[3]/div/div/div[2]/div[2]/div[1]/div[2]/select"),
    /**考试名称输入框input*/
    TESTNAME_INPUT_XPATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[3]/div/div/div[2]/div[2]/div[2]/div[2]/input"),
    /**选择文件按钮*/
    SELECT_FILE_BUTTON_XPATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[3]/div/div/div[2]/div[2]/div[3]/div[2]/button"),
    /**上传成绩按钮Button*/
    UPLOAD_GRADE_fILE_XPATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[3]/div/div/div[2]/div[3]/button"),
    /**保存按钮Button*/
    PROTECT_BUTTON_XPATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[3]/div/div/div[2]/div[5]/button[2]"),
    /**查看详情link*/
    SCOREDETAI_LINK_XPATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[2]/table/tbody/tr[1]/td[6]"),

    /**分数总纪录数*/
    SCORE_SUM_NUMBER_XPATH("xpath","//*[@id=\"layui-laypage-6\"]/span[1]"),



    /**上传课程按钮Button*/
    UPLOAD_COURSE_INFORMATION_XPATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[2]/div/button[4]"),


    /**上传教室按钮 Button*/
    ADDRESS_UPLOAD_INFORMATION_XPATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[1]/div/button[5]"),
    /**教室总记录数*/
    ADDRESS_SUM_NUMBER_XPATH("xpath","//*[@id=\"layui-laypage-1\"]/span")
    ;



    private final String key;
    private final String path;

    Base_ManagerElement(String key, String path){
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
