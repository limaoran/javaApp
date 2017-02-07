package com.rr.designmodel.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class Test12 {
    public static void main(String[] args) {
        // 普通代理
        ProxySubject basicProxy = new ProxySubject();
        basicProxy.sailBook();

        // 动态代理
        RealSubject realSubject = new RealSubject();
        MyHandler handler = new MyHandler(realSubject);

        Subject proxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),realSubject.getClass().getInterfaces(),handler);
        proxySubject.sailBook();

    }
}
