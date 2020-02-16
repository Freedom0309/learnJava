package com.freedom.mediator;

import java.util.HashMap;

/**
 * @author liuf
 * date: 2020-02-16
 */
public class ConcreteMediator extends Mediator {
    private HashMap<String, AbstractColleague> colleagueMap;
    private HashMap<String, String> interMap;

    public ConcreteMediator() {
        this.colleagueMap = new HashMap<String, AbstractColleague>();
        this.interMap = new HashMap<String, String>();

    }

    @Override
    public void register(String colleagueName, AbstractColleague abstractColleague) {
        colleagueMap.put(colleagueName, abstractColleague);

        if (abstractColleague instanceof Alarm) {
            interMap.put("Alarm", colleagueName);
        } else if (abstractColleague instanceof CoffeeMachine) {
            interMap.put("CoffeeMachine", colleagueName);
        } else if (abstractColleague instanceof Curtains) {
            interMap.put("Curtains", colleagueName);
        } else if (abstractColleague instanceof TV) {
            interMap.put("TV", colleagueName);
        }
    }

    /**
     * 中介者的核心方法
     * 根据得到的消息，完成具体的任务
     * 中介者在这个方法，协调各个具体的同事对象，完成任务
     *
     * @param stateChange
     * @param colleagueName
     */
    @Override
    public void getMessage(int stateChange, String colleagueName) {
        if (colleagueMap.isEmpty()) {
            return;
        }
        if (colleagueMap.get(colleagueName) instanceof Alarm) {
            if (stateChange == 0) {
                ((CoffeeMachine) (colleagueMap.get(interMap.get("CoffeeMachine")))).startCoffee();
                ((TV) (colleagueMap.get(interMap.get("TV")))).startTV();
            } else if (stateChange == 1) {
                ((TV) (colleagueMap.get(interMap.get("TV")))).stopTV();
            }
        } else if (colleagueMap.get(colleagueName) instanceof CoffeeMachine) {
            ((Curtains) (colleagueMap.get(interMap.get("Curtains")))).upCurtains();
        } else if (colleagueMap.get(colleagueName) instanceof TV) {

        } else if (colleagueMap.get(colleagueName) instanceof Curtains) {

        }
    }

    @Override
    public void sendMessage() {

    }
}
