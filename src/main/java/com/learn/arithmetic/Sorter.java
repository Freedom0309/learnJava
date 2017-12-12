package com.learn.arithmetic;

import java.util.Comparator;

public interface Sorter {
    /**
     *  sort
     * @param list
     * @param <T>
     */
    public <T extends Comparable<T>> void sort(T[] list);

    /**
     *
     * @param list 待排序的数组
     * @param comparator 比较两个对象的比较器
     * @param <T>
     */
    public <T> void sort(T[] list, Comparator<T> comparator);
}
