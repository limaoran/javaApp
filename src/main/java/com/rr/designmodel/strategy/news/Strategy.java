package com.rr.designmodel.strategy.news;

/**
 * Created by Limaoran on 2016/11/16.
 */
public interface Strategy {
    double cost(double num);
}
class StrategyA implements Strategy{
    @Override
    public double cost(double num) {
        return num * 0.8;
    }
}
class StrategyB implements Strategy{

    @Override
    public double cost(double num) {
        if(num>200){
            return num - 50;
        }
        return num;
    }
}