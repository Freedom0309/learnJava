package com.freedom.strategy;

/**
 * @author liuf
 * date: 2020-02-21
 */
public class NoQuackBehavior implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫");
    }
}
