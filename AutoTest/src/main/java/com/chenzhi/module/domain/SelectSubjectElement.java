package com.chenzhi.module.domain;

public enum SelectSubjectElement {

    START_ADD_TASK_BUTTON("xpath","//*[@id=\"selectTaskList\"]/div[2]/p/span"),

    /**新增选课任务按钮，高考选课和校内选课共用*/
    CREATE_TASK_BUTTON("xpath","//*[@id=\"selectTaskList\"]/h3/div/i"),

    /**选课名称输入框，高考选课和校内选课共用*/
    SELECT_SUBJECT_NAME("xpath","//*[@id=\"createSelectTask\"]/div[2]/div[1]/input"),

    /**选科年级下拉框，高考选科和校内选科共用*/
    SELECT_SUBJECT_YEAR("xpath","//*[@id=\"createSelectTask\"]/div[2]/div[2]/select"),

    /**开始时间*/
    SELECT_SUBJECT_START_TIME("id","startTime"),

    /**结束时间*/
    SELECT_SUBJECT_END_TIME("id","endTime"),

    /**学生必选科目数量*/
    COURSE_SELECT_NUMBER_PATH("xpath","//*[@id=\"createSelectTask\"]/div[2]/div[4]/div/input"),

    /**添加可选课程按钮*/
    COURSE_SELECT_BUTTON_PATH("xpath","//*[@id=\"createSelectTask\"]/div[2]/div[5]/div/div[1]/div"),

    /**课程选择下拉框*/
    COURSE_SELECT_PATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[2]/div/div[3]/div[1]/div[2]/div[1]/select"),

    /**课程选择下拉框*/
    COURSE_SECOND_SELECT_PATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[2]/div/div[3]/div[1]/div[2]/div[2]/select"),

    /**人数上限*/
    HUMAN_NUMBER_INPUT_PATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[2]/div/div[3]/div[1]/div[2]/div[3]/div/input"),

    /**课程确定按钮*/
    COURSE_OK_BUTTON_PATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[2]/div/div[3]/div[1]/div[2]/div[6]/button[2]"),

    /**选科任务保存按钮*/
    COURSE_TASK_OK_BUTTON_PATH("xpath","/html/body/div[2]/div[2]/div/div/ui-view/div/div[2]/div/div[2]/button[2]"),

    SELECT_SUBJECT_GROUP("xpath","//*[@id=\"createSelectTask\"]/div[2]/div[4]/div/div[2]/div/div[2]/div[1]"),

    SELECT_YES_BUTTON("ClassName","theme_btn"),

    /**table_path*/
    COMMON_TR_Number_PATH("xpath","//*[@id=\"page\"]/div/span"),

    COMMON_CELL_PATH("xpath","//*[@id=\"selectTaskList\"]/div[2]/div[1]/table/tbody"),

    DELETE_BUTTON_PATH("xpath","//*[@id=\"createSelectTask\"]/h2/div/button"),

    DELETE_OK_BUTTON_PATH("xpath","//*[@id=\"selectCourseHome\"]/div/div[3]/div[2]/div[1]/select-task/div/div[2]/div[3]/div[2]/div[2]/div/button"),

    /**校内选科删除确定按钮*/
    DELETE_OK_SCHOOL_BUTTON_PATH("xpath" ,"/html/body/div[2]/div[2]/div/div/ui-view/div/div[2]/div/div[3]/div[2]/div[2]/div/button"),

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

    /**微信端管理选课链接*/
    WECHAT_BUTTON_PATH("xpath","//*[@id=\"createSelectTask\"]/h2/span[1]"),
    /**快速录入班主任信息链接按钮*/
    CLASS_TEACHER_PATH("xpath","//*[@id=\"wechatGuide\"]/div/div[1]/div[2]/p[2]/span"),

    /**下载班主任模板按钮*/
    CLASS_TEACHER_UPLOAD_PATH("xpath","//*[@id=\"wechatGuide\"]/div/div[2]/div[2]/div[2]/form/div/div[2]/span"),

    /**应用选课数据按钮*/
    USE_SELECT_COURSE_PATH("xpath","//*[@id=\"createSelectTask\"]/h2/span[2]"),

    /**选课确定按钮*/
    SELECT_COURSE_BUTTON_PATH("xpath","//*[@id=\"popup\"]/div/div[2]/div[1]/div[3]/div[1]"),

    /**选课应用成功文本*/
    USE_COURSE_SUCCESS_TXT_PATH("xpath","//*[@id=\"popup\"]/div/div[2]/div[2]/div[1]/p"),

    /**校内选科，已选课程下拉框*/
    IS_SELECT_COURSE_PATH("xpath","//*[@id=\"stuList\"]/div[2]/div/div[2]/div[4]/select"),

    /**校内选科，确定按钮*/
    SCHOOL_SELECT_OK_BUTTON_PATH("xpath","//*[@id=\"stuList\"]/div[2]/div/div[2]/div[5]/button")

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
