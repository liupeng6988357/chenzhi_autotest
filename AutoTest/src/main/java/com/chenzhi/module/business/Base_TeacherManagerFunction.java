package com.chenzhi.module.business;


import com.chenzhi.module.domain.Base_TeacherManagerPageElement;
import com.chenzhi.module.domain.SystemUploadFilePath;
import com.chenzhi.module.util.Methods;
import com.chenzhi.module.util.UploadOperate;

public class Base_TeacherManagerFunction {

    /**上传文件*/
    public static String uploadStudentS(Methods methods) throws Exception{

        methods.getWebElement(Base_TeacherManagerPageElement.UPLOAD_TEACHER_INFORMATION_XPATH.getKey(), Base_TeacherManagerPageElement.UPLOAD_TEACHER_INFORMATION_XPATH.getPath()).click();

        methods.getWebElement(Base_TeacherManagerPageElement.UPLOAD_FILE_XPATH.getKey(), Base_TeacherManagerPageElement.UPLOAD_FILE_XPATH.getPath()).click();

        /**附件上传执行脚本*/
        UploadOperate.uploadFile(SystemUploadFilePath.UPLOAD_FILE_SCRIPT_PATH.getPath(),"chrome",SystemUploadFilePath.Teacher_FILE_PATH.getPath());

        Thread.sleep(10000);

        /**关闭上传附件框*/
        methods.getWebElement(Base_TeacherManagerPageElement.TEACHER_UPLOAD_PAGE_CLOSE_BUTTON_XPATH.getKey(),Base_TeacherManagerPageElement.TEACHER_UPLOAD_PAGE_CLOSE_BUTTON_XPATH.getPath()).click();

        Thread.sleep(20000);

        /**获取总记录条数*/
        String resultText =methods.getWebElement(Base_TeacherManagerPageElement.TEACHER_SUM_NUMBER_XPATH.getKey(),Base_TeacherManagerPageElement.TEACHER_SUM_NUMBER_XPATH.getPath()).getText();

        return resultText;
    }
}
