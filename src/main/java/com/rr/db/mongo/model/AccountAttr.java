package com.rr.db.mongo.model;

/**
 * 账户附加属性，测试辅助类
 * Created by Limaoran on 2016/9/27.
 */
public class AccountAttr {
    /** 电子邮件 */
    private String email;
    private int age;
    private int sex;
    private String addr;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
}
