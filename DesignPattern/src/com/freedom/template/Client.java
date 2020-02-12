package com.freedom.template;

/**
 * @author liuf
 * date: 2020-02-10
 */
public class Client {
    public static void main(String[] args) {
        //制作红豆豆浆
        RedBeanSoyMilk redBeanSoyMilk = new RedBeanSoyMilk();
        redBeanSoyMilk.make();

        System.out.println("--------------------------");
        //制作花生豆浆
        PeanutSoyMilk peanutSoyMilk = new PeanutSoyMilk();
        peanutSoyMilk.make();
    }
}
