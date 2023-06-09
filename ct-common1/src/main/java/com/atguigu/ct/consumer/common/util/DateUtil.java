package com.atguigu.ct.consumer.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 日期工具类
 */
public class DateUtil {
    //将指定日期按照指定格式格式化为字符串
    public static String format(Date date,String format){
        SimpleDateFormat dfs = new SimpleDateFormat(format);
        return  dfs.format(date);

    }

    //将日期字符串按照指定的格式解析为日期对象
    public static Date parse(String dateString,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
