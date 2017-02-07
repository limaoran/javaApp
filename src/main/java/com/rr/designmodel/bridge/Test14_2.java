package com.rr.designmodel.bridge;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class Test14_2 {
    public static void main(String[] args) {
        Car2 car1 = new Bus2();
        car1.install2000Engine();
    }
}

interface Car2{
    public void install2000Engine();

    public void install2200Engine();

    public void install2300Engine();
}
class Bus2 implements Car2{
    public void install2000Engine() {
        System.out.println("给Bus安装2000cc发动机");
    }

    public void install2200Engine() {
        System.out.println("给Bus安装2200cc发动机");
    }

    public void install2300Engine() {
        System.out.println("给Bus安装2400cc发动机");
    }
}