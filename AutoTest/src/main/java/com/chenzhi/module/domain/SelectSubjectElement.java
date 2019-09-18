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
    COMMON_CELL_PATH("xpath","//*[@id=\"selectTaskList\"]/div[2]/div[1]/table/tbody"),

    DELETE_BUTTON_PATH("xpath","//*[@id=\"createSelectTask\"]/h2/div/button"),

    DELETE_OK_BUTTON_PATH("xpath","//*[@id=\"selectCourseHome\"]/div/div[3]/div[2]/div[1]/select-task/div/div[2]/div[3]/div[2]/div[2]/div/button")
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
