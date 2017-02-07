package com.rr.designmodel.strategy;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class MD5Strategy implements Strategy {
    @Override
    public void encrypt() {
        System.out.println("执行MD5加密！");
    }
}
