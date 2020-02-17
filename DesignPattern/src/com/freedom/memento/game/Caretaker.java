package com.freedom.memento.game;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 守护者对象，保存游戏角色的状态
 * @author liuf
 * date: 2020-02-17
 */
public class Caretaker {
    /**
     * 只保存一次状态
     */
    private Memento memento;
    /**
     * 对游戏角色保存多个状态
     */
    private ArrayList<Memento> mementos;
    /**
     * 保存多个角色的多个状态
     */
    private HashMap<String, ArrayList<Memento>> rolesMementos;

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }
}
