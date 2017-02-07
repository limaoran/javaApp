package com.rr.designmodel.builder;

/**
 * 工程队
 * Created by Limaoran on 2016/11/16.
 */
public interface HouseBuilder {
    /**
     * 修地板
     */
    void makeFloor();

    /**
     * 修墙
     */
    void makeWall();
    /**
     * 修屋顶
     */
    void makeHouseTop();

    House getHouse();
}
