package com.atguigu.ct.consumer.common.bean;

import java.io.Closeable;

/**
 * @Auther:我家二狗子
 * @Date:2022/12/17 22:38)
 * Description
 */
public interface Consumer extends Closeable {
    //消费数据
    public void consume();
}
