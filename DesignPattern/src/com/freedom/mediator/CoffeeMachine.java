package com.freedom.mediator;

/**
 * @author liuf
 * date: 2020-02-16
 */
public class CoffeeMachine extends AbstractColleague {
    public CoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void startCoffee() {
        System.out.println("咖啡机开始工作");
    }

    public void finishCoffee() {
        System.out.println("After 5 minutes");
        System.out.println("coffee is ok");
        sendMessage(0);
    }
}
