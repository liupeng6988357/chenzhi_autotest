package com.chenzhi.module.system_interface;


import com.chenzhi.module.util.Methods;

public interface UploadFiles {

     String uploadTeachers(Methods methods) throws Exception;

     String uploadStudents(Methods methods) throws Exception;

     String uploadGrades(Methods methods) throws Exception;

     String uploadCourse(Methods methods) throws Exception;

     String uploadClassAddress(Methods methods) throws Exception;

     String uploadTeacherAndTime(Methods methods) throws  Exception;
}
