package com.freedom.template;

/**
 * @author liuf
 * date: 2020-02-10
 */
public class PeanutSoyMilk extends SoyMilk {
    @Override
    void addCondiments() {
        System.out.println("加入花生和黄豆");
    }
}
