package com.rr.designmodel.simplefactory;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Test01 {
    public static void main(String[] args)throws Exception{
//        //实例化一个Apple
        Apple apple1 = new Apple();
        //实例化一个Banana
        Banana banana1 = new Banana();

        apple1.get();
        banana1.get();

        //实例化一个Apple,用到了多态
        Fruit apple2 = new Apple();
        Fruit banana2 = new Banana();
        apple2.get();
        banana2.get();

        //实例化一个Apple
        Fruit apple3 = FruitFactory.getApple();
        Fruit banana3 = FruitFactory.getBanana();
        apple3.get();
        banana3.get();

        Fruit apple = FruitFactory.getFruit("Apple");
        Fruit banana = FruitFactory.getFruit("Banana");
        apple.get();
        banana.get();

        Fruit apple4 = FruitFactory.getFruit("com.rr.designmodel.simplefactory.Apple");
        apple4.get();
    }
}
