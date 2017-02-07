package com.rr.designmodel.proxy;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class ProxySubject implements Subject {
    private Subject subject;
    public ProxySubject(){
        this.subject = new RealSubject();
    }
    @Override
    public void sailBook() {
        dazhe();
        subject.sailBook();
        give();
    }
    public void dazhe(){
        System.out.println("打折");
    }
    public void give(){
        System.out.println("赠送代金券");
    }
}
