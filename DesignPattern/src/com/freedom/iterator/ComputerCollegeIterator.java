package com.freedom.iterator;

import java.util.Iterator;

/**
 * @author liuf
 * date: 2020-02-14
 */
public class ComputerCollegeIterator implements Iterator {
    /**
     * Department以数组的形式存放
     */
    private Department[] departments;
    /**
     * Department的下标，遍历的位置
     */
    private int position;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return !(position >= departments.length || departments[position] == null);
    }

    @Override
    public Object next() {
        Department department = departments[position];
        position += 1;
        return department;
    }
}
