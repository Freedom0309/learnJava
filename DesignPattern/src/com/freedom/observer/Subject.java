package com.freedom.observer;

/**
 * @author liuf
 * date: 2020-02-15
 */
public interface Subject {
    /**
     * 注册
     *
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 移除
     *
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 通知
     */
    void notifyObserver();
}
