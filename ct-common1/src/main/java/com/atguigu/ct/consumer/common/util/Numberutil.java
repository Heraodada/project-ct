package com.atguigu.ct.consumer.common.util;

import java.text.DecimalFormat;

/**
 * @Auther:我家二狗子
 * @Date:2022/12/17 16:59)
 * Description
 */
public class Numberutil {

    public static String format(int num,int length){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i =1;i <= length;i++){
            stringBuilder.append("0");
        }
        DecimalFormat df = new DecimalFormat(stringBuilder.toString());
        return df.format(num);
    }


}
