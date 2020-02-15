package com.freedom.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author liuf
 * date: 2020-02-14
 */
public class InfoCollegeIterator implements Iterator {

    /**
     * 以list的方式存放
     */
    private List<Department> departments;
    /**
     * 索引
     */
    private int index = -1;

    public InfoCollegeIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (index >= departments.size() - 1) {
            return false;
        } else {
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return departments.get(index);
    }

    @Override
    public void remove() {

    }
}
