package com.learn.arithmetic;

import java.util.Comparator;

/**
 * 冒泡排序
 */
public class BubbleSorter implements Sorter{

    /**
     * 第一种实现方式
     * @param list   需要排序的数组
     * @param <T>
     */
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped;  ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public <T> void sort(T[] list, Comparator<T> comparator) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (comparator.compare(list[j], list[j +1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j +1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
}
