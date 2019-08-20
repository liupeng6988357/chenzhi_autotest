package com.chenzhi.module.domain;

public enum SystemUploadFilePath {

    /**上传脚本路径*/
    UPLOAD_FILE_SCRIPT_PATH("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\test_file\\uploadstudent.exe"),
    /**学生附件路径*/
    STUDENT_FILE_PATH("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\test_file\\students.xls"),
    /**老师附件路径*/
    Teacher_FILE_PATH("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\test_file\\teachers.xls"),
    /**成绩附件路径*/
    SCORE_FILE_PATH("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\test_file\\scores.xls"),
    /**课程附件路径*/
    COURSE_FILE_PATH("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\test_file\\course.xls"),
    /**教室附件路径*/
    ADDRESS_FILR_PATH("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\test_file\\address.xls")
    ;



    private final String path;

    SystemUploadFilePath(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
