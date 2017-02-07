package com.rr.designmodel.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 实现JDK自带的Observer
 * Created by Limaoran on 2016/11/16.
 */
public class MyObserver implements Observer {
    /**
     * @param o 事件源对象（Person）
     * @param arg 为 Ovservable调用notifyObservers方法传递的参数
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("对象发生变化："+arg+",源对象："+o);
    }
}
