package com.rr.designmodel.simplefactory;

/**
 * 简单工厂模式
 * Created by Limaoran on 2016/7/30.
 */
public class FruitFactory {
    /**
     * 获得Apple类的实例
     * @return
     */
    public static Fruit getApple(){
        return new Apple();
    }

    /**
     * 获得Banana类实例
     * @return
     */
    public static Fruit getBanana() {
        return new Banana();
    }

    /**
     * get方法，获得所有产品对象
     * @param type
     * @return
     */
    public static Fruit getFruit(String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        if (type.equalsIgnoreCase("apple")) {
            return Apple.class.newInstance();
        } else if (type.equalsIgnoreCase("banana")) {
            return Banana.class.newInstance();
        } else {
            Class fruit = Class.forName(type);
            return (Fruit) fruit.newInstance();
//            System.out.println("找不到相应的实例化类");
        }
//        Class clazz = Class.forName(type);
//        Fruit fruit = (Fruit) clazz.newInstance();
//        return fruit;
    }
}
