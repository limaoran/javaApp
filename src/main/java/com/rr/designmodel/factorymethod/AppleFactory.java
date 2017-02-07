package com.rr.designmodel.factorymethod;

import com.rr.designmodel.simplefactory.Apple;
import com.rr.designmodel.simplefactory.Fruit;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class AppleFactory implements FruitFactory{
    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}
