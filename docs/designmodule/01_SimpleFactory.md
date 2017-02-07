# 设计模式-简单工厂

## 一、什么是简单工厂模式

简单工厂模式属于类的创建型模式,又叫做静态工厂方法模式。通过专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。

## 二、模式中包含的角色及其职责

1. 工厂（Creator）角色：
    简单工厂模式的核心，它负责实现创建所有实例的内部逻辑。工厂类可以被外界直接调用，创建所需的产品对象。
2. 抽象（Product）角色：
    简单工厂模式所创建的所有对象的父类，它负责描述所有实例所共有的公共接口。
3. 具体产品（Concrete Product）角色：
    简单工厂模式所创建的具体实例对象

## 三、简单工厂模式的优缺点

* 在这个模式中，工厂类是整个模式的关键所在。它包含必要的判断逻辑，能够根据外界给定的信息，决定究竟应该创建哪个具体类的对象。用户在使用时可以直接根据工厂类去创建所需的实例，而无需了解这些对象是如何创建以及如何组织的。有利于整个软件体系结构的优化。
* 不难发现，简单工厂模式的缺点也正体现在其工厂类上，由于工厂类集中了所有实例的创建逻辑，所以“高内聚”方面做的并不好。
* 另外，当系统中的具体产品类不断增多时，可能会出现要求工厂类也要做相应的修改，扩展性并不很好。

## 代码实战
```java
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
    }

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


interface Fruit{
    /**
     * 采集
     */
    public void get();
}
class Apple implements Fruit{
    public void get(){
        System.out.println("采集苹果");
    }
}
class Banana implements Fruit{
    public void get(){
        System.out.println("采集香蕉");
    }
}
```