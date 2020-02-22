package com.freedom.strategy;

/**
 * @author liuf
 * date: 2020-02-21
 */
public class WildDuck extends Duck {
    public WildDuck() {
        super.flyBehavior = new GoodFlyBehavior();
        super.quackBehavior = new GaGaQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("~野鸭~");
    }
}
