package com.chenzhi.module.business;

import com.chenzhi.module.util.Methods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;

public class PageTestFunction {

    public static void homePageCompare(Methods methods,String expect_path,String actual_path) throws Exception{
        Thread.sleep(30000);
        File screenshot = ((TakesScreenshot)methods.getDriver()).getScreenshotAs(OutputType.FILE);
        /**对页面进行截屏*/
        FileUtils.copyFile(screenshot, new File(actual_path));

        /***生成了两个文件对象，一个是期望的图片，一个是实际测试过程中产生的图片*/
        File fileInput = new File(expect_path);
        File fileOutPut = new File(actual_path);
        /**
         以下部分为两个文件进行像素比对的算法实现，获取文件的像素个数大小，然后使用循环的方式将两张图片的
         所有项目进行一一对比，如有任何一个像素不相同，则退出循环，将matchFlag变量的值设定为false，
         最后使用断言语句判断matchFlag是否为true。如果为true表示两张图片完全一致，如果为false
         表示两张图片并不是完全匹配
         */
        BufferedImage bufileInput = ImageIO.read(fileInput);

        DataBuffer dafileInput = bufileInput.getData().getDataBuffer();

        int sizefileInput = dafileInput.getSize();

        BufferedImage bufileOutPut = ImageIO.read(fileOutPut);

        DataBuffer dafileOutPut = bufileOutPut.getData().getDataBuffer();

        int sizefileOutPut = dafileOutPut.getSize();

        Boolean matchFlag = true;

        if(sizefileInput == sizefileOutPut){
            for(int j = 0; j<sizefileInput; j ++){
                if(dafileInput.getElem(j) != dafileOutPut.getElem(j)) {
                    matchFlag =  false;
                    break;
                }
            }
        } else {
            matchFlag = false;
            Assert.assertTrue(matchFlag, "测试过程中截图与期望截图不一致");
        }
    }
}
