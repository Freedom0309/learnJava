package com.freedom.mediator;

/**
 * @author liuf
 * date: 2020-02-16
 */
public class TV extends AbstractColleague {
    public TV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void startTV() {
        System.out.println("TV开始播放电视剧");
    }

    public void stopTV() {
        System.out.println("关闭TV");
    }
}
