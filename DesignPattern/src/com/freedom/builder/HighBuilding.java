package com.freedom.builder;

public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("高楼打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼建墙");
    }

    @Override
    public void roofed() {
        System.out.println("高楼楼顶");
    }
}
