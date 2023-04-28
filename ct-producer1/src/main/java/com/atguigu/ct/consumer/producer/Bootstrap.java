package com.atguigu.ct.consumer.producer;

import com.atguigu.ct.consumer.common.bean.Producer;
import com.atguigu.ct.consumer.producer.bean.LocalFileProducer;
import com.atguigu.ct.consumer.producer.io.LocalFileDataIn;
import com.atguigu.ct.consumer.producer.io.LocalFileDataOut;

import java.io.IOException;

/**
启动对象
 */
public class Bootstrap {
    public static void main(String[] args) throws IOException {
//        if (args.length<2){
//            System.out.println("系统参数不正确，请按照指定格式传递：java -jar Produce.jar");
//            System.exit(1);
//        }
        //构建生产者
        Producer producer = new LocalFileProducer();
        producer.setIn(new LocalFileDataIn("D:\\pr\\项目\\电信客服\\2.资料\\辅助文档\\contact.log"));
        producer.setOut(new LocalFileDataOut("D:\\pr\\项目\\电信客服\\2.资料\\辅助文档\\call.log"));

//        producer.setIn(new LocalFileDataIn(args[0]));
//        producer.setOut(new LocalFileDataOut(args[1]));

        //生产数据
        producer.produce();
        //关闭生产者对象
        producer.close();
    }
}
