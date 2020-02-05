package com.freedom.composite.school;

/**
 * 叶子对象
 *
 * @author liuf
 * date: 2020-02-05
 */
public class Department extends OrganizationComponent {
    public Department(String name, String des) {
        super(name, des);
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
        System.out.println("------" + getName());
    }
}
