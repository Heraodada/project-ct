package com.atguigu.ct.consumer;

import com.atguigu.ct.consumer.common.bean.Consumer;
import com.atguigu.ct.consumer.bean.CalllogConsumer;

import java.io.IOException;

/**
启动消费者
 //使用kafka消费者获取Flume采集的数据
 //将数据存储到hbase中去
 */
public class Bootstrap {
    //public final static String ABC = "ABC";
    public static void main(String[] args) throws IOException {
        //创建消费者
        Consumer consumer =  new CalllogConsumer();
        //消费数据
        consumer.consume();
        //关闭资源
        consumer.close();


    }
}
