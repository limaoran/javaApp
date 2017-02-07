package com.rr.designmodel.strategy.news;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public double cost(double num){
        return strategy.cost(num);
    }
}
