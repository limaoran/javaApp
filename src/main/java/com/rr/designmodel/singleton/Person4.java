package com.rr.designmodel.singleton;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Person4 {

    private static Person4 person = null;
    public static Person4 getPerson(){
        if(person==null){
            synchronized (Person4.class){
                if(person==null){
                    person = new Person4();
                }
            }
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
