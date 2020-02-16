package com.freedom.mediator;

/**
 * @author liuf
 * date: 2020-02-16
 */
public abstract class Mediator {
    /**
     * 将中介者对象加入到集合中
     *
     * @param colleagueName
     * @param abstractColleague
     */
    public abstract void register(String colleagueName, AbstractColleague abstractColleague);

    /**
     * 接受消息，具体的同事对象发出
     *
     * @param stateChange
     * @param colleagueName
     */
    public abstract void getMessage(int stateChange, String colleagueName);

    public abstract void sendMessage();
}
