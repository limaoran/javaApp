package com.rr.designmodel.flyweight.news;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class Teacher extends Person {
    private String number;

    public Teacher(){
        super();
    }

    public Teacher(String name, String sex, int age, String number) {
        super(name, sex, age);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
