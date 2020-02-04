package com.freedom.decorator;

/**
 * @author liuf
 * date: 2020-02-04
 */
public class Decorator extends Drink {
    private Drink obj;

    public Decorator(Drink obj) {
        //组合关系
        this.obj = obj;
    }

    @Override
    public float cost() {
        //getPrice 自己的价格
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        //obj.getDes()被装饰者的信息
        return super.des + " " + super.getPrice() + "&&" + obj.getDes() + "--";
    }
}
