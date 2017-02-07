package com.rr.designmodel.decorator.news;

import com.rr.designmodel.decorator.Car;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class SwimCarDecorator extends CarDecorator {

    public SwimCarDecorator(Car car) {
        super(car);
    }

    public void swim() {
        System.out.println("可以游");
    }

    @Override
    public void run() {

    }

    @Override
    public void show() {
        this.getCar().show();
        this.swim();
    }
}
