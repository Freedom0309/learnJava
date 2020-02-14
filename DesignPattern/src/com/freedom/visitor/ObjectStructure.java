package com.freedom.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * 数据结构，管理很多人
 * @author liuf
 * date: 2020-02-13
 */
public class ObjectStructure {

    private List<Person> persons = new LinkedList<Person>();

    /**
     * 增加到list
     *
     * @param p
     */
    public void attach(Person p) {
        persons.add(p);
    }

    /**
     * 移除
     *
     * @param p
     */
    public void detach(Person p) {
        persons.remove(p);
    }

    /**
     * 显示
     * @param action
     */
    public void display(Action action) {
        for (Person p : persons) {
            p.action(action);
        }
    }
}
