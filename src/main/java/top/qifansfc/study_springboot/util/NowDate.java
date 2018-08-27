package top.qifansfc.study_springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取当前日期
 */
public class NowDate {
    public static String getNowDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        return df.format(new Date());
    }
}
