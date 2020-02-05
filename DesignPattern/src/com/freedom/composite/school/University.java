package com.freedom.composite.school;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuf
 * date: 2020-02-05
 */
public class University extends OrganizationComponent {

    private List<OrganizationComponent> components = null;

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    public void addComponent(OrganizationComponent child) {
        //延迟加载
        if (components == null) {
            components = new ArrayList<OrganizationComponent>();
        }
        components.add(child);
    }

    @Override
    public void removeComponent(OrganizationComponent child) {
        if (components != null) {
            components.remove(child);
        }
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public void print() {
        System.out.println("---------" + getName() + "--------");
        for (OrganizationComponent c : components) {
            c.print();
        }
    }
}
