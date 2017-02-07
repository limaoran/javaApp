package com.rr.designmodel.decorator;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class RunCar implements Car {
    @Override
    public void run() {
        System.out.println("可以跑！");
    }
    @Override
    public void show() {
        this.run();
    }
}
