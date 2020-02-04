package com.freedom.decorator;

/**
 * @author liuf
 * date: 2020-02-04
 */
public class CoffeeBar {
    public static void main(String[] args) {
        //点一份咖啡
        Drink order = new LongBlack();
        System.out.println(order.getDes() + "咖啡，价格是" + order.cost());
        //加一份牛奶
        order = new Milk(order);
        System.out.println(order.getDes() + "咖啡，加一份牛奶，价格是" + order.cost());
    }
}
