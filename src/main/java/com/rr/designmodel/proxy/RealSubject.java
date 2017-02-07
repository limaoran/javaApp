package com.rr.designmodel.proxy;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class RealSubject implements Subject {
    @Override
    public void sailBook() {
        System.out.println("买书");
    }
}
