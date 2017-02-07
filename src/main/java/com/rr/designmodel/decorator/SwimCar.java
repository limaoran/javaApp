package com.rr.designmodel.decorator;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class SwimCar implements Car {
    @Override
    public void run() {
        System.out.println("可以跑");
    }
    public void swim() {
        System.out.println("可以游");
    }
    @Override
    public void show() {
        this.run();
        this.swim();
    }
}
