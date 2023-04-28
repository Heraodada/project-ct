package com.atguigu.ct.consumer.producer.bean;

import com.atguigu.ct.consumer.common.bean.DataIn;

import com.atguigu.ct.consumer.common.bean.DataOut;
import com.atguigu.ct.consumer.common.bean.Producer;
import com.atguigu.ct.consumer.common.util.DateUtil;
import com.atguigu.ct.consumer.common.util.Numberutil;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
本地数据文件生产者
 */
public class LocalFileProducer implements Producer {
    
    private DataIn in;
    private DataOut out;
    private volatile boolean flag = true;

    @Override
    public void setIn(DataIn in) {
        this.in = in;
    }

    @Override
    public void setOut(DataOut out) {
        this.out = out;
    }

    @Override
    public void produce() {

        try {
            //读取通讯录数据
            List<Contact> contacts= in.read(Contact.class);
            while (flag){

                //从通讯录中随机查找2个电话号码（主叫，被叫）
                int call1Index = new Random().nextInt(contacts.size());
                int call2Index ;
                while (true){
                    call2Index = new Random().nextInt(contacts.size());
                    if(call1Index != call2Index){
                        break;
                    }
                }

                Contact call1 = contacts.get(call1Index);
                Contact call2 = contacts.get(call2Index);
                //生成随机的通话时间
                String startDate = "20180101000000";
                String startend = "20190101000000";
                //通话时间
                long startTime = DateUtil.parse(startDate,"yyyyMMddHHmmss").getTime();
                long endTime = DateUtil.parse(startend,"yyyyMMddHHmmss").getTime();
                //通话时间
                long calltime = startTime +(long)((endTime - startTime) * Math.random()) ;
                //通话时间字符串
                String calltimeString = DateUtil.format(new Date(calltime), "yyyyMMddHHmmss");
                //生成通话时长
                String duration = Numberutil.format(new Random().nextInt(3000),4);
                //生成通话记录
                Calllog log = new Calllog(call1.getTel(), call2.getTel(), calltimeString, duration);
                //将通话记录刷写到数据文件中
                out.write(log);
                //System.out.println(log);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //关闭生产者
    @Override
    public void close() throws IOException {
        if (in != null){
            in.close();
        }
        
        if (out != null){
            out.close();
        }
    }
}
