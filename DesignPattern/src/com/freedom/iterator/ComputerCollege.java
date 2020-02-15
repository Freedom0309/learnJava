package com.freedom.iterator;

import java.util.Iterator;

/**
 * @author liuf
 * date: 2020-02-14
 */
public class ComputerCollege implements College {
    /**
     * Department以数组的形式存放
     */
    private Department[] departments;
    /**
     * 索引，保存当前数组的个数
     */
    private int numOfDepartments = 0;

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("java", "java 11");
        addDepartment("infomation engineer", "info");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String des) {
        Department department = new Department(name, des);
        departments[numOfDepartments] = department;
        numOfDepartments += 1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
