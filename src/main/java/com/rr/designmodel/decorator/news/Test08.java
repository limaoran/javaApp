package com.rr.designmodel.decorator.news;

import com.rr.designmodel.decorator.Car;
import com.rr.designmodel.decorator.RunCar;
import com.rr.designmodel.decorator.SwimCar;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Test08 {
    public static void main(String[] args) {
        // Basic
        Car flycar = new SwimCar();
        flycar.show();
        System.out.println("----------------");

        // Decorator
        Car car = new RunCar();
        car.show();
        System.out.println("------------------");

        // 可以跑！
        // 可以游
        Car swimCar = new SwimCarDecorator(car);
        swimCar.show();
        System.out.println("-------------------");

        /*
        可以跑！
        可以游
        可以飞
         */
        Car flySwimCar = new FlyCarDecrator(swimCar);
        flySwimCar.show();

    }
}
