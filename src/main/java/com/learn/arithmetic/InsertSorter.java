package com.learn.arithmetic;

/**
 * 插入排序
 *
 */
public class InsertSorter  {

    public  void sort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int j;
            int temp = list[i];
            for (j = i - 1; j >= 0; j--) {
                if (list[j] > temp) {
                    list[j+1] = list[j];
                }else{
                    break;
                }
            }
            list[j+1] = temp;
        }
    }
}
