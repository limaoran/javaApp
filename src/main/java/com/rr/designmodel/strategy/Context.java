package com.rr.designmodel.strategy;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void encrypt(){
        strategy.encrypt();
    }
}
