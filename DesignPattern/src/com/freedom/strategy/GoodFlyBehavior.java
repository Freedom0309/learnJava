package com.freedom.strategy;

/**
 * @author liuf
 * date: 2020-02-21
 */
public class GoodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞翔技术高超");
    }
}
