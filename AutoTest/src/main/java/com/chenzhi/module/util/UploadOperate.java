package com.chenzhi.module.util;

import java.io.IOException;

public class UploadOperate {


    /**
     * 上传文件调研脚本操作
     * @param uploadScriptPath
     * @param browser
     * @param filePath
     */
    public static void uploadFile(String uploadScriptPath, String browser, String filePath) {
        Runtime runtime = Runtime.getRuntime();

        try {

            runtime.exec( uploadScriptPath+ " " + browser + " " + filePath);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
