package com.rr.designmodel.demo.factory;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class AddOperationFactory implements OperationFactory {
    @Override
    public Operation getOperation() {
        return new AddOperation();
    }
}
