package com.rr.designmodel.bridge.news;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class Test14_3{
    public static void main(String[] args) {
        Engine engine2000 = new Engine2000();
        Engine engine2200 = new Engine2200();

        Car car1 = new Bus(engine2000);
        car1.installEngine();

        Car car2 = new Bus(engine2200);
        car2.installEngine();

        Car jeep1 = new Jeep(engine2000);
        jeep1.installEngine();

        Car jeep2 = new Jeep(engine2200);
        jeep2.installEngine();
    }
}
interface Engine {
    public void installEngine();
}
class Engine2000 implements Engine {
    public void installEngine() {
        System.out.println("安装2000cc发动机");
    }
}
class Engine2200 implements Engine{
    public void installEngine() {
        System.out.println("安装2200cc发动机");
    }
}
abstract class Car {
    private Engine engine;
    public Car(Engine engine) {
        this.engine = engine;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public abstract void installEngine();
}

class Bus extends Car{
    public Bus(Engine engine) {
        super(engine);
    }
    public void installEngine() {
        System.out.print("Bus：");
        this.getEngine().installEngine();
    }
}
class Jeep extends Car {
    public Jeep(Engine engine) {
        super(engine);
    }
    public void installEngine() {
        System.out.print("Jeep：");
        this.getEngine().installEngine();
    }
}
