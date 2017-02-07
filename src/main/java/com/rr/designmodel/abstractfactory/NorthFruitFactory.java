package com.rr.designmodel.abstractfactory;

import com.rr.designmodel.simplefactory.Apple;
import com.rr.designmodel.simplefactory.Banana;
import com.rr.designmodel.simplefactory.Fruit;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class NorthFruitFactory implements FruitFactory {
    @Override
    public Fruit getApple() {
        return new NorthApple();
    }

    @Override
    public Fruit getBanana() {
        return new NorthBanana();
    }
}

class NorthBanana extends Banana {
    @Override
    public void get() {
        System.out.println("采集北方香蕉");
    }
}
class NorthApple extends Apple {
    @Override
    public void get() {
        System.out.println("采集北方苹果");
    }
}
