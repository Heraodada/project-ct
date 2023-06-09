package com.atguigu.ct.consumer.common.constant;

import com.atguigu.ct.consumer.common.bean.Val;

/**
 名称常量枚举类
 */
public enum Names implements Val {
    NAMESPACE("ct")
    ,TABLE("ct:calllog")
    ,CF_CALLER("caller")
    ,CF_CALLEE("callee")
    ,CF_INFO("info")
    ,TOPIC("ct");

    private String name;
    private Names(String name){
        this.name=name;
    }


    @Override
    public void setValue(Object val) {
        this.name = (String)val;
    }

    @Override
    public String getValue() {
        return name;
    }
}
