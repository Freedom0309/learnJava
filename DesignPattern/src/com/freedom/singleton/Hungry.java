package com.freedom.singleton;

/**
 * @Describe: 会有浪费空间的可能性
 * @version:
 * @author: liuf
 * @date: 2020-05-19
 */
public class Hungry {
    //初始化时，会被加载的
    private byte[] bytes = new byte[1204 * 1024 * 1024];

    private Hungry() {
    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance() {
        return HUNGRY;
    }
}
