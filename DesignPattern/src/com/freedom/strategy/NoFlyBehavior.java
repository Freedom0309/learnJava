package com.freedom.strategy;

/**
 * @author liuf
 * date: 2020-02-21
 */
public class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
