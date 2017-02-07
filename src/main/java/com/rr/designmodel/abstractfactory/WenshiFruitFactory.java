package com.rr.designmodel.abstractfactory;

import com.rr.designmodel.simplefactory.Apple;
import com.rr.designmodel.simplefactory.Banana;
import com.rr.designmodel.simplefactory.Fruit;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class WenshiFruitFactory implements FruitFactory {
    @Override
    public Fruit getApple() {
        return null;
    }

    @Override
    public Fruit getBanana() {
        return null;
    }
}
class WenshiApple extends Apple {
    @Override
    public void get() {
        System.out.println("采集温室苹果");
    }
}
class WenshiBanana extends Banana {
    @Override
    public void get() {
        System.out.println("采集温室香蕉");
    }
}