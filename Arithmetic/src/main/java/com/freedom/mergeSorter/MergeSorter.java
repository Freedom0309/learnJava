package com.freedom.mergeSorter;

/**
 * @Author: Allen Liu
 * @Description: 归并排序的实现分为递归实现与非递归（迭代）实现。递归实现的归并排序是算法设计中分治策略的典型应用，
 * 我们将一个问题分割成小问题分别解决，然后用所有小问题的答案来解决整个大问题。非递归（迭代）实现的归并排序首先是进行两两归并，
 * 然后是四四归并，然后是八八归并，一直持续下去直到归并了整个数组。
 * 主要依赖于归并操作：
 * 1.申请空间，使其大小为两个已经排序序列之和，改空间用来存放合并后的序列
 * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 3.比较两个指针所指向的元素，选择相对小的元素放到合并空间，并移动指针到下一个位置
 * 4.重复步骤3知道某一指针到达序列尾
 * 5.将另一序列剩下的所有元素直接复制到合并序列尾
 * @Date: Created in 17:19 2017/12/14
 * @Modified By:
 **/
public class MergeSorter {

    public static void mergeSort(int list[]){
        sort(list,0, list.length -1);
    }

    public static void sort(int list[], int left, int right){
        if (left >= right) {
            return;
        }
        int center = (left + right) / 2;
        sort(list, left,center);
        sort(list,center + 1, right);
        merge(list, left, center, right);
        for (int i: list
             ) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void merge(int [] list, int left, int center, int right){
        int[] tmpArr = new int [list.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            //从两个数组从取出最小的那个放入临时数组
            if (list[left] <= list[mid]) {
                tmpArr[third++] = list[left++];
            } else {
                tmpArr[third++] = list[mid++];
            }
        }

        //剩余部分依次放入临时数组（实际上两个while只会执行一个）
        while (mid <= right) {
            tmpArr[third++] = list[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = list[left++];
        }

        //将临时数组中的内容拷贝回原数组中
        //（原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            list[tmp] = tmpArr[tmp++];
        }
    }
}
