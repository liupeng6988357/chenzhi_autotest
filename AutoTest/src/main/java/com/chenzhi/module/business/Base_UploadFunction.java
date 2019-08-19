package com.chenzhi.module.business;


import com.chenzhi.module.domain.Base_ManagerElement;
import com.chenzhi.module.domain.SystemUploadFilePath;
import com.chenzhi.module.system_interface.UploadFiles;
import com.chenzhi.module.util.Methods;
import com.chenzhi.module.util.UploadOperate;

public class Base_UploadFunction implements UploadFiles {


    /**上传老师数据*/
    @Override
    public String uploadTeachers(Methods methods) throws Exception {

        methods.getWebElement(Base_ManagerElement.UPLOAD_TEACHER_INFORMATION_XPATH.getKey(), Base_ManagerElement.UPLOAD_TEACHER_INFORMATION_XPATH.getPath()).click();

        methods.getWebElement(Base_ManagerElement.UPLOAD_FILE_XPATH.getKey(), Base_ManagerElement.UPLOAD_FILE_XPATH.getPath()).click();

        /**附件上传执行脚本*/
        UploadOperate.uploadFile(SystemUploadFilePath.UPLOAD_FILE_SCRIPT_PATH.getPath(),"chrome",SystemUploadFilePath.Teacher_FILE_PATH.getPath());

        Thread.sleep(10000);

        /**关闭上传附件框*/
        methods.getWebElement(Base_ManagerElement.TEACHER_UPLOAD_PAGE_CLOSE_BUTTON_XPATH.getKey(), Base_ManagerElement.TEACHER_UPLOAD_PAGE_CLOSE_BUTTON_XPATH.getPath()).click();

        Thread.sleep(20000);

        /**获取总记录条数*/
        String resultText =methods.getWebElement(Base_ManagerElement.TEACHER_SUM_NUMBER_XPATH.getKey(), Base_ManagerElement.TEACHER_SUM_NUMBER_XPATH.getPath()).getText();

        return resultText;
    }

    /**上传学生数据*/
    @Override
    public String uploadStudents(Methods methods) throws Exception {

        methods.getWebElement(Base_ManagerElement.UPLOAD_STUDENT_INFORMATION_XPATH.getKey(), Base_ManagerElement.UPLOAD_STUDENT_INFORMATION_XPATH.getPath()).click();

        methods.getWebElement(Base_ManagerElement.UPLOAD_FILE_XPATH.getKey(), Base_ManagerElement.UPLOAD_FILE_XPATH.getPath()).click();

        /**附件上传执行脚本*/
        UploadOperate.uploadFile(SystemUploadFilePath.UPLOAD_FILE_SCRIPT_PATH.getPath(),"chrome",SystemUploadFilePath.STUDENT_FILE_PATH.getPath());

        Thread.sleep(10000);

        /**关闭上传附件框*/
        methods.getWebElement(Base_ManagerElement.STUDENT_UPLOAD_PAGE_CLOSE_BUTTON_XPATH.getKey(), Base_ManagerElement.STUDENT_UPLOAD_PAGE_CLOSE_BUTTON_XPATH.getPath()).click();

        Thread.sleep(10000);

        /**获取总记录条数*/
        String resultText =methods.getWebElement(Base_ManagerElement.STUDENT_SUM_NUMBER_XPATH.getKey(), Base_ManagerElement.STUDENT_SUM_NUMBER_XPATH.getPath()).getText();

        return resultText;
    }

    /**上传成绩数据*/
    @Override
    public String uploadGrades(Methods methods) throws Exception {
        return null;
    }

    /**上传课程数据*/
    @Override
    public String uploadCourse(Methods methods) throws Exception {
        return null;
    }

    /**上传教室数据*/
    @Override
    public String uploadClassAddress(Methods methods) throws Exception {
        return null;
    }

    /**上传老师及课时安排*/
    @Override
    public String uploadTeacherAndTime(Methods methods) throws Exception {
        return null;
    }

}
