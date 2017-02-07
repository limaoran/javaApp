package com.rr.designmodel.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Person implements Cloneable{
    // 姓名
    private String name;
    // 年龄
    private int age;
    // 性别
    private String sex;
    // 朋友
    private List<String> friends;

    @Override
    protected Person clone() {
        try {
            // 默认浅克隆
//            return (Person) super.clone();
            // 实现深克隆
            Person person = (Person) super.clone();
            if(this.getFriends()!=null) {
                List<String> newfriends = new ArrayList<String>();
                for (String friend : this.getFriends()) {
                    newfriends.add(friend);
                }
                person.setFriends(newfriends);
            }
            return person;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}
