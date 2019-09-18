package com.chenzhi.module.business;

import com.chenzhi.module.domain.LoginPageElement;
import com.chenzhi.module.util.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginFunction {

    /**老师登录操作执行*/
    public static void teacherLoginTest(Methods methods, String userName, String password){

        methods.getWebElement(LoginPageElement.TEACHER_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.TEACHER_BTN_LOGIN_LINK_XPATH.getPath()).click();

        try{
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        methods.getWebElement(LoginPageElement.USERNAME_INPUT_XPATH.getKey(),LoginPageElement.USERNAME_INPUT_XPATH.getPath()).sendKeys(userName);

        methods.getWebElement(LoginPageElement.PASSWORD_INPUT_XPATH.getKey(),LoginPageElement.PASSWORD_INPUT_XPATH.getPath()).sendKeys(password);

        methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).click();

    }

    /**学生登录操作执行*/
    public static void studentLoginTest(Methods methods,String username, String password) {

        methods.getWebElement(LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getPath()).click();

        methods.getWebElement(LoginPageElement.USERNAME_INPUT_XPATH.getKey(),LoginPageElement.USERNAME_INPUT_XPATH.getPath()).sendKeys(username);

        methods.getWebElement(LoginPageElement.PASSWORD_INPUT_XPATH.getKey(),LoginPageElement.PASSWORD_INPUT_XPATH.getPath()).sendKeys(password);

        methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).click();
    }

    /**学生id登录操作执行*/
    public static void studentIDLoginExcute(Methods methods,String[] params) throws Exception{
        methods.getWebElement(LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getPath()).click();

        methods.getWebElement(LoginPageElement.STUDENT_IDLOGIN_LINK_XPATH.getKey(),LoginPageElement.STUDENT_IDLOGIN_LINK_XPATH.getPath()).click();

        Thread.sleep(5000);

        methods.getWebSelect(LoginPageElement.PROVINCE_SELECT_XPATH.getKey(),LoginPageElement.PROVINCE_SELECT_XPATH.getPath()).selectByVisibleText(params[0]);

        Thread.sleep(1000);

        methods.getWebSelect(LoginPageElement.CITY_SELECT_XPATH.getKey(),LoginPageElement.CITY_SELECT_XPATH.getPath()).selectByVisibleText(params[1]);

        Thread.sleep(1000);

        methods.getWebSelect(LoginPageElement.COUNTY_SELECT_XPATH.getKey(),LoginPageElement.COUNTY_SELECT_XPATH.getPath()).selectByVisibleText(params[2]);

        Thread.sleep(1000);

        methods.getWebSelect(LoginPageElement.SCHOOL_SELECT_XPATH.getKey(),LoginPageElement.SCHOOL_SELECT_XPATH.getPath()).selectByVisibleText(params[3]);

        methods.getWebElement(LoginPageElement.STUDENT_ID_INPUT_XPATH.getKey(),LoginPageElement.STUDENT_ID_INPUT_XPATH.getPath()).sendKeys(params[4]);

        methods.getWebElement(LoginPageElement.STUDENT_PASSWORD_INPUT_XPATH.getKey(),LoginPageElement.STUDENT_PASSWORD_INPUT_XPATH.getPath()).sendKeys(params[5]);

        methods.getWebElement(LoginPageElement.LOGIN_BTN_CLASSNAME.getKey(),LoginPageElement.LOGIN_BTN_CLASSNAME.getPath()).click();

    }
    /**获取省份下拉框值集*/
    public static List<String> getProvinceValues(Methods methods) throws Exception{

        List<String> list = new ArrayList<String>();

        methods.getWebElement(LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getKey(),LoginPageElement.STUDENT_BTN_LOGIN_LINK_XPATH.getPath()).click();

        methods.getWebElement(LoginPageElement.STUDENT_IDLOGIN_LINK_XPATH.getKey(),LoginPageElement.STUDENT_IDLOGIN_LINK_XPATH.getPath()).click();

        Thread.sleep(5000);

        Select provinceSelect = methods.getWebSelect(LoginPageElement.PROVINCE_SELECT_XPATH.getKey(),LoginPageElement.PROVINCE_SELECT_XPATH.getPath());

        List<WebElement> provinceValuesList = provinceSelect.getOptions();

        for (int i = 0; i < provinceValuesList.size(); i++){
            String province = provinceValuesList.get(i).getText();
            list.add(province);
        }

        return list;
    }

    /**获取省份对应的城市下拉框值集*/
    public static Map<String,List<String>> getCityValues(Methods methods) throws Exception{

        Map<String,List<String>> map = new HashMap<String, List<String>>();

        List<String> provinceList = getProvinceValues(methods);

        for (int i = 0; i < provinceList.size(); i++) {

            methods.getWebSelect(LoginPageElement.PROVINCE_SELECT_XPATH.getKey(),LoginPageElement.PROVINCE_SELECT_XPATH.getPath()).selectByVisibleText(provinceList.get(i));

            Select citySelect = methods.getWebSelect(LoginPageElement.CITY_SELECT_XPATH.getKey(),LoginPageElement.CITY_SELECT_XPATH.getPath());

            Thread.sleep(1000);

            List<WebElement> cityeValuesList = citySelect.getOptions();

            List<String> cityList = new ArrayList<String>();

            for (int j = 0; j < cityeValuesList.size(); j++){
                String city = cityeValuesList.get(j).getText();
                cityList.add(city);
            }
            map.put(provinceList.get(i),cityList);
        }
        return map;
    }

    /**获取城市对应的县区下拉框值集：<省份<城市，<县区，，，，>>*/
    public static Map<String,Map<String,List<String>>> getCountyValues(Methods methods) throws Exception{

        Map<String,Map<String,List<String>>> map = new HashMap<String,Map<String,List<String>>>();

        Map<String,List<String>> cityValuesMap = getCityValues(methods);

        for (Map.Entry<String,List<String>> entry : cityValuesMap.entrySet()) {

            methods.getWebSelect(LoginPageElement.PROVINCE_SELECT_XPATH.getKey(),LoginPageElement.PROVINCE_SELECT_XPATH.getPath()).selectByVisibleText(entry.getKey());

            Map<String,List<String>> cc_map = new HashMap<String, List<String>>();

            for (int i = 0; i <entry.getValue().size() ; i++) {

                methods.getWebSelect(LoginPageElement.CITY_SELECT_XPATH.getKey(),LoginPageElement.CITY_SELECT_XPATH.getPath()).selectByVisibleText(entry.getValue().get(i));

                Thread.sleep(1000);

                Select citySelect = methods.getWebSelect(LoginPageElement.COUNTY_SELECT_XPATH.getKey(),LoginPageElement.COUNTY_SELECT_XPATH.getPath());

                List<WebElement> countyeValuesList = citySelect.getOptions();

                List<String> list = new ArrayList<String>();

                for (int j = 0; j < countyeValuesList.size(); j++) {

                    String county =  countyeValuesList.get(j).getText();

                    list.add(county);

                }

                cc_map.put(entry.getValue().get(i),list);

            }

            map.put(entry.getKey(),cc_map);

        }

        return map;
    }

    /**获取学校下拉框值集*/
    public static Map<String,Map<String,Map<String,List<String>>>> getSchoolValues(Methods methods) throws Exception{

        Map<String,Map<String,List<String>>> countyValuesMap = getCountyValues(methods);

        for (Map.Entry<String,Map<String,List<String>>> entry : countyValuesMap.entrySet()) {

            methods.getWebSelect(LoginPageElement.PROVINCE_SELECT_XPATH.getKey(),LoginPageElement.PROVINCE_SELECT_XPATH.getPath()).selectByVisibleText(entry.getKey());

            Thread.sleep(2000);

            System.out.println("----------province = "+entry.getKey()+"---------");
            for (Map.Entry<String,List<String>> maps : entry.getValue().entrySet()) {

                methods.getWebSelect(LoginPageElement.CITY_SELECT_XPATH.getKey(),LoginPageElement.CITY_SELECT_XPATH.getPath()).selectByVisibleText(maps.getKey());

                Thread.sleep(2000);

                System.out.println("*****city = "+ maps.getKey()+"*****");
                for (int i = 0; i < maps.getValue().size(); i++) {

                    methods.getWebSelect(LoginPageElement.COUNTY_SELECT_XPATH.getKey(),LoginPageElement.COUNTY_SELECT_XPATH.getPath()).selectByVisibleText(maps.getValue().get(i));

                    Thread.sleep(2000);

                    Select schoolSelect = methods.getWebSelect(LoginPageElement.SCHOOL_SELECT_XPATH.getKey(),LoginPageElement.SCHOOL_SELECT_XPATH.getPath());

                    List<WebElement> schooleValuesList = schoolSelect.getOptions();

                    System.out.println("*****county = "+maps.getValue().get(i)+"****");

                    for (int j = 0; j < schooleValuesList.size(); j++) {

                        String school =  schooleValuesList.get(j).getText();

                        System.out.println(school);

                    }

                }
            }

        }
        return null;
    }

}
