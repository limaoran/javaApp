package com.rr.designmodel.singleton;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Person3 {

    private static Person3 person;
    private Person3(){}
    public synchronized static Person3 getPerson(){
        if(person == null){
            person = new Person3();
        }
        return person;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
