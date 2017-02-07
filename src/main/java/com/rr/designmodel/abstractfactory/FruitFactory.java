package com.rr.designmodel.abstractfactory;

import com.rr.designmodel.simplefactory.Fruit;

/**
 * Created by Limaoran on 2016/11/16.
 */
public interface FruitFactory {
    Fruit getApple();
    Fruit getBanana();
}
