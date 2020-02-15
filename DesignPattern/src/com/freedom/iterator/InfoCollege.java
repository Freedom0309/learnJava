package com.freedom.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author liuf
 * date: 2020-02-14
 */
public class InfoCollege implements College {
    private List<Department> departments;

    public InfoCollege() {
        this.departments = new ArrayList<Department>();
        addDepartment("通信工程", "通信");
        addDepartment("信息管理", "信息");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String des) {
        Department department = new Department(name, des);
        departments.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departments);
    }
}
