package com.freedom.facade;

/**
 * @author liuf
 * date: 2020-02-06
 */
public class DVDPlayer {
    private DVDPlayer() {
    }

    private static DVDPlayer instance = new DVDPlayer();

    /**
     * 单例，饿汉式
     *
     * @return
     */
    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("dvd on ");
    }

    public void off() {
        System.out.println("dvd off ");
    }

    public void play() {
        System.out.println("dvd is playing ");
    }

    public void pause() {
        System.out.println("dvd is paused ");
    }
}
