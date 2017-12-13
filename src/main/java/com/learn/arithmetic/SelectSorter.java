package com.learn.arithmetic;

/**
 * 选择排序
 * 在未排序序列中找到最小元素，存放到排序序列的起始位置
 * 在从剩余未排序的序列中继续寻找最小的元素，然后放到排序序列的末尾
 * 以此类推，直到所有元素均排序完毕
 */
public class SelectSorter {

    public void sort(int [] list){
        for (int i=0, len = list.length; i < len; i++) {
            int k = i;
            /*for (int j = len - 1; j > i; j--) {
                if (list[k] > list[j]) {
                    k = j;
                }
             }  */
            for (int j = i+1; j < len; j++) {
                if (list[k] > list[j]) {
                    k = j;
                }
            }
            int temp = list[i];
            list[i] = list[k];
                list[k] = temp;
        }
    }
}
