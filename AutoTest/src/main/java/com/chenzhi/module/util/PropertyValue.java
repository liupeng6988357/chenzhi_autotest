package com.chenzhi.module.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyValue {

        public static String getValue(String key){

            Properties prop=new Properties();

            try {
                prop.load(new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream("D:\\chenzhi_autotest\\AutoTest\\src\\main\\resources\\testcasedescription.properties")),"gbk"));
            }catch (Exception e){
                e.fillInStackTrace();
            }

            return prop.getProperty(key);
        }

    }

