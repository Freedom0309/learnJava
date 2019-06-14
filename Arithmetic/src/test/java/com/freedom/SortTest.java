package com.freedom;

import com.freedom.bubbleSort.BubbleSorter;
import com.freedom.insertSorter.InsertSorter;
import com.freedom.mergeSorter.MergeSorter;
import com.freedom.selectSorter.SelectSorter;
import org.junit.Test;

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
        int array1[] = {30,4,1,12,36,21,78,32,11,9,5,89,1};
        InsertSorter insertSorter = new InsertSorter();
        insertSorter.sort(array);
        System.out.println("插入排序的结果:");
        print(array);

        System.out.println();
        System.out.println("二分插入排序的结果:");
        insertSorter.dichotomyInsertionSort(array1);
        print(array1);
    }

    /**
     * 选择排序的测试
     */
    @Test
    public void SelectSorterTest(){
        int [] array = {3,0,4,1,12,36,21,78,32,11,9,5,89,1};
        SelectSorter selectSorter = new SelectSorter();
        selectSorter.sort(array);
        print(array);
    }

    public static void print(int [] data){
        for (int i=0; i<data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 归并排序测试
     */
    @Test
    public void MergeSorterTest(){
        int [] array = {3,0,4,1,12};
        MergeSorter mergeSorter = new MergeSorter();
        mergeSorter.mergeSort(array);
        print(array);
    }
}
