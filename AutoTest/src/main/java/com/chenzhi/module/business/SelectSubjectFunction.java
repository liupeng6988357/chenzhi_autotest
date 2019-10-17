package com.chenzhi.module.business;


import com.chenzhi.module.domain.SelectSubjectElement;
import com.chenzhi.module.model.SelectOneCourseNum;
import com.chenzhi.module.model.SelectThreeCourseNum;
import com.chenzhi.module.model.SelectTwoCourseNum;
import com.chenzhi.module.util.FileOperate;
import com.chenzhi.module.util.Methods;
import com.chenzhi.module.util.ReadExcel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/***
 * 选科功能测试方法
 */
public class SelectSubjectFunction {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static SimpleDateFormat dfst = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    /**
     * 创建高考选科任务测试
     * @param methods
     * @param taskName
     * @param year
     * @param startTime
     * @param endTime
     * @param divideGroup
     * @param isGroup
     * @return
     * @throws Exception
     */
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
    /**
     * 更新选课任务操作
     * @param methods
     * @param name
     * @return
     * @throws InterruptedException
     */
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
    /**
     * 删除操作
     * @param methods
     * @param delTaskName
     * @return
     * @throws InterruptedException
     */
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
    /**
     * 对检索结果进行判断
     * @param methods
     * @param txt
     * @param id
     * @param className
     * @param i
     * @return
     */
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
    /**
     * 高考选科：下载学生列表功能
     * @param methods
     * @return
     * @throws Exception
     */
    public static String uploadStudentsList(Methods methods) throws Exception {
        List<String> lists = new ArrayList<String>();
        Thread.sleep(5000);
        methods.getWebElement(SelectSubjectElement.UPLOAD_STUDENT_LIST_PATH.getKey(),SelectSubjectElement.UPLOAD_STUDENT_LIST_PATH.getPath()).click();
        String time = dfst.format(new Date());
        String timeName = time.replace(":","").replace(" ","").replace("-","");
        Thread.sleep(10000);
        List<String> list = FileOperate.getFiles("C:\\Users\\EDZ\\Downloads");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(timeName)){
                lists.add(list.get(i));
            }
        }
        if (lists.size() == 0) {
            return "FIAL";
        }else if (lists.size()>1){
            throw new Exception("无法判断");
        }else {
            Thread.sleep(5000);
            String filePath = lists.get(0).replaceAll("\\\\","\\\\\\\\");
            System.out.println(filePath);
            int rows = ReadExcel.getExcelRowsXls(filePath, "学生选课详情");
            System.out.println(rows);
            return "SUCCESS";
        }
    }
    /**
     * 校内选科：下载学生列表功能
     * @param methods
     * @return
     * @throws Exception
     */
    public static String uploadsStudentsList(Methods methods) throws Exception {

        List<String> lists = new ArrayList<String>();
        Thread.sleep(5000);
        methods.getWebElement(SelectSubjectElement.UPLOAD_STUDENT_LIST_PATH.getKey(),SelectSubjectElement.UPLOAD_STUDENT_LIST_PATH.getPath()).click();
        String time = df.format(new Date());
        String timeName = time.replace(":","").replace(" ","").replace("-","");
        System.out.println(timeName);
        Thread.sleep(10000);
        List<String> list = FileOperate.getFiles("C:\\Users\\EDZ\\Downloads");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(timeName)){
                lists.add(list.get(i));
            }
        }
        if (lists.size() == 0) {
            return "FIAL";
        }else if (lists.size()>1){
            throw new Exception("无法判断");
        }else {
            Thread.sleep(5000);
            String filePath = lists.get(0).replaceAll("\\\\","\\\\\\\\");
            System.out.println(filePath);
            int rows = ReadExcel.getExcelRowsXlsx(filePath, "学生选课详情");
            System.out.println(rows);
            return "SUCCESS";
        }
    }
    /**
     * 下载老师模板操作
     * @param methods
     * @throws Exception
     */
    public static void uploadClassTeacher(Methods methods) throws Exception{

        methods.getWebElement(SelectSubjectElement.WECHAT_BUTTON_PATH.getKey(),SelectSubjectElement.WECHAT_BUTTON_PATH.getPath()).click();

        Thread.sleep(5000);

        methods.getWebElement(SelectSubjectElement.CLASS_TEACHER_PATH.getKey(),SelectSubjectElement.CLASS_TEACHER_PATH.getPath()).click();

        Thread.sleep(3000);

        methods.getWebElement(SelectSubjectElement.CLASS_TEACHER_UPLOAD_PATH.getKey(),SelectSubjectElement.CLASS_TEACHER_UPLOAD_PATH.getPath()).click();
    }
    /**
     * 应用选课数据操作
     * @param methods
     * @return
     * @throws Exception
     */
    public static String useDataTest(Methods methods) throws Exception{

        methods.getWebElement(SelectSubjectElement.USE_SELECT_COURSE_PATH.getKey(),SelectSubjectElement.USE_SELECT_COURSE_PATH.getPath()).click();

        Thread.sleep(5000);

        methods.getWebElement(SelectSubjectElement.SELECT_COURSE_BUTTON_PATH.getKey(),SelectSubjectElement.SELECT_COURSE_BUTTON_PATH.getPath()).click();

        Thread.sleep(10000);

        String success_text = methods.getWebElement(SelectSubjectElement.USE_COURSE_SUCCESS_TXT_PATH.getKey(),SelectSubjectElement.USE_COURSE_SUCCESS_TXT_PATH.getPath()).getText();

        return success_text;
    }
    /**
     * 校内选科任务新增功能操作
     * @param methods
     * @param taskName
     * @param year
     * @param startTime
     * @param endTime
     * @param selectCourseNum
     * @param list
     * @param humanNum
     * @throws Exception
     */
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
    /**
     * 删除校内选科任务
     * @param methods
     * @return
     * @throws Exception
     */
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
    /**
     * 高考选科，修改选科数据
     * @param methods
     * @param studentSelectCourseType
     * @param courseType
     * @throws InterruptedException
     */
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
    /**
     * 校内选科，修改选科任务操作
     * @param methods
     * @param taskName
     * @return
     * @throws Exception
     */
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
    /**
     * 修改选科信息
     * @param methods
     * @throws Exception
     */
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
    /**
     * 学科分析：单科分析数据检测操作
     * @param methods
     * @return
     * @throws Exception
     */
    public static String checkCourseAnalyze(Methods methods) throws Exception{
        List<String[]> trDataTxt = new ArrayList<String[]>();
        SelectOneCourseNum selectCourseNum = getCourseSelectedNum(methods);
        enterCourseOperate(methods);

        List<WebElement> webElementList = methods.getWebElementList(SelectSubjectElement.COURSE_TABLE_TR_PATH.getKey(),SelectSubjectElement.COURSE_TABLE_TR_PATH.getPath());
        for (int i = 1; i <= webElementList.size(); i++) {
            List<WebElement> lists = methods.getWebElementList(SelectSubjectElement.COURSE_TABLE_TR_PATH.getKey(),SelectSubjectElement.COURSE_TABLE_TR_PATH.getPath()+"["+i+"]"+"/td");
            String[] trData = new String[3];
            for (int j = 1; j <= lists.size(); j++) {
                trData[j-1] = methods.getWebElement(SelectSubjectElement.COURSE_TABLE_TR_PATH.getKey(),SelectSubjectElement.COURSE_TABLE_TR_PATH.getPath()+"["+i+"]"+"/td"+"["+j+"]").getText();
            }
            trDataTxt.add(trData);
            System.out.println(Arrays.toString(trData));
        }
        for (int i = 0; i < trDataTxt.size(); i++) {
            switch (trDataTxt.get(i)[0]){
                case "化学":
                    if (selectCourseNum.getChemistryNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectCourseNum.getChemistryNum() / (float) selectCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return "FIAL";
                    }
                    break;
                case "物理":
                    if (selectCourseNum.getPhysicsNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectCourseNum.getPhysicsNum() / (float) selectCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return "FIAL";
                    }
                    break;
                case "生物":
                    if (selectCourseNum.getBiologyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectCourseNum.getBiologyNum() / (float) selectCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        System.out.println(String.format("%.1f", (float) selectCourseNum.getBiologyNum() / (float) selectCourseNum.getSumNum() * 100));
                        return "FIAL";
                    }
                    break;
                case "历史":
                    if (selectCourseNum.getHistroyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectCourseNum.getHistroyNum() / (float) selectCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return "FIAL";
                    }
                    break;
                case "地理":
                    if (selectCourseNum.getGeographyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectCourseNum.getGeographyNum() / (float) selectCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return "FIAL";
                    }
                    break;
                case "政治":
                    if (selectCourseNum.getPoliticsNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectCourseNum.getPoliticsNum() / (float) selectCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return "FIAL";
                    }
                    break;
                case "技术":
                    if (selectCourseNum.getArtisticalNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectCourseNum.getArtisticalNum() / (float) selectCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return "FIAL";
                    }
                    break;
            }
        }
        return "SUCCESS";
    }
    /**
     * 统计选课数据
     * @param methods
     * @return
     * @throws Exception
     */
    private static SelectOneCourseNum getCourseSelectedNum(Methods methods) throws Exception{
        SelectOneCourseNum selectCourseNum = new SelectOneCourseNum();
        Select stuSelectCourseType = methods.getWebSelect(SelectSubjectElement.STUDENT_SELECT_PATH.getKey(), SelectSubjectElement.STUDENT_SELECT_PATH.getPath());
        /**选择检索类型：0，1，2*/
        stuSelectCourseType.selectByValue(String.valueOf(1));

        Thread.sleep(5000);
        String rel_tr_number = methods.getWebElementList(SelectSubjectElement.STUDENT_TR_NUMBER_PATH.getKey(),
                SelectSubjectElement.STUDENT_TR_NUMBER_PATH.getPath()).get(0).getAttribute("innerText");
        String[] list = rel_tr_number.split(" ");
        if (rel_tr_number.equals("共 0 条")) {
            return null;
        }
        int number = Integer.valueOf(list[1]);
        selectCourseNum.setSumNum(number);
        System.out.println(number);
        if (number < 10) {
            int tr_number = methods.getWebElementList(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr").size();
            System.out.println(tr_number);
            for (int i = 1; i <= tr_number; i++) {
                String couresCombinate = methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr[" + i + "]/td[5]").getText();
                String[] strings = couresCombinate.split("\\+");
                for (int j = 0; j < strings.length; j++) {
                    switch (strings[j]){
                        case "化学":
                            selectCourseNum.setChemistryNum(selectCourseNum.getChemistryNum()+1);
                            break;
                        case "物理":
                            selectCourseNum.setPhysicsNum(selectCourseNum.getPhysicsNum()+1);
                            break;
                        case "生物":
                            selectCourseNum.setBiologyNum(selectCourseNum.getBiologyNum()+1);
                            break;
                        case "历史":
                            selectCourseNum.setHistroyNum(selectCourseNum.getHistroyNum()+1);
                            break;
                        case "地理":
                            selectCourseNum.setGeographyNum(selectCourseNum.getGeographyNum()+1);
                            break;
                        case "政治":
                            selectCourseNum.setPoliticsNum(selectCourseNum.getPoliticsNum()+1);
                            break;
                        case "技术":
                            selectCourseNum.setArtisticalNum(selectCourseNum.getArtisticalNum()+1);
                            break;
                    }
                }
            }
        } else {
            int stuId = number / 10;
            System.out.println(stuId);
            for (int i = 1; i <= stuId + 1; i++) {
                WebElement inputPage = methods.getWebElement(SelectSubjectElement.STUDENT_PAGE_CHANGE_PATH.getKey(), SelectSubjectElement.STUDENT_PAGE_CHANGE_PATH.getPath());
                inputPage.clear();
                inputPage.sendKeys(String.valueOf(i));
                methods.getWebElement(SelectSubjectElement.STUDENT_OK_BUTTON_PATH.getKey(), SelectSubjectElement.STUDENT_OK_BUTTON_PATH.getPath()).click();
                Thread.sleep(3000);
                int tr_number = methods.getWebElementList(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr").size();
                System.out.println(tr_number);
                for (int j = 1; j <= tr_number; j++) {
                    String couresCombinate = methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr[" + j + "]/td[5]").getText();
                    String[] courses = couresCombinate.split("\\+");
                    for (int t = 0; t < courses.length; t++) {
                        switch (courses[t]) {
                            case "化学":
                                selectCourseNum.setChemistryNum(selectCourseNum.getChemistryNum() + 1);
                                break;
                            case "物理":
                                selectCourseNum.setPhysicsNum(selectCourseNum.getPhysicsNum() + 1);
                                break;
                            case "生物":
                                selectCourseNum.setBiologyNum(selectCourseNum.getBiologyNum() + 1);
                                break;
                            case "历史":
                                selectCourseNum.setHistroyNum(selectCourseNum.getHistroyNum() + 1);
                                break;
                            case "地理":
                                selectCourseNum.setGeographyNum(selectCourseNum.getGeographyNum() + 1);
                                break;
                            case "政治":
                                selectCourseNum.setPoliticsNum(selectCourseNum.getPoliticsNum() + 1);
                                break;
                            case "技术":
                                selectCourseNum.setArtisticalNum(selectCourseNum.getArtisticalNum() + 1);
                                break;
                        }
                    }
                }
            }
        }
        return selectCourseNum;
    }
    /**
     * 双科数据检测
     * @param methods
     * @return
     */
    public static String checkTwoCourseAnalyze(Methods methods) throws Exception{
        List<String[]> trDataTxt = new ArrayList<String[]>();
        SelectTwoCourseNum selectTwoCourseNum = getSelectTwoCourseNum(methods);
        enterCourseOperate(methods);
        List<WebElement> webElementList = methods.getWebElementList(SelectSubjectElement.DOUBLE_COURSE_TABLE_TR_PATH.getKey(),SelectSubjectElement.DOUBLE_COURSE_TABLE_TR_PATH.getPath());
        for (int i = 1; i <= webElementList.size(); i++) {
            List<WebElement> lists = methods.getWebElementList(SelectSubjectElement.DOUBLE_COURSE_TABLE_TR_PATH.getKey(),SelectSubjectElement.DOUBLE_COURSE_TABLE_TR_PATH.getPath()+"["+i+"]"+"/td");
            String[] trData = new String[3];
            for (int j = 1; j <= lists.size(); j++) {
                trData[j-1] = methods.getWebElement(SelectSubjectElement.DOUBLE_COURSE_TABLE_TR_PATH.getKey(),SelectSubjectElement.DOUBLE_COURSE_TABLE_TR_PATH.getPath()+"["+i+"]"+"/td"+"["+j+"]").getText();
            }
            trDataTxt.add(trData);
            System.out.println(Arrays.toString(trData));
        }
        if (checkDataRight(trDataTxt, selectTwoCourseNum)) {
            return "FIAL";
        }
        return "SUCCESS";
    }

    private static void enterCourseOperate(Methods methods) throws Exception{
        methods.getWebElement(SelectSubjectElement.ICON_BUTTON_SELECT_PATH.getKey(), SelectSubjectElement.ICON_BUTTON_SELECT_PATH.getPath()).click();
        Select yearSelect = methods.getWebSelect(SelectSubjectElement.SELECT_COURSE_YEAR_PLAN_SELECT.getKey(), SelectSubjectElement.SELECT_COURSE_YEAR_PLAN_SELECT.getPath());
        yearSelect.selectByVisibleText("高一");
        Thread.sleep(5000);
        Select taskSelect = methods.getWebSelect(SelectSubjectElement.SELECT_COURSE_PLAN_TASK_SELECT_PATH.getKey(), SelectSubjectElement.SELECT_COURSE_PLAN_TASK_SELECT_PATH.getPath());
        taskSelect.selectByVisibleText("eqwew");
    }

    /**
     * 双科：判断数据是否能够比对上
     * @param trDataTxt
     * @param selectTwoCourseNum
     * @return
     */
    private static boolean checkDataRight(List<String[]> trDataTxt, SelectTwoCourseNum selectTwoCourseNum) {
        for (int i = 0; i < trDataTxt.size(); i++) {
            switch (trDataTxt.get(i)[0]){
                case "生历":
                    if (selectTwoCourseNum.getBiology_histroyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectTwoCourseNum.getBiology_histroyNum() / (float) selectTwoCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "生地":
                    if (selectTwoCourseNum.getBiology_geographyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectTwoCourseNum.getBiology_geographyNum() / (float) selectTwoCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "地历":
                    if (selectTwoCourseNum.getHistroy_geographyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectTwoCourseNum.getHistroy_geographyNum() / (float) selectTwoCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "化生":
                    if (selectTwoCourseNum.getBiology_chemistryNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectTwoCourseNum.getBiology_chemistryNum() / (float) selectTwoCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "化历":
                    if (selectTwoCourseNum.getChemistry_histroyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectTwoCourseNum.getChemistry_histroyNum() / (float) selectTwoCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "物生":
                    if (selectTwoCourseNum.getBiology_physicsNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectTwoCourseNum.getBiology_physicsNum() / (float) selectTwoCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "物地":
                    if (selectTwoCourseNum.getPhysics_geographyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectTwoCourseNum.getPhysics_geographyNum() / (float) selectTwoCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "政历":
                    if (selectTwoCourseNum.getPolitics_histroyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectTwoCourseNum.getPolitics_histroyNum() / (float) selectTwoCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "生政":
                    if (selectTwoCourseNum.getBiology_politicsNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectTwoCourseNum.getBiology_politicsNum() / (float) selectTwoCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "物政":
                    if (selectTwoCourseNum.getPhysics_politicsNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectTwoCourseNum.getPhysics_politicsNum() / (float) selectTwoCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "政地":
                    if (selectTwoCourseNum.getPolitics_geographyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectTwoCourseNum.getPolitics_geographyNum() / (float) selectTwoCourseNum.getSumNum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
    /**
     * 获取选课数据，统计双科数据
     * @param methods
     * @return
     */
    private static SelectTwoCourseNum getSelectTwoCourseNum(Methods methods) throws Exception{
        SelectTwoCourseNum selectCourseNum = new SelectTwoCourseNum();
        Select stuSelectCourseType = methods.getWebSelect(SelectSubjectElement.STUDENT_SELECT_PATH.getKey(), SelectSubjectElement.STUDENT_SELECT_PATH.getPath());
        /**选择检索类型：0，1，2*/
        stuSelectCourseType.selectByValue(String.valueOf(1));
        Thread.sleep(5000);
        String rel_tr_number = methods.getWebElementList(SelectSubjectElement.STUDENT_TR_NUMBER_PATH.getKey(),
                SelectSubjectElement.STUDENT_TR_NUMBER_PATH.getPath()).get(0).getAttribute("innerText");
        String[] list = rel_tr_number.split(" ");
        if (rel_tr_number.equals("共 0 条")) {
            return null;
        }
        int number = Integer.valueOf(list[1]);
        selectCourseNum.setSumNum(number);
        System.out.println(number);
        if (number < 10) {
            int tr_number = methods.getWebElementList(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr").size();
            System.out.println(tr_number);
            for (int i = 1; i <= tr_number; i++) {
                String couresCombinate = methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr[" + i + "]/td[5]").getText();
                checkLogicCourse(selectCourseNum, couresCombinate);
            }
        } else {
            int stuId = number / 10;
            System.out.println(stuId);
            for (int i = 1; i <= stuId + 1; i++) {
                WebElement inputPage = methods.getWebElement(SelectSubjectElement.STUDENT_PAGE_CHANGE_PATH.getKey(), SelectSubjectElement.STUDENT_PAGE_CHANGE_PATH.getPath());
                inputPage.clear();
                inputPage.sendKeys(String.valueOf(i));
                methods.getWebElement(SelectSubjectElement.STUDENT_OK_BUTTON_PATH.getKey(), SelectSubjectElement.STUDENT_OK_BUTTON_PATH.getPath()).click();
                Thread.sleep(3000);
                int tr_number = methods.getWebElementList(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr").size();
                System.out.println(tr_number);
                for (int j = 1; j <= tr_number; j++) {
                    String couresCombinate = methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr[" + j + "]/td[5]").getText();
                    checkLogicCourse(selectCourseNum, couresCombinate);
                }
            }
        }
        return selectCourseNum;
    }
    /**
     * 双科判断逻辑
     * @param selectCourseNum
     * @param couresCombinate
     */
    private static void checkLogicCourse(SelectTwoCourseNum selectCourseNum, String couresCombinate) {
        if (couresCombinate.contains("物理") && couresCombinate.contains("化学")) {
            selectCourseNum.setChemistry_physicsNum(selectCourseNum.getChemistry_physicsNum()+1);
        } if (couresCombinate.contains("物理") && couresCombinate.contains("政治")) {
            selectCourseNum.setPhysics_politicsNum(selectCourseNum.getPhysics_politicsNum()+1);
        } if (couresCombinate.contains("物理") && couresCombinate.contains("地理")){
            selectCourseNum.setPhysics_geographyNum(selectCourseNum.getPhysics_geographyNum()+1);
        } if (couresCombinate.contains("物理") && couresCombinate.contains("历史")) {
            selectCourseNum.setPhysics_histroyNum(selectCourseNum.getPhysics_histroyNum()+1);
        } if (couresCombinate.contains("物理") && couresCombinate.contains("技术")) {
            selectCourseNum.setPhysics_artisticalNum(selectCourseNum.getPhysics_artisticalNum()+1);
        } if (couresCombinate.contains("物理") && couresCombinate.contains("生物")){
            selectCourseNum.setBiology_physicsNum(selectCourseNum.getBiology_physicsNum()+1);
        } if (couresCombinate.contains("化学") && couresCombinate.contains("生物")){
            selectCourseNum.setBiology_chemistryNum(selectCourseNum.getBiology_chemistryNum()+1);
        } if (couresCombinate.contains("化学") && couresCombinate.contains("地理")){
            selectCourseNum.setChemistry_geographyNum(selectCourseNum.getChemistry_geographyNum()+1);
        } if (couresCombinate.contains("化学") && couresCombinate.contains("政治")){
            selectCourseNum.setChemistry_politicsNum(selectCourseNum.getChemistry_politicsNum()+1);
        } if (couresCombinate.contains("化学") && couresCombinate.contains("历史")){
            selectCourseNum.setChemistry_histroyNum(selectCourseNum.getChemistry_histroyNum()+1);
        } if (couresCombinate.contains("化学") && couresCombinate.contains("技术")){
            selectCourseNum.setChemistry_artisticalNum(selectCourseNum.getChemistry_artisticalNum()+1);
        } if (couresCombinate.contains("生物") && couresCombinate.contains("政治")){
            selectCourseNum.setBiology_politicsNum(selectCourseNum.getBiology_politicsNum()+1);
        } if (couresCombinate.contains("生物") && couresCombinate.contains("地理")){
            selectCourseNum.setBiology_geographyNum(selectCourseNum.getBiology_geographyNum()+1);
        } if (couresCombinate.contains("生物") && couresCombinate.contains("历史")){
            selectCourseNum.setBiology_histroyNum(selectCourseNum.getBiology_histroyNum()+1);
        } if (couresCombinate.contains("生物") && couresCombinate.contains("技术")){
            selectCourseNum.setBiology_artisticalNum(selectCourseNum.getBiology_artisticalNum()+1);
        } if (couresCombinate.contains("政治") && couresCombinate.contains("历史")){
            selectCourseNum.setPolitics_histroyNum(selectCourseNum.getPolitics_histroyNum()+1);
        } if (couresCombinate.contains("政治") && couresCombinate.contains("地理")){
            selectCourseNum.setPolitics_geographyNum(selectCourseNum.getPolitics_geographyNum()+1);
        } if (couresCombinate.contains("政治") && couresCombinate.contains("技术")){
            selectCourseNum.setPolitics_artisticalNum(selectCourseNum.getPolitics_artisticalNum()+1);
        } if (couresCombinate.contains("地理") && couresCombinate.contains("历史")){
            selectCourseNum.setHistroy_geographyNum(selectCourseNum.getHistroy_geographyNum()+1);
        } if (couresCombinate.contains("地理") && couresCombinate.contains("技术")){
            selectCourseNum.setGeography_artisticalNum(selectCourseNum.getGeography_artisticalNum()+1);
        } if (couresCombinate.contains("历史") && couresCombinate.contains("技术")){
            selectCourseNum.setHistroy_artisticalNum(selectCourseNum.getHistroy_artisticalNum()+1);
        }
    }
    /**
     * 三科组合数据检测
     * @param methods
     * @return
     */
    public static String checkThreeCourseAnalyse(Methods methods) throws Exception{
        List<String[]> trDataTxt = new ArrayList<String[]>();
        SelectThreeCourseNum selectThreeCourseNum = getSelectThreeCourseNum(methods);
        System.out.println(selectThreeCourseNum.toString());
        enterCourseOperate(methods);
        List<WebElement> webElementList = methods.getWebElementList(SelectSubjectElement.THREE_COURSE_TABLE_TR_PATH.getKey(),SelectSubjectElement.THREE_COURSE_TABLE_TR_PATH.getPath());
        for (int i = 1; i <= webElementList.size(); i++) {
            List<WebElement> lists = methods.getWebElementList(SelectSubjectElement.THREE_COURSE_TABLE_TR_PATH.getKey(),SelectSubjectElement.THREE_COURSE_TABLE_TR_PATH.getPath()+"["+i+"]"+"/td");
            String[] trData = new String[3];
            for (int j = 1; j <= lists.size(); j++) {
                trData[j-1] = methods.getWebElement(SelectSubjectElement.THREE_COURSE_TABLE_TR_PATH.getKey(),SelectSubjectElement.THREE_COURSE_TABLE_TR_PATH.getPath()+"["+i+"]"+"/td"+"["+j+"]").getText();
            }
            trDataTxt.add(trData);
            System.out.println(Arrays.toString(trData));
        }
        if (checkCourseDataRight(trDataTxt, selectThreeCourseNum)) {
            return "FIAL";
        }
        return "SUCCESS";
    }
    /**
     *三科：判断数据是否能够比对上
     * @param trDataTxt
     * @param selectThreeCourseNum
     * @return
     */
    private static boolean checkCourseDataRight(List<String[]> trDataTxt, SelectThreeCourseNum selectThreeCourseNum) {
        for (int i = 0; i < trDataTxt.size(); i++) {
            switch (trDataTxt.get(i)[0]){
                case "物化生":
                    if (selectThreeCourseNum.getPhysics_chemistry_biologyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectThreeCourseNum.getPhysics_chemistry_biologyNum() / (float) selectThreeCourseNum.getStudentSum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "物化政":
                    if (selectThreeCourseNum.getPhysics_chemistry_politicsNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectThreeCourseNum.getPhysics_chemistry_politicsNum() / (float) selectThreeCourseNum.getStudentSum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "物生政":
                    if (selectThreeCourseNum.getPhysics_biology_politicsNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectThreeCourseNum.getPhysics_biology_politicsNum() / (float) selectThreeCourseNum.getStudentSum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "物政地":
                    if (selectThreeCourseNum.getPhysics_politics_geographyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectThreeCourseNum.getPhysics_politics_geographyNum() / (float) selectThreeCourseNum.getStudentSum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "历化政":
                    if (selectThreeCourseNum.getHistroy_chemistry_politicsNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectThreeCourseNum.getHistroy_chemistry_politicsNum() / (float) selectThreeCourseNum.getStudentSum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "历生政":
                    if (selectThreeCourseNum.getHistroy_biology_politicsNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectThreeCourseNum.getHistroy_biology_politicsNum() / (float) selectThreeCourseNum.getStudentSum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "历政地":
                    if (selectThreeCourseNum.getHistroy_politics_geographyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectThreeCourseNum.getHistroy_politics_geographyNum() / (float) selectThreeCourseNum.getStudentSum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "历生地":
                    if (selectThreeCourseNum.getHistroy_biology_geographyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectThreeCourseNum.getHistroy_biology_geographyNum() / (float) selectThreeCourseNum.getStudentSum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "历化地":
                    if (selectThreeCourseNum.getHistroy_chemistry_geographyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectThreeCourseNum.getHistroy_chemistry_geographyNum() / (float) selectThreeCourseNum.getStudentSum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "历化生":
                    if (selectThreeCourseNum.getHistroy_chemistry_biologyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectThreeCourseNum.getHistroy_chemistry_biologyNum() / (float) selectThreeCourseNum.getStudentSum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "物生地":
                    if (selectThreeCourseNum.getPhysics_biology_geographyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectThreeCourseNum.getPhysics_biology_geographyNum() / (float) selectThreeCourseNum.getStudentSum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
                case "物化地":
                    if (selectThreeCourseNum.getPhysics_chemistry_geographyNum() != Integer.valueOf(trDataTxt.get(i)[1])
                            || !(String.format("%.1f", (float) selectThreeCourseNum.getPhysics_chemistry_geographyNum() / (float) selectThreeCourseNum.getStudentSum() * 100)+"%").equals(trDataTxt.get(i)[2])){
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
    /**
     * 获取选课数据：三科数据数量统计
     * @param methods
     * @return
     * @throws Exception
     */
    private static SelectThreeCourseNum getSelectThreeCourseNum(Methods methods) throws Exception{
        SelectThreeCourseNum selectCourseNum = new SelectThreeCourseNum();
        Select stuSelectCourseType = methods.getWebSelect(SelectSubjectElement.STUDENT_SELECT_PATH.getKey(), SelectSubjectElement.STUDENT_SELECT_PATH.getPath());
        /**选择检索类型：0，1，2*/
        stuSelectCourseType.selectByValue(String.valueOf(1));
        Thread.sleep(5000);
        String rel_tr_number = methods.getWebElementList(SelectSubjectElement.STUDENT_TR_NUMBER_PATH.getKey(),
                SelectSubjectElement.STUDENT_TR_NUMBER_PATH.getPath()).get(0).getAttribute("innerText");
        String[] list = rel_tr_number.split(" ");
        if (rel_tr_number.equals("共 0 条")) {
            return null;
        }
        int number = Integer.valueOf(list[1]);
        System.out.println(number);
        selectCourseNum.setStudentSum(number);
        if (number < 10) {
            int tr_number = methods.getWebElementList(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr").size();
            System.out.println(tr_number);
            for (int i = 1; i <= tr_number; i++) {
                String couresCombinate = methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr[" + i + "]/td[5]").getText();
                checkLogicThreeCourse(selectCourseNum, couresCombinate);
            }
        } else {
            int stuId = number / 10;
            System.out.println(stuId);
            for (int i = 1; i <= stuId + 1; i++) {
                WebElement inputPage = methods.getWebElement(SelectSubjectElement.STUDENT_PAGE_CHANGE_PATH.getKey(), SelectSubjectElement.STUDENT_PAGE_CHANGE_PATH.getPath());
                inputPage.clear();
                inputPage.sendKeys(String.valueOf(i));
                methods.getWebElement(SelectSubjectElement.STUDENT_OK_BUTTON_PATH.getKey(), SelectSubjectElement.STUDENT_OK_BUTTON_PATH.getPath()).click();
                Thread.sleep(3000);
                int tr_number = methods.getWebElementList(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr").size();
                System.out.println(tr_number);
                for (int j = 1; j <= tr_number; j++) {
                    String couresCombinate = methods.getWebElement(SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getKey(), SelectSubjectElement.STUDENT_TABLE_LIST_PATH.getPath() + "/tr[" + j + "]/td[5]").getText();
                    checkLogicThreeCourse(selectCourseNum, couresCombinate);
                }
            }
        }
        return selectCourseNum;
    }
    /**
     * 选课组合：三科组合判断逻辑
     * @param selectCourseNum
     * @param couresCombinate
     */
    private static void checkLogicThreeCourse(SelectThreeCourseNum selectCourseNum, String couresCombinate) {
        if (couresCombinate.equals("物理+化学+生物")) {
            selectCourseNum.setPhysics_chemistry_biologyNum(selectCourseNum.getPhysics_chemistry_biologyNum()+1);
        }else if (couresCombinate.equals("物理+化学+政治")) {
            selectCourseNum.setPhysics_chemistry_politicsNum(selectCourseNum.getPhysics_chemistry_politicsNum()+1);
        }else if (couresCombinate.equals("物理+生物+政治")){
            selectCourseNum.setPhysics_biology_politicsNum(selectCourseNum.getPhysics_biology_politicsNum()+1);
        }else if (couresCombinate.equals("物理+政治+地理")) {
            selectCourseNum.setPhysics_politics_geographyNum(selectCourseNum.getPhysics_politics_geographyNum()+1);
        }else if (couresCombinate.equals("历史+化学+政治")) {
            selectCourseNum.setHistroy_chemistry_politicsNum(selectCourseNum.getHistroy_chemistry_politicsNum()+1);
        }else if (couresCombinate.equals("历史+生物+政治")){
            selectCourseNum.setHistroy_biology_politicsNum(selectCourseNum.getHistroy_biology_politicsNum()+1);
        }else if (couresCombinate.equals("历史+政治+地理")){
            selectCourseNum.setHistroy_politics_geographyNum(selectCourseNum.getHistroy_politics_geographyNum()+1);
        }else if (couresCombinate.equals("历史+生物+地理")){
            selectCourseNum.setHistroy_biology_geographyNum(selectCourseNum.getHistroy_biology_geographyNum()+1);
        }else if (couresCombinate.equals("历史+化学+地理")){
            selectCourseNum.setHistroy_chemistry_geographyNum(selectCourseNum.getHistroy_chemistry_geographyNum()+1);
        }else if (couresCombinate.equals("历史+化学+生物")){
            selectCourseNum.setHistroy_chemistry_biologyNum(selectCourseNum.getHistroy_chemistry_biologyNum()+1);
        }else if  (couresCombinate.equals("物理+生物+地理")){
            selectCourseNum.setPhysics_biology_geographyNum(selectCourseNum.getPhysics_biology_geographyNum()+1);
        }else if (couresCombinate.equals("物理+化学+地理")){
            selectCourseNum.setPhysics_chemistry_geographyNum(selectCourseNum.getPhysics_chemistry_geographyNum()+1);
        }
    }
    /**
     * 班级选课数据检测
     * @param methods
     * @return
     */
    public static String checkClassCourseAnalyse(Methods methods){
        return null;
    }
    /**
     * 学科分析跳转到学生列表页面
     * @param methods
     */
    public static String pageChange(Methods methods) {
        methods.getWebElement(SelectSubjectElement.ICON_BUTTON_SELECT_PATH.getKey(),SelectSubjectElement.ICON_BUTTON_SELECT_PATH.getPath()).click();
        methods.getWebElement(SelectSubjectElement.SHOW_STUDENT_LIST_PATH.getKey(),SelectSubjectElement.SHOW_STUDENT_LIST_PATH.getPath()).click();
        /**
         * 获取应用数据按钮文本，证明页面跳转成功
         */
        return methods.getWebElement(SelectSubjectElement.USE_SELECT_COURSE_PATH.getKey(),SelectSubjectElement.USE_SELECT_COURSE_PATH.getPath()).getText();
    }
}
