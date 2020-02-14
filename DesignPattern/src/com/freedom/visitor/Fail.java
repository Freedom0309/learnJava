package com.freedom.visitor;

/**
 * @author liuf
 * date: 2020-02-13
 */
public class Fail extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男人给的评价：fail");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人给的评价：fail");
    }
}
