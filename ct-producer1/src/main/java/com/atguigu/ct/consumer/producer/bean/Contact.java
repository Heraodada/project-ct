package com.atguigu.ct.consumer.producer.bean;

import com.atguigu.ct.consumer.common.bean.Data;


/**
 联系人
 */
public class Contact extends Data {
    private String tel;
    private String name;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setValue(Object val){
        content = (String) val;
        String[] valus = content.split("\t");


        setTel(valus[0]);
        setName(valus[1]);
    }

    public String toString(){
        return "Contact["+tel+","+name+"]";
    }

}
