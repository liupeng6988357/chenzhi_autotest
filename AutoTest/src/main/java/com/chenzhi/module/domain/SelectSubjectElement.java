package com.chenzhi.module.domain;

public enum SelectSubjectElement {

    START_ADD_TASK_BUTTON("xpath","//*[@id=\"selectTaskList\"]/div[2]/p/span"),

    CREATE_TASK_BUTTON("xpath","//*[@id=\"selectTaskList\"]/h3/div/i"),

    SELECT_SUBJECT_NAME("xpath","//*[@id=\"createSelectTask\"]/div[2]/div[1]/input"),

    SELECT_SUBJECT_YEAR("xpath","//*[@id=\"createSelectTask\"]/div[2]/div[2]/select"),

    SELECT_SUBJECT_START_TIME("id","startTime"),

    SELECT_SUBJECT_END_TIME("id","endTime"),

    SELECT_SUBJECT_GROUP("xpath","//*[@id=\"createSelectTask\"]/div[2]/div[4]/div/div[2]/div/div[2]/div[1]"),

    SELECT_YES_BUTTON("ClassName","theme_btn"),

    /**table_path*/
    COMMON_TR_Number_PATH("xpath","//*[@id=\"page\"]/div/span"),

    COMMON_CELL_PATH("xpath","//*[@id=\"selectTaskList\"]/div[2]/div[1]/table/tbody"),

    DELETE_BUTTON_PATH("xpath","//*[@id=\"createSelectTask\"]/h2/div/button"),

    DELETE_OK_BUTTON_PATH("xpath","//*[@id=\"selectCourseHome\"]/div/div[3]/div[2]/div[1]/select-task/div/div[2]/div[3]/div[2]/div[2]/div/button"),

    WECHAT_OK_BUTTON("xpath","//*[@id=\"wechatGuide\"]/div/div[1]/div[2]/div[2]/button"),

    /**学生检索Select*/
    STUDENT_SELECT_PATH("xpath","//*[@id=\"createSelectTask\"]/div[2]/div[1]/select[2]"),

    STUDENT_CLASS_Select_PATH("xpath","//*[@id=\"createSelectTask\"]/div[2]/div[1]/select[1]"),

    STUDENT_TABLE_LIST_PATH("xpath","//*[@id=\"createSelectTask\"]/div[2]/div[2]/table/tbody"),

    COURSE_LABLE_PATH("ClassName","cz_radio_dom_span"),

    UPDATE_COURSE_OK_BUTTON("xpath","//*[@id=\"stuList\"]/div[2]/div/div[2]/div[5]/button"),

    STUDENT_NAME_INPUT_PATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div/div[3]/div[2]/div[1]/select-task/div/div[3]/div/div[1]/div[2]/div[1]/input"),

    STUDENT_TR_NUMBER_PATH("xpath","//*[@id=\"stuListPage\"]/div/span[1]"),

    STUDENT_PAGE_CHANGE_PATH("xpath","//*[@id=\"stuListPage\"]/div/span[2]/input"),

    STUDENT_OK_BUTTON_PATH("xpath","//*[@id=\"stuListPage\"]/div/span[2]/button"),

    /**导出学生列表按钮*/
    UPLOAD_STUDENT_LIST_PATH("xpath","//*[@id=\"createSelectTask\"]/div[2]/div[1]/button"),
    ;

    private final String key;
    private final String path;

    SelectSubjectElement(String key, String path){
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
