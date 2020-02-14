package com.freedom.visitor;

/**
 * @author liuf
 * date: 2020-02-13
 */
public class Success extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男人给的评价：success");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人给的评价：success");

    }
}
