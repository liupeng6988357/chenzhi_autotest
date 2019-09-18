import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {

    @Test
    public void test(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        System.out.println(df.format(new Date().getTime()+3000000));// new Date()为获取当前系统时间
    }
}
