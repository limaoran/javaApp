package com.rr.designmodel.strategy;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Test09 {
    public static void main(String[] args) {
        // Basic
        Strategy stra = new MDSStrategy();
		stra.encrypt();

        Context context = new Context(new MDSStrategy());
        context.encrypt();
    }
}
