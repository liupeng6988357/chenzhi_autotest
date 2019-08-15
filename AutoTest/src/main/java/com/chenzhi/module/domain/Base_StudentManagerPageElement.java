package com.chenzhi.module.domain;

public enum  Base_StudentManagerPageElement {


    /**上传学生详情按钮*/
    UPLOAD_STUDENT_INFORMATION_XPATH("upload_student_information_xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[1]/div/button[2]"),
    /**上传文件按钮*/
    UPLOAD_FILE_XPATH("upload_file_xpath","/html/body/div[1]/div/div/div/div[2]/form/div[1]/div[2]/button"),
    /**上传结果文案*/
    UPLOAD_RESULT_TEXT_XPATH("upload_result_text_xpath","/html/body/div[1]/div/div/div/div[2]/form/span/div/div"),
    /**学生总人数*/
    STUDENT_SUM_NUMBER_ID("student_sum_Number_id","layui-laypage-2")
    ;




    private final String key;
    private final String path;

    Base_StudentManagerPageElement(String key, String path){
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
