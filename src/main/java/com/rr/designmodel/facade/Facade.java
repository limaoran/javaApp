package com.rr.designmodel.facade;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class Facade {
    private SystemA systemA;
    private SystemB systemB;
    private SystemC systemC;

    public Facade(){
        systemA = new SystemA();
        systemB = new SystemB();
        systemC = new SystemC();
    }
    public void doABC(){
        systemA.doSamething();
        systemB.doSomething();
        systemC.doSomething();
    }
    public void doAC(){
        systemA.doSamething();
        systemC.doSomething();
    }
}
/**
 * A子系统
 * Created by Limaoran on 2016/11/17.
 */
class SystemA {
    public void doSamething(){
        System.out.println("实现A子系统功能");
    }
}
/**
 * B子系统
 */
class SystemB {
    public void doSomething() {
        System.out.println("实现B子系统功能");
    }
}
/**
 * C子系统
 */
class SystemC {
    public void doSomething() {
        System.out.println("实现C子系统功能");
    }
}