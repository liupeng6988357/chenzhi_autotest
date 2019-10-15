import com.chenzhi.module.util.FileOperate;
import com.chenzhi.module.util.ReadExcel;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {

    @Test
    public void test(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        System.out.println(df.format(new Date().getTime()+3000000));// new Date()为获取当前系统时间
    }

    @Test
    public void test1() throws Exception{
        //路径   这里写一个路径进去
        String path="C:\\Users\\EDZ\\Downloads";
        //调用方法
        ReadExcel.getExcelRowsXlsx("C:\\Users\\EDZ\\Downloads\\学生选课列表20191015144140.xlsx","学生选课详情");
    }
}
