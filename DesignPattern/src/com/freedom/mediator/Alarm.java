package com.freedom.mediator;

/**
 * 具体的同事类
 *
 * @author liuf
 * date: 2020-02-16
 */
public class Alarm extends AbstractColleague {
    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        //在创建Alarm同事对象时，将自己放入到ConcreteMediator对象中
        mediator.register(name, this);
    }

    public void sendAlarm(int stateChange) {
        sendMessage(stateChange);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }
}
