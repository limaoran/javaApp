package com.rr.designmodel.builder;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class GongyuBuilder implements HouseBuilder {
    private House house = new House();
    @Override
    public void makeFloor() {
        house.setFloor("公寓-->地板");
    }

    @Override
    public void makeWall() {
        house.setWall("公寓-->墙");
    }

    @Override
    public void makeHouseTop() {
        house.setHouseTop("公寓-->屋顶");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
