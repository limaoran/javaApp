package com.rr.designmodel.decorator;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class FlyCar implements Car {
    @Override
    public void run() {
        System.out.println("可以跑");
    }

    public void fly(){
        System.out.println("可以飞");
    }

    @Override
    public void show() {
        this.run();
        this.fly();
    }
}
