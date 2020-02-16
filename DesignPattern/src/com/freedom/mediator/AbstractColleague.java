package com.freedom.mediator;

/**
 * 同事抽象类
 * 操作流程：
 * 1.创建<code>ConcreteColleague</code>对象
 * 2.创建各个同事类对象
 * 3.在创建同事类对象的时候，就直接通过构造器，加入到colleagueMap
 * 4.同事类对象，可以调用sendMessage，最终回去调用ConcreteMediator的getMessage方法
 * 5.getMessage会根据接受到的同事对象发出的消息来协调调用其他的同事，完成任务
 * 6.可以看到getMessage是核心方法
 *
 * @author liuf
 * date: 2020-02-16
 */
public abstract class AbstractColleague {
    private Mediator mediator;
    public String name;

    public AbstractColleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator() {
        return this.mediator;
    }

    public abstract void sendMessage(int stateChange);
}
