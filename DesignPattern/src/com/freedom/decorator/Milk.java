package com.freedom.decorator;

/**
 * @author liuf
 * date: 2020-02-04
 */
public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(2.0f);
    }
}
