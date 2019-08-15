package com.chenzhi.module.business;

import com.chenzhi.module.domain.DevideClassListPageElement;
import com.chenzhi.module.util.Methods;

public class DevideClassFunction {


    /**创建分班任务功能*/
    public static void createDevideClassTask(String taskName, Methods methods) throws Exception{

        methods.switchFrame(DevideClassListPageElement.IFRAME_DEVIDE_CLASS_ID.getPath());

        methods.getWebElementList(DevideClassListPageElement.ADD_DEVIDE_CLASS_BUTTONS.getKey(), DevideClassListPageElement.ADD_DEVIDE_CLASS_BUTTONS.getPath()).get(0).click();

        methods.getWebElement(DevideClassListPageElement.TASK_DEVIDE_CLASS_NAME_INPUT.getKey(), DevideClassListPageElement.TASK_DEVIDE_CLASS_NAME_INPUT.getPath()).sendKeys(taskName);

        Thread.sleep(5000);

        /**选择年级*/
        methods.getWebElementList(DevideClassListPageElement.GRADE_SELECT_CLASSNAME.getKey(),DevideClassListPageElement.GRADE_SELECT_CLASSNAME.getPath()).get(1).click();

        methods.getWebElementList(DevideClassListPageElement.GRADE_SELECT_VALUES_XPATH.getKey(),DevideClassListPageElement.GRADE_SELECT_VALUES_XPATH.getPath()).get(0).click();

        Thread.sleep(5000);

        /**选择分班类型*/
        methods.getWebElementList(DevideClassListPageElement.DEVIDE_CLASS_TYPE_CLASSNAME.getKey(),DevideClassListPageElement.DEVIDE_CLASS_TYPE_CLASSNAME.getPath()).get(2).click();

        methods.getWebElementList(DevideClassListPageElement.GRADE_SELECT_VALUES_XPATH.getKey(),DevideClassListPageElement.DEVIDE_CLASS_TYPE_VALUES_XPATH.getPath()).get(0).click();

        Thread.sleep(5000);

        /**选择班级类型*/
        methods.getWebElementList(DevideClassListPageElement.CLASS_TYPE_CLASSNAME.getKey(),DevideClassListPageElement.CLASS_TYPE_CLASSNAME.getPath()).get(3).click();

        methods.getWebElementList(DevideClassListPageElement.CLASS_TYPE_VALUES_XPATH.getKey(),DevideClassListPageElement.CLASS_TYPE_VALUES_XPATH.getPath()).get(0).click();

        /**点击确定按钮*/
        methods.getWebElement(DevideClassListPageElement.DETERMINE_BUTTON_XPATH.getKey(),DevideClassListPageElement.DETERMINE_BUTTON_XPATH.getPath()).click();

    }

}
