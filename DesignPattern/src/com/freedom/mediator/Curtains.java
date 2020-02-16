package com.freedom.mediator;

/**
 * @author liuf
 * date: 2020-02-16
 */
public class Curtains extends AbstractColleague {
    public Curtains(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void upCurtains() {
        System.out.println("窗帘升起");
    }
}
