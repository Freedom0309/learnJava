package com.freedom.visitor;

/**
 * @author liuf
 * date: 2020-02-13
 */
public class Man extends Person {
    @Override
    public void action(Action action) {
        action.getManResult(this);
    }
}
