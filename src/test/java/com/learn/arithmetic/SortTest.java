package com.learn.arithmetic;

import org.junit.Test;

import java.util.Comparator;

public class SortTest {


    /**
     * 冒泡排序的测试
     */
    @Test
    public void BubbleSortTest(){

       int  array[] = null;
        Integer arrays[] = {12,23,34,1,32,34,78};
        Integer arrays1[] = {12,23,34,1,32,34,78};

       BubbleSorter bubbleSorter = new BubbleSorter();
       bubbleSorter.sort(arrays);
        for (Integer c:arrays) {
            System.out.print(arrays.toString());
            System.out.println(" : "+c);
        }

        /*Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                System.out.println("excute" + o1 + " " + o2);
                return 1;
            }
        };

        bubbleSorter.sort(arrays1, comparator);
        for (int i = 0; i < arrays1.length; i++) {
            System.out.print(arrays1[i] + " ");
        }*/
    }

    /**
     * 插入排序的测试
     */
    @Test
    public void InsertSorterTest(){
        int array[] = {30,4,1,12,36,21,78,32,11,9,5,89,1};
        InsertSorter insertSorter = new InsertSorter();
        insertSorter.sort(array);
        for (int i=0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
