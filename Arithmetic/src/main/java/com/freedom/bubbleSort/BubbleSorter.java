package com.freedom.bubbleSort;

import com.freedom.Sorter;

import java.util.Comparator;

/**
 * 冒泡排序
 * 比较相邻的两个元素，如果第一个比第二个大，那么就交换他们两个。
 * 对每一对相邻的元素做同样的工作，从开始第一队到结尾最后一对。最后的元素应该是最大的元素。
 * 针对所有元素重复以上步骤，除了最后一个
 * 持续每次对越来越少的元素重复以上的步骤，直到没有任何一对数组需要比较
 */
public class BubbleSorter implements Sorter {

    /**
     * 第一种实现方式
     * @param list   需要排序的数组
     * @param <T>
     */
    @Override
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

    @Override
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
