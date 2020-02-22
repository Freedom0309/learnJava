package com.freedom.strategy;

/**
 * @author liuf
 * date: 2020-02-21
 */
public class GeGeQuackBehavior implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("~咯咯叫~");
    }
}
