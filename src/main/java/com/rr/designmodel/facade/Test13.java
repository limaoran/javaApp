package com.rr.designmodel.facade;

public class Test13 {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doABC();
        System.out.println("--------------");
        facade.doAC();
    }
}