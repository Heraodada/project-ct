package com.atguigu.ct.consumer.producer.io;

import com.atguigu.ct.consumer.common.bean.DataOut;

import java.io.*;

/**
 本地文件数据输入
 */
public class LocalFileDataOut implements DataOut {

    private PrintWriter writer = null;

    public LocalFileDataOut (String path){
        setPath(path);
    }
    @Override
    public void setPath(String path) {
        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Object data) throws Exception {
        write(data.toString());
    }

    //将数字字符串生成到文件中
    @Override
    public void write(String data) throws Exception {
        writer.println(data);
        writer.flush();
    }

    //释放资源
    @Override
    public void close() throws IOException {
        if(writer != null){
            writer.close();
        }
    }
}
