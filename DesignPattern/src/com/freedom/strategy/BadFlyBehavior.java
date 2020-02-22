package com.freedom.strategy;

/**
 * @author liuf
 * date: 2020-02-21
 */
public class BadFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞的一般般");
    }
}
