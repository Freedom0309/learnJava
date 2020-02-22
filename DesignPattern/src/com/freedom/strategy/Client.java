package com.freedom.strategy;

/**
 * @author liuf
 * date: 2020-02-21
 */
public class Client {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.display();
        wildDuck.fly();
        wildDuck.quack();
        wildDuck.setQuackBehavior(new GeGeQuackBehavior());
        wildDuck.quack();
    }
}
