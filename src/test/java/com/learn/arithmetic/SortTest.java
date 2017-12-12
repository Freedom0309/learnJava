package com.learn.arithmetic;

import org.junit.Test;

import java.util.Comparator;

public class SortTest {


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
}
