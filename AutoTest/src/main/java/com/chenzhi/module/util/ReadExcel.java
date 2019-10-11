package com.chenzhi.module.util;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadExcel {


        // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
        public List readExcel(File file) {
            try {
                // 创建输入流，读取Excel
                InputStream is = new FileInputStream(file.getAbsolutePath());
                // jxl提供的Workbook类
                Workbook wb = Workbook.getWorkbook(is);
                // Excel的页签数量
                int sheet_size = wb.getNumberOfSheets();
                for (int index = 0; index < sheet_size; index++) {
                    List<List> outerList=new ArrayList<List>();
                    // 每个页签创建一个Sheet对象
                    Sheet sheet = wb.getSheet(index);
                    // sheet.getRows()返回该页的总行数
                    for (int i = 0; i < sheet.getRows(); i++) {
                        List innerList=new ArrayList();
                        // sheet.getColumns()返回该页的总列数
                        for (int j = 0; j < sheet.getColumns(); j++) {
                            String cellinfo = sheet.getCell(j, i).getContents();
                            if(cellinfo.isEmpty()){
                                continue;
                            }
                            innerList.add(cellinfo);
                            System.out.print(cellinfo);
                        }
                        outerList.add(i, innerList);
                        System.out.println();
                    }
                    return outerList;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    /**
     * 统计excel表格的总行数
     * @param filePath
     * @param sheetName
     * @return
     * @throws Exception
     */
        public static int getExcelRows(String filePath,String sheetName) throws Exception{

            File file = new File(filePath);

            /**创建输入流，读取Excel*/
            InputStream is = new FileInputStream(file.getAbsolutePath());

            /** jxl提供的Workbook类 */
            Workbook wb = Workbook.getWorkbook(is);

            /** Excel的页签*/
            Sheet sheet = wb.getSheet(sheetName);

            /**获取sheet行数*/
            return sheet.getRows();
        }

}

