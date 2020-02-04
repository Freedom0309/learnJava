package com.freedom.decorator;

/**
 * @author liuf
 * date: 2020-02-04
 */
public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }
}
