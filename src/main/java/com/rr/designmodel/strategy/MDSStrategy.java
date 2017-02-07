package com.rr.designmodel.strategy;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class MDSStrategy implements Strategy {
    @Override
    public void encrypt() {
        System.out.println("执行MDS加密！");
    }
}
