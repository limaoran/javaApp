package com.rr.designmodel.decorator.news;

import com.rr.designmodel.decorator.Car;

/**
 * Created by Limaoran on 2016/11/16.
 */
public abstract class CarDecorator implements Car {

    private Car car ;
    public CarDecorator(Car car){
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public abstract void show();
}
