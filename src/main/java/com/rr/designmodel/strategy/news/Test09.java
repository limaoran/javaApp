package com.rr.designmodel.strategy.news;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Test09 {
    public static void main(String[] args) {
        // Strategy
        double num = 180;
        Context context2 = new Context(new StrategyA());
        double result = context2.cost(num);
        System.out.println("实际付账："+result+"元！");
    }
}
