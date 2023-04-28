package com.atguigu.ct.consumer.common.bean;

import java.io.Closeable;

/**
数据流向
 */
public interface DataOut extends Closeable {
    public void setPath(String path);
    public void write(Object data) throws Exception;
    public void write(String data) throws Exception;
}
