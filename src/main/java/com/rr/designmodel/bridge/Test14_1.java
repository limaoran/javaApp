package com.rr.designmodel.bridge;

public class Test14_1 {
    public static void main(String[] args) {
        Car car1 = new Bus2000();
        car1.installEngine();
    }
}


/**
 * 汽车
 * Created by Limaoran on 2016/11/17.
 */
interface Car {
    public void installEngine();
}
abstract class Bus implements Car{
    public abstract void installEngine();
}
class Bus2000 extends Bus{
    @Override
    public void installEngine() {
        System.out.println("给Bus安装2000cc发动机");
    }
}
class Bus2200 extends Bus{
    @Override
    public void installEngine() {
        System.out.println("给Bus安装2200cc发动机");
    }
}
abstract class Jeep implements Car{
    public abstract void installEngine();
}
class Jeep2000 extends Jeep{
    @Override
    public void installEngine() {
        System.out.println("给Jeep安装2000cc发动机");
    }
}
class Jeep2200 extends Jeep{
    @Override
    public void installEngine() {
        System.out.println("给Jeep安装2200cc发动机");
    }
}