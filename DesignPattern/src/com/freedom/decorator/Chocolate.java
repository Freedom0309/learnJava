package com.freedom.decorator;

/**
 * 具体的Decorator，调味品
 * @author liuf
 * date: 2020-02-04
 */
public class Chocolate extends Decorator {

    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        //调味品的价格
        setPrice(3.0f);
    }
}
