package com.rr.designmodel.demo.factory;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class AddOperation extends Operation{
    @Override
    public double getResult() {
        return this.getNum1()+this.getNum2();
    }
}
