package com.atguigu.ct.consumer.bean;

import com.atguigu.ct.consumer.common.bean.Consumer;
import com.atguigu.ct.consumer.common.constant.Names;
import com.atguigu.ct.consumer.dao.HBaseDao;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
通话日志消费者对象
 * Description
 */
public class CalllogConsumer implements Consumer {
    //消费数据
    @Override
    public void consume() {


        try {
            //创建配置对象
//            Properties properties = new Properties();
//            //连接
//            properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"master:9092,s1:9092");
//            //反序列化
//            properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//            properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
//            //配置消费者id
//            properties.put(ConsumerConfig.GROUP_ID_CONFIG,"test3");
//            //获取flume采集的数据
//            KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(properties);
            // 创建配置对象
            Properties prop = new Properties();
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("consumer.properties"));

            // 获取flume采集的数据
            KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(prop);

            //关注主题：
            consumer.subscribe(Arrays.asList(Names.TOPIC.getValue()));

            HBaseDao dao = new HBaseDao();
            dao.init();


            //消费数据
            while (true){
                ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    System.out.println(consumerRecord.value());
                    //插入数据
                    dao.insertData(consumerRecord.value());
//                    Calllog log = new Calllog(consumerRecord.value());
//                    dao.insertData(log);
                }
            }
        } catch (Exception e) {


        }


    }

    @Override
    public void close() throws IOException {

    }
    //关闭资源

}
