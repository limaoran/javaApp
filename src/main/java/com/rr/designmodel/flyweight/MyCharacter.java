package com.rr.designmodel.flyweight;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class MyCharacter {
    private char myChar;

    public MyCharacter(char myChar) {
        this.myChar = myChar;
    }
    public void display(){
        System.out.println(myChar);
    }
}
