package com.rr.designmodel.singleton;

/**
 * 饿汉式单例实现
 * Created by Limaoran on 2016/11/16.
 */
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // 构造函数私有化
    private Person(){}
    private static Person person = new Person();

    // 提供一个全局的静态方法
    public static Person getPerson(){
        return person;
    }
}
