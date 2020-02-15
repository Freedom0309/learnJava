package com.freedom.iterator;

import java.util.Iterator;

/**
 * @author liuf
 * date: 2020-02-14
 */
public interface College {
    /**
     * 获取名称
     * @return 名称
     */
    String getName();

    /**
     * 添加系
     * @param name
     * @param des
     */
    void addDepartment(String name, String des);

    /**
     * 返回一个遍历器
     * @return
     */
    public Iterator createIterator();
}
