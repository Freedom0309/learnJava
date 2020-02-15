package com.freedom.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author liuf
 * date: 2020-02-14
 */
public class OutputImpl {
    private List<College> colleges;

    public OutputImpl(List<College> colleges) {
        this.colleges = colleges;
    }

    /**
     * 遍历所有的学院
     */
    public void printCollege() {
        //从colleges中取出所有的学院
        Iterator<College> iterator = colleges.iterator();
        while (iterator.hasNext()) {
            College college = iterator.next();
            System.out.println("=======" + college.getName() + "======");
            printDepartment(college.createIterator());
        }

    }

    /**
     * @param iterator
     */
    public void printDepartment(Iterator iterator) {
        while (iterator.hasNext()) {
            Department d = (Department) iterator.next();
            System.out.println(d.getName());
        }
    }
}
