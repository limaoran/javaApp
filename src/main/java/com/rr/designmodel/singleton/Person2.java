package com.rr.designmodel.singleton;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Person2 {

    private static Person2 person = null;

    public static Person2 getPerson(){
        if(person==null){
            person = new Person2();
        }
        return person;
    }
    private Person2(){}

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
