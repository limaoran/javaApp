package com.rr.designmodel.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Test06 {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("lifengxing");
        person1.setAge(30);
        person1.setSex("男");

//        Person person2 = person1;
        Person person2 = person1.clone();
        System.out.println(person1.getName());
        System.out.println(person1.getAge());
        System.out.println(person1.getSex());

        System.out.println(person2.getName());
        System.out.println(person2.getAge());
        System.out.println(person2.getSex());


        Person person3 = new Person();
        List<String> friends = new ArrayList<String>();
        friends.add("James");
        friends.add("Yao");
        person3.setFriends(friends);

        Person person4 = person3.clone();
        System.out.println(person3.getFriends());
        System.out.println(person4.getFriends());

        friends.add("Mike");
        person3.setFriends(friends);
        // 这里可以验证 克隆对象是深克隆还是浅克隆！
        // 如果两个值一样，浅克隆！
        System.out.println(person3.getFriends());
        System.out.println(person4.getFriends());
    }
}
