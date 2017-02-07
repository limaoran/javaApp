package com.rr.designmodel.observer;

/**
 * 演示使用JDK自带的Observer
 * Created by Limaoran on 2016/11/16.
 */
public class Test10 {
    public static void main(String[] args) {
        Person person = new Person();
        // 注册观察者
        person.addObserver(new MyObserver());
        person.addObserver(new MyObserver());
        System.out.println(person.countObservers());

        person.setName("李明");
        System.out.println(person.countObservers());
        person.setAge(21);
        person.setSex("男");
    }
}
