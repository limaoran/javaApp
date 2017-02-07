package com.rr.designmodel.abstractfactory;

import com.rr.designmodel.simplefactory.Apple;
import com.rr.designmodel.simplefactory.Banana;
import com.rr.designmodel.simplefactory.Fruit;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class SouthFruitFactory implements FruitFactory{
    @Override
    public Fruit getApple() {
        return new SouthApple();
    }

    @Override
    public Fruit getBanana() {
        return new SouthBanana();
    }
}

class SouthApple extends Apple{
    @Override
    public void get() {
        System.out.println("采集南方苹果");
    }
}
class SouthBanana extends Banana{
    @Override
    public void get() {
        System.out.println("采集南方香蕉");
    }
}