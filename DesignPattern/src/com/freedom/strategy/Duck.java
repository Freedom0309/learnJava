package com.freedom.strategy;

/**
 * @author liuf
 * date: 2020-02-21
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    /**
     * 子类实现，显示鸭子种类
     */
    public abstract void display();

    /**
     * 鸭子叫声
     */
    public void quack() {
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }

    /**
     * 鸭子飞翔
     */
    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }
}
