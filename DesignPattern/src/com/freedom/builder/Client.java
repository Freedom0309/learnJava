package com.freedom.builder;

public class Client {
    public static void main(String[] args) {
        //普通房子
        CommonHouse commonHouse = new CommonHouse();
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        houseDirector.constructHouse();

        //高楼
        houseDirector.setHouseBuilder(new HighBuilding());
        houseDirector.constructHouse();
    }
}
