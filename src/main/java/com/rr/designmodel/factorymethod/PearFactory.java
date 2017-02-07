package com.rr.designmodel.factorymethod;

import com.rr.designmodel.simplefactory.Fruit;
import com.rr.designmodel.simplefactory.Pear;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class PearFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Pear();
    }
}
