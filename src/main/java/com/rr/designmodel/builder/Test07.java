package com.rr.designmodel.builder;

/**
 * Created by Limaoran on 2016/11/16.
 */
public class Test07 {
    public static void main(String[] args) {
        // 客户直接造房子
        House house2 = new House();
        house2.setFloor("地板");
        house2.setWall("墙");
        house2.setHouseTop("屋顶");

        // 由工程队来修
        HouseBuilder builder = new GongyuBuilder();
        // 设计者来做
        HouseDirector director = new HouseDirector();
        director.make(builder);

        House house = builder.getHouse();
        System.out.println(house.getFloor());
        System.out.println(house.getWall());
        System.out.println(house.getHouseTop());
    }
}
