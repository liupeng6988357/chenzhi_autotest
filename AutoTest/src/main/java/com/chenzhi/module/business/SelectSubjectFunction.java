package com.chenzhi.module.business;


import com.chenzhi.module.domain.SelectSubjectElement;
import com.chenzhi.module.util.Methods;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 选科功能测试方法
 */
public class SelectSubjectFunction {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**创建高考选科任务测试*/
    public static String createTask(Methods methods,String taskName,String year,
                                    String startTime,String endTime,boolean divideGroup,boolean isGroup) throws Exception{

        methods.getWebElement(SelectSubjectElement.CREATE_TASK_BUTTON.getKey(),SelectSubjectElement.CREATE_TASK_BUTTON.getPath()).click();

        methods.getWebElement(SelectSubjectElement.SELECT_SUBJECT_NAME.getKey(),SelectSubjectElement.SELECT_SUBJECT_NAME.getPath()).sendKeys(taskName);

        methods.getWebSelect(SelectSubjectElement.SELECT_SUBJECT_YEAR.getKey(),SelectSubjectElement.SELECT_SUBJECT_YEAR.getPath()).selectByVisibleText(year);

        if (!startTime.equals("")){

            WebElement start = methods.getWebElement(SelectSubjectElement.SELECT_SUBJECT_START_TIME.getKey(),SelectSubjectElement.SELECT_SUBJECT_START_TIME.getPath());

            start.clear();

            start.sendKeys(startTime);

        }

        if (!endTime.equals("")){

            WebElement end = methods.getWebElement(SelectSubjectElement.SELECT_SUBJECT_END_TIME.getKey(),SelectSubjectElement.SELECT_SUBJECT_END_TIME.getPath());

            end.clear();

            end.sendKeys(endTime);
        }

        methods.getWebElement(SelectSubjectElement.SELECT_YES_BUTTON.getKey(),SelectSubjectElement.SELECT_YES_BUTTON.getPath()).click();

        Thread.sleep(5000);

        String resultName = methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[2]").getText();

        String selectYear = methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[3]").getText();

        String start_end_time = methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[4]").getText();

        /**开始时间和结束时间都不是空字符串*/
        if (!startTime.equals("") && !endTime.equals("")){
            if (resultName.equals(taskName) && selectYear.equals(year)
                    && start_end_time.equals(startTime+" - "+endTime)){
                return "SUCCESS";
            }
            /**开始时间不是空字符串*/
        } else if (!startTime.equals("")){
            if (resultName.equals(taskName) && selectYear.equals(year)
                    && start_end_time.equals(startTime+" - "+df.format(new Date().getTime()+1800000))){
                return "SUCCESS";
            }
            /**结束时间不是空字符串*/
        } else if (!endTime.equals("")){
            if (resultName.equals(taskName) && selectYear.equals(year)
                    && start_end_time.equals(df.format(new Date().getTime()+1800000)+" - "+endTime)){
                return "SUCCESS";
            }
            /**都是空字符串*/
        } else {
            if (resultName.equals(taskName) && selectYear.equals(year)){
                return "SUCCESS";
            }
        }

        return "FAILE";
    }

    /**
     * 删除选课任务操作
     * @param methods
     */
    public static String deleteTask(Methods methods) {

        String delTaskName = methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[2]").getText();

        methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[7]/a[3]").click();

        return deleteOperate(methods, delTaskName);
    }

    /**
     * 修改选课任务操作
     * @param methods
     * @return
     * @throws Exception
     */
    public static String updateTask(Methods methods, String name) throws Exception{

        methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[7]/a[3]").click();

        return updateOperate(methods, name);
    }

    /**更新选课任务操作*/
    private static String updateOperate(Methods methods, String name) throws InterruptedException {
        WebElement name_Input = methods.getWebElement(SelectSubjectElement.SELECT_SUBJECT_NAME.getKey(),SelectSubjectElement.SELECT_SUBJECT_NAME.getPath());

        name_Input.clear();

        name_Input.sendKeys(name);

        methods.getWebElement(SelectSubjectElement.SELECT_YES_BUTTON.getKey(),SelectSubjectElement.SELECT_YES_BUTTON.getPath()).click();

        Thread.sleep(5000);

        String updatedTaskName = methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[2]").getText();

        if (updatedTaskName.equals(name)){
            return "SUCCESS";
        }

        return "FAILE";
    }

    /**删除操作*/
    private static String deleteOperate(Methods methods, String delTaskName) {
        methods.getWebElement(SelectSubjectElement.DELETE_BUTTON_PATH.getKey(),SelectSubjectElement.DELETE_BUTTON_PATH.getPath()).click();

        methods.getWebElement(SelectSubjectElement.DELETE_OK_BUTTON_PATH.getKey(),SelectSubjectElement.DELETE_OK_BUTTON_PATH.getPath()).click();

        String taskName =  methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[2]").getText();

        if (delTaskName.equals(taskName)){
            return "FAILE";
        }
        return "SUCCESS";
    }

}
