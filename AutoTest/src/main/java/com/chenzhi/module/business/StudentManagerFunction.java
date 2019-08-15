package com.chenzhi.module.business;

import com.chenzhi.module.domain.Base_StudentManagerPageElement;
import com.chenzhi.module.util.Methods;

import java.io.IOException;

public class StudentManagerFunction {

    /**上传文件*/
    public static String uploadStudentS(Methods methods) throws Exception{

        methods.getWebElement(Base_StudentManagerPageElement.UPLOAD_STUDENT_INFORMATION_XPATH.getKey(), Base_StudentManagerPageElement.UPLOAD_STUDENT_INFORMATION_XPATH.getPath()).click();

        methods.getWebElement(Base_StudentManagerPageElement.UPLOAD_FILE_XPATH.getKey(), Base_StudentManagerPageElement.UPLOAD_FILE_XPATH.getPath()).click();

        Runtime runtime = Runtime.getRuntime();

        try {

             runtime.exec("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\test_file\\uploadstudent.exe" + " "
                     + "chrome" + " " + "D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\test_file\\students.xls");

        } catch (IOException e) {

            e.printStackTrace();
        }

        

        Thread.sleep(10000);

        String resultText =methods.getWebElement(Base_StudentManagerPageElement.STUDENT_SUM_NUMBER_ID.getKey(),Base_StudentManagerPageElement.STUDENT_SUM_NUMBER_ID.getPath()).getText();

        return resultText;
    }
}
