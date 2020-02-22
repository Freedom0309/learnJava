package com.freedom.strategy;

/**
 * @author liuf
 * date: 2020-02-21
 */
public class PekingDuck extends Duck {
    public PekingDuck() {
        super.flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("~北京烤鸭~");
    }
}
