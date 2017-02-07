package com.rr.designmodel.builder;

/**
 * 指挥者
 * Created by Limaoran on 2016/11/16.
 */
public class HouseDirector {
    public void make(HouseBuilder builder){
        builder.makeFloor();
        builder.makeWall();
        builder.makeHouseTop();
    }
}
