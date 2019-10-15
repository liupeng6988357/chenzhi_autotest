package com.chenzhi.module.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileOperate {

    /**
     * 递归获取某路径下的所有文件，文件夹，并输出
     */
    public static List<String> getFiles(String path) {

        List<String> pathList = new ArrayList<String>();
        File file = new File(path);
        // 如果这个路径是文件夹
        if (file.isDirectory()) {
            // 获取路径下的所有文件
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                // 如果还是文件夹 递归获取里面的文件 文件夹
                if (files[i].isDirectory()) {
                    getFiles(files[i].getPath());
                } else {
                    pathList.add(files[i].getPath());
                }

            }
        } else {
            pathList.add(file.getPath());
        }
        return pathList;
    }
}
