package com.rr.designmodel.decorator.news;

import com.rr.designmodel.decorator.Car;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class FlyCarDecrator extends CarDecorator {
    public FlyCarDecrator(Car car) {
        super(car);
    }

    @Override
    public void run() {

    }

    public void fly(){
        System.out.println("可以飞");
    }

    @Override
    public void show() {
        this.getCar().show();
        this.fly();
    }
}
