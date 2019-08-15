package com.chenzhi.module.domain;

public enum DevideClassListPageElement {


    /**新增分班任务按钮元素*/
    ADD_DEVIDE_CLASS_BUTTONS("add_devide_class_ClassName","mainBtn"),
    /**修改分班任务按钮元素*/
    UPDATE_DEVIDE_CLASS_BUTTONS("update_devide_class_ClassName","mainBtn"),
    /**删除分班任务按钮元素*/
    DELETE_DEVIDE_CLASS_BUTTONS("delete_devide_class_ClassName","mainBtn"),
    /**分班任务名称输入框元素*/
    TASK_DEVIDE_CLASS_NAME_INPUT("task_devide_clazz_name_xpath","//*[@id=\"taskList\"]/div[2]/div/div[2]/div/div/div[1]/div/div/input"),
    /**切换分班框架页面*/
    IFRAME_DEVIDE_CLASS_ID("iframe_devide_class_id","iframe"),
    /**获取年级下拉框元素*/
    GRADE_SELECT_CLASSNAME("grade_select_ClassName","el-input__inner"),
    /**年级下拉框值集*/
    GRADE_SELECT_VALUES_XPATH("grade_select_value_xpath","/html/body/div[3]/div[1]/div[1]/ul/li"),
    /**获取分班类型下拉框*/
    DEVIDE_CLASS_TYPE_CLASSNAME("devide_class_type_ClassName","el-input__inner"),
    /**获取分班类型下拉框值集*/
    DEVIDE_CLASS_TYPE_VALUES_XPATH("devide_class_type_values_xpath","/html/body/div[4]/div[1]/div[1]/ul/li"),
    /**获取班级类型下拉框*/
    CLASS_TYPE_CLASSNAME("class_type_ClassName","el-input__inner"),
    /**获取班级类型下拉框值集*/
    CLASS_TYPE_VALUES_XPATH("class_type_values_xpath","/html/body/div[5]/div[1]/div[1]/ul/li"),
    /**创建分班任务的确定按钮*/
    DETERMINE_BUTTON_XPATH("determine_button_xpath","//*[@id=\"taskList\"]/div[2]/div/div[2]/div/button")
    ;


    private final String key;
    private final String path;

    DevideClassListPageElement(String key, String path){
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
