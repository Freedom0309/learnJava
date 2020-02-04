package com.freedom.decorator;

/**
 * @author liuf
 * date: 2020-02-04
 */
public class SoyMilk extends Decorator {
    public SoyMilk(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(1.0f);
    }
}
