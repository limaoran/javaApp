package com.rr.designmodel.factorymethod;

import com.rr.designmodel.simplefactory.Fruit;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Test02 {
    public static void main(String[] args) {
        // 获得AppleFactory
        FruitFactory factory = new AppleFactory();
        factory.getFruit().get();

        // 获得BananaFactory
        FruitFactory factory2 = new BananaFactory();
        Fruit fruit2 = factory2.getFruit();
        fruit2.get();

        // 获得PearFactory
        FruitFactory factory3 = new PearFactory();
        Fruit fruit3 = factory3.getFruit();
        fruit3.get();
    }
}
