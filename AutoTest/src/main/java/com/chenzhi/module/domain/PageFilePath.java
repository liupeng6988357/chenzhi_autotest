package com.chenzhi.module.domain;

public enum PageFilePath {

    /**homepage_execpt*/
    HOME_PAGE_EXPECT_PATH("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\page_file\\except_page\\homepage_except.jpg"),
    /**homepage_actual*/
    HOME_PAGE_ACTUAL_PATH("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\page_file\\actual_page\\homepage_actual.jpg"),
    ;



    private final String path;

    PageFilePath(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
