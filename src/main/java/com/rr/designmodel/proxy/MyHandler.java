package com.rr.designmodel.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 使用反射，实现代理
 * Created by Limaoran on 2016/11/17.
 */
public class MyHandler implements InvocationHandler {
    private Subject subject;

    public MyHandler(Subject subject){
        this.subject = subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        dazhe();
        try {
            result = method.invoke(subject, args);
        }catch (Exception e){
            e.printStackTrace();
        }
        give();
        return result;
    }
    public void dazhe(){
        System.out.println("打折");
    }
    public void give(){
        System.out.println("赠送代金券");
    }
}
