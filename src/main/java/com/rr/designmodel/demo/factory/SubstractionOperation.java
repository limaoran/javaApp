package com.rr.designmodel.demo.factory;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class SubstractionOperation extends Operation {
    @Override
    public double getResult() {
        return this.getNum1()-this.getNum2();
    }
}
