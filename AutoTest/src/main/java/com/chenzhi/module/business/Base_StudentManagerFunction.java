package com.chenzhi.module.business;

import com.chenzhi.module.domain.Base_StudentManagerPageElement;
import com.chenzhi.module.domain.SystemUploadFilePath;
import com.chenzhi.module.util.Methods;
import com.chenzhi.module.util.UploadOperate;

public class Base_StudentManagerFunction {

    /**上传文件*/
    public static String uploadStudentS(Methods methods) throws Exception{

        methods.getWebElement(Base_StudentManagerPageElement.UPLOAD_STUDENT_INFORMATION_XPATH.getKey(), Base_StudentManagerPageElement.UPLOAD_STUDENT_INFORMATION_XPATH.getPath()).click();

        methods.getWebElement(Base_StudentManagerPageElement.UPLOAD_FILE_XPATH.getKey(), Base_StudentManagerPageElement.UPLOAD_FILE_XPATH.getPath()).click();

        /**附件上传执行脚本*/
        UploadOperate.uploadFile(SystemUploadFilePath.UPLOAD_FILE_SCRIPT_PATH.getPath(),"chrome",SystemUploadFilePath.STUDENT_FILE_PATH.getPath());

        Thread.sleep(10000);

        /**关闭上传附件框*/
        methods.getWebElement(Base_StudentManagerPageElement.STUDENT_UPLOAD_PAGE_CLOSE_BUTTON_XPATH.getKey(),Base_StudentManagerPageElement.STUDENT_UPLOAD_PAGE_CLOSE_BUTTON_XPATH.getPath()).click();

        Thread.sleep(10000);

        /**获取总记录条数*/
        String resultText =methods.getWebElement(Base_StudentManagerPageElement.STUDENT_SUM_NUMBER_XPATH.getKey(),Base_StudentManagerPageElement.STUDENT_SUM_NUMBER_XPATH.getPath()).getText();

        return resultText;
    }

}
