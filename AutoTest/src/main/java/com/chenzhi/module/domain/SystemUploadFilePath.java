package com.chenzhi.module.domain;

public enum SystemUploadFilePath {

    /**上传脚本路径*/
    UPLOAD_FILE_SCRIPT_PATH("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\test_file\\uploadstudent.exe"),
    /**学生附件路径*/
    STUDENT_FILE_PATH("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\test_file\\students.xls"),
    /**老师附件路径*/
    Teacher_FILE_PATH("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\test_file\\teachers.xls")
    ;



    private final String path;

    SystemUploadFilePath(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
