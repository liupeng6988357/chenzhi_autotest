package com.chenzhi.module.business;


import com.chenzhi.module.domain.SelectSubjectElement;
import com.chenzhi.module.util.Methods;
import com.chenzhi.module.util.ReadExcel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/***
 * 选科功能测试方法
 */
public class SelectSubjectFunction {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

        //Thread.sleep(10000);

        //methods.getWebElement(SelectSubjectElement.WECHAT_OK_BUTTON.getKey(),SelectSubjectElement.WECHAT_OK_BUTTON.getPath()).click();

        Thread.sleep(2000);

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
    public static String deleteTask(Methods methods) throws Exception{

        String delTaskName = methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[2]").getText();

        Thread.sleep(3000);

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
    private static String deleteOperate(Methods methods, String delTaskName) throws InterruptedException{
        methods.getWebElement(SelectSubjectElement.DELETE_BUTTON_PATH.getKey(),SelectSubjectElement.DELETE_BUTTON_PATH.getPath()).click();

        methods.getWebElement(SelectSubjectElement.DELETE_OK_BUTTON_PATH.getKey(),SelectSubjectElement.DELETE_OK_BUTTON_PATH.getPath()).click();

        Thread.sleep(5000);

        String taskName =  methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[2]").getText();

        if (delTaskName.equals(taskName)){
            return "FAILE";
        }
        return "SUCCESS";
    }

    /**
     *选课任务--学生列表--检索功能操作
     * @param methods
     * @param txt：名称模糊查询字符串
     * @param id：选课类型（0：全部学生，1：已选课学生，2：未选课学生）
     * @param className：班级名称
     * @return
     * @throws InterruptedException
     */
    public static String  searchStudentsTest(Methods methods,String txt,int id,String className) throws InterruptedException {
        Thread.sleep(10000);

        /**输入模糊查询字段*/
        methods.getWebElement(SelectSubjectElement.STUDENT_NAME_INPUT_PATH.getKey(), SelectSubjectElement.STUDENT_NAME_INPUT_PATH.getPath()).sendKeys(txt);

        Select stuSelectCourseType = methods.getWebSelect(SelectSubjectElement.STUDENT_SELECT_PATH.getKey(), SelectSubjectElement.STUDENT_SELECT_PATH.getPath());

        /**选择检索类型：0，1，2*/
        stuSelectCourseType.selectByValue(String.valueOf(id));

        Select stuClass = methods.getWebSelect(SelectSubjectElement.STUDENT_CLASS_Select_PATH.getKey(), SelectSubjectElement.STUDENT_CLASS_Select_PATH.getPath());

        /**选择班级检索类型：*/
        stuClass.selectByVisibleText(className);

        Thread.sleep(5000);

        String rel_tr_number = methods.getWebElementList(SelectSubjectElement.STUDENT_TR_NUMBER_PATH.getKey(),
                SelectSubjectElement.STUDENT_TR_NUMBER_PATH.getPath()).get(0).getAttribute("innerText");

        String[] list = rel_tr_number.split(" ");

        if (rel_tr_number.equals("共 0 条")) {

            return "NO DATA";
        }

        int number = Integer.valueOf(list[1]);

        System.out.println(number);

        if (number < 10) {

            int tr_number = methods.getWebElementList(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr").size();

            System.out.println(tr_number);

            for (int i = 1; i <= tr_number; i++) {

                String x = checkLogic(methods, txt, id, className, i);
                if (x != null) return x;
            }

        } else {
            int stuId = number / 10;

            System.out.println(stuId);

            for (int i = 1; i <= stuId+1; i++) {

                WebElement inputPage = methods.getWebElement(SelectSubjectElement.STUDENT_PAGE_CHANGE_PATH.getKey(), SelectSubjectElement.STUDENT_PAGE_CHANGE_PATH.getPath());

                inputPage.clear();
                inputPage.sendKeys(String.valueOf(i));

                methods.getWebElement(SelectSubjectElement.STUDENT_OK_BUTTON_PATH.getKey(), SelectSubjectElement.STUDENT_OK_BUTTON_PATH.getPath()).click();

                Thread.sleep(3000);

                int tr_number = methods.getWebElementList(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr").size();

                System.out.println(tr_number);
                for (int j = 1; j <= tr_number; j++) {

                    String x = checkLogic(methods, txt, id, className, j);
                    if (x != null) return x;
                }

                System.out.println("---------------------------------------------");

            }
        }

        return "SUCCESS";
    }

    /**对检索结果进行判断*/
    private static String checkLogic(Methods methods, String txt, int id, String className, int i) {
        String stuName = methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr[" + i + "]/td[3]").getText();

        if (className.equals("全部班级")) {
            if (id == 1) {
                String selectCourseName = methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr[" + i + "]/td[5]").getText();

                if (stuName.contains(txt) && !selectCourseName.equals("--")) {
                    System.out.println("SUCCESS");
                } else {
                    return "FAIL";
                }
            } else if (id == 2) {
                String selectCourseName = methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr[" + i + "]/td[5]").getText();

                if (stuName.contains(txt) && selectCourseName.equals("--")) {
                    System.out.println("SUCCESS");
                } else {
                    return "FAIL";
                }
            } else if (id == 0) {

                if (stuName.contains(txt)) {
                    System.out.println("SUCCESS");
                } else {
                    return "FAIL";
                }
            } else {
                return "设置选课类型下拉框参数不正确";
            }
        } else if (className.equals("") || className==null){
            return "请输入班级参数";
        }else {
            String clazzName = methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr[" + i + "]/td[4]").getText();
            if (id == 1) {
                String selectCourseName = methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr[" + i + "]/td[5]").getText();

                if (stuName.contains(txt) && !selectCourseName.equals("--") && clazzName.equals(className)) {
                    System.out.println("SUCCESS");
                } else {
                    return "FAIL";
                }
            } else if (id == 2) {
                String selectCourseName = methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr[" + i + "]/td[5]").getText();

                if (stuName.contains(txt) && selectCourseName.equals("--") && clazzName.equals(className)) {
                    System.out.println("SUCCESS");
                } else {
                    return "FAIL";
                }
            } else if (id == 0) {

                if (stuName.contains(txt) && clazzName.equals(className)) {
                    System.out.println("SUCCESS");
                } else {
                    return "FAIL";
                }
            }
        }
        return null;
    }

    /**高考选科：下载学生列表功能*/
    public static int uploadStudentsList(Methods methods) throws Exception {
        Thread.sleep(5000);

        methods.getWebElement(SelectSubjectElement.UPLOAD_STUDENT_LIST_PATH.getKey(),SelectSubjectElement.UPLOAD_STUDENT_LIST_PATH.getPath()).click();

        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
        String time = dfs.format(new Date());
        String timeName = time.replace(":","").replace(" ","").replace("-","");

        Thread.sleep(5000);
        int rows = ReadExcel.getExcelRows("C:\\Users\\EDZ\\Downloads\\"+timeName+".xls","学生选课详情");

        System.out.println(rows);
        return rows;
    }

    /**校内选科：下载学生列表功能*/
    public static int uploadsStudentsList(Methods methods) throws Exception {
        Thread.sleep(5000);

        methods.getWebElement(SelectSubjectElement.UPLOAD_STUDENT_LIST_PATH.getKey(),SelectSubjectElement.UPLOAD_STUDENT_LIST_PATH.getPath()).click();

        String time = df.format(new Date());
        String timeName = time.replace(":","").replace(" ","").replace("-","");

        Thread.sleep(5000);
        int rows = ReadExcel.getExcelRows("C:\\Users\\EDZ\\Downloads\\"+"学生选课列表"+timeName+".xlsx","学生选课详情");

        System.out.println(rows);
        return rows;
    }

    /**下载老师模板操作*/
    public static void uploadClassTeacher(Methods methods) throws Exception{

        methods.getWebElement(SelectSubjectElement.WECHAT_BUTTON_PATH.getKey(),SelectSubjectElement.WECHAT_BUTTON_PATH.getPath()).click();

        Thread.sleep(5000);

        methods.getWebElement(SelectSubjectElement.CLASS_TEACHER_PATH.getKey(),SelectSubjectElement.CLASS_TEACHER_PATH.getPath()).click();

        Thread.sleep(3000);

        methods.getWebElement(SelectSubjectElement.CLASS_TEACHER_UPLOAD_PATH.getKey(),SelectSubjectElement.CLASS_TEACHER_UPLOAD_PATH.getPath()).click();
    }

    /**应用选课数据操作*/
    public static String useDataTest(Methods methods) throws Exception{

        methods.getWebElement(SelectSubjectElement.USE_SELECT_COURSE_PATH.getKey(),SelectSubjectElement.USE_SELECT_COURSE_PATH.getPath()).click();

        Thread.sleep(5000);

        methods.getWebElement(SelectSubjectElement.SELECT_COURSE_BUTTON_PATH.getKey(),SelectSubjectElement.SELECT_COURSE_BUTTON_PATH.getPath()).click();

        Thread.sleep(10000);

        String success_text = methods.getWebElement(SelectSubjectElement.USE_COURSE_SUCCESS_TXT_PATH.getKey(),SelectSubjectElement.USE_COURSE_SUCCESS_TXT_PATH.getPath()).getText();

        return success_text;
    }

    /**校内选科任务新增功能操作*/
    public  static void addSelectCourseTaskTest(Methods methods, String taskName, String year,
                                                String startTime, String endTime, int selectCourseNum,
                                                List<String> list, int humanNum) throws  Exception{

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

        Thread.sleep(3000);

        WebElement selectCourseNumInput = methods.getWebElement(SelectSubjectElement.COURSE_SELECT_NUMBER_PATH.getKey(),SelectSubjectElement.COURSE_SELECT_NUMBER_PATH.getPath());

        selectCourseNumInput.clear();

        /**学生必选课数目设置*/
        selectCourseNumInput.sendKeys(String.valueOf(selectCourseNum));

        for (int i = 0; i < selectCourseNum + 1; i++) {
            methods.getWebElement(SelectSubjectElement.COURSE_SELECT_BUTTON_PATH.getKey(),SelectSubjectElement.COURSE_SELECT_BUTTON_PATH.getPath()).click();

            Thread.sleep(5000);
            methods.getWebSelect(SelectSubjectElement.COURSE_SELECT_PATH.getKey(),SelectSubjectElement.COURSE_SELECT_PATH.getPath()).selectByVisibleText(list.get(0));

            Thread.sleep(3000);

            methods.getWebSelect(SelectSubjectElement.COURSE_SECOND_SELECT_PATH.getKey(),SelectSubjectElement.COURSE_SECOND_SELECT_PATH.getPath()).selectByVisibleText(list.get(i+1));

            WebElement humanInput = methods.getWebElement(SelectSubjectElement.HUMAN_NUMBER_INPUT_PATH.getKey(),SelectSubjectElement.HUMAN_NUMBER_INPUT_PATH.getPath());

            humanInput.clear();

            humanInput.sendKeys(String.valueOf(humanNum));

            methods.getWebElement(SelectSubjectElement.COURSE_OK_BUTTON_PATH.getKey(),SelectSubjectElement.COURSE_OK_BUTTON_PATH.getPath()).click();

        }

        methods.getWebElement(SelectSubjectElement.COURSE_TASK_OK_BUTTON_PATH.getKey(),SelectSubjectElement.COURSE_TASK_OK_BUTTON_PATH.getPath()).click();

    }
    /**删除校内选科任务*/
    public static String deleteSelectCourseTaskTest(Methods methods) throws Exception{

        String delTaskName = methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[2]").getText();

        Thread.sleep(3000);

        methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[7]/a[3]").click();

        methods.getWebElement(SelectSubjectElement.DELETE_BUTTON_PATH.getKey(),SelectSubjectElement.DELETE_BUTTON_PATH.getPath()).click();

        methods.getWebElement(SelectSubjectElement.DELETE_OK_SCHOOL_BUTTON_PATH.getKey(),SelectSubjectElement.DELETE_OK_SCHOOL_BUTTON_PATH.getPath()).click();

        Thread.sleep(5000);

        String taskName =  methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[2]").getText();

        if (delTaskName.equals(taskName)){
            return "FAILE";
        }
        return "SUCCESS";
    }

    /**高考选科，修改选科数据*/
    public static void updateSelectCourseData(Methods methods,int studentSelectCourseType,int courseType) throws InterruptedException {
        Select select = methods.getWebSelect(SelectSubjectElement.STUDENT_SELECT_PATH.getKey(),SelectSubjectElement.STUDENT_SELECT_PATH.getPath());

        Thread.sleep(3000);

        select.selectByValue(String.valueOf(studentSelectCourseType));

        //for (int i = 0; i <100 ; i++) {

        Thread.sleep(3000);

        methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(),SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath()+"/tr[1]/td[6]/a").click();

        Thread.sleep(3000);

        List<WebElement> elementList = methods.getWebElementList(SelectSubjectElement.COURSE_LABLE_PATH.getKey(),SelectSubjectElement.COURSE_LABLE_PATH.getPath());

        elementList.get(courseType).click();

        methods.getWebElement(SelectSubjectElement.UPDATE_COURSE_OK_BUTTON.getKey(),SelectSubjectElement.UPDATE_COURSE_OK_BUTTON.getPath()).click();

        //  }
    }

    /**校内选科，修改选科任务操作*/
    public static String updateSchoolSelectCourseData(Methods methods,String taskName) throws Exception{

        methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[7]/a[3]").click();

        WebElement name_Input = methods.getWebElement(SelectSubjectElement.SELECT_SUBJECT_NAME.getKey(),SelectSubjectElement.SELECT_SUBJECT_NAME.getPath());

        name_Input.clear();

        name_Input.sendKeys(taskName);

        methods.getWebElement(SelectSubjectElement.SELECT_YES_BUTTON.getKey(),SelectSubjectElement.SELECT_YES_BUTTON.getPath()).click();

        Thread.sleep(5000);

        String updatedTaskName = methods.getWebElement(SelectSubjectElement.COMMON_CELL_PATH.getKey(),SelectSubjectElement.COMMON_CELL_PATH.getPath()+"/tr[1]/td[2]").getText();

        if (updatedTaskName.equals(taskName)){
            return "SUCCESS";
        }

        return "FAILE";
    }

    /**修改选科信息*/
    public static void updateStudentCourseData(Methods methods) throws Exception{

        Thread.sleep(3000);

        methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(),SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath()+"/tr[1]/td[6]/a").click();

        Thread.sleep(3000);

        Select isSelectCourse = methods.getWebSelect(SelectSubjectElement.IS_SELECT_COURSE_PATH.getKey(),SelectSubjectElement.IS_SELECT_COURSE_PATH.getPath());

        List<WebElement> options = isSelectCourse.getOptions();

        System.out.println(options.size());

        isSelectCourse.selectByIndex(options.size()-1);

        methods.getWebElement(SelectSubjectElement.SCHOOL_SELECT_OK_BUTTON_PATH.getKey(),SelectSubjectElement.SCHOOL_SELECT_OK_BUTTON_PATH.getPath()).click();
    }
}
