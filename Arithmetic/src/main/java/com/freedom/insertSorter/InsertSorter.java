package com.freedom.insertSorter;

/**
 * 插入排序
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4.重复步骤3，知道找到已排序的元素小于或者等于新元素的位置
 * 5.将元素插入到该位置后
 * 6.重复步骤2~5
 *
 */
public class InsertSorter  {

    /**
     * 数据结构 -- 数组
     * 最差时间复杂度 -- 最坏情况为输入序列是降序排列的，此时时间复杂度为O(n^2)
     * 最优时间复杂度 -- 最好情况为输入序列是升序排列的，此时时间复杂度为O(n)
     * 平均时间复杂度 -- O(n^2)
     * 所需辅助空间 -- O(1)
     * 稳定性 -- 稳定
     * @param list
     */
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

    /**
     * 二分插入排序，如果比较操作的代价比交换的操作大的话，可以采用二分查找法来减少比较操作的次数
     * 最差时间复杂度 -- O(n^2)
     * 最优时间复杂度 --O(nlogn)
     * 平均时间复杂度 -- O(1)
     * 所需辅助空间 -- O(1)
     * 稳定性 -- 稳定
     */
    public void dichotomyInsertionSort(int[] list){
        for (int i = 1; i < list.length; i++) {
            int left = 0, right = i - 1;
            int temp = list[i];
            // 采用二分法确定新的位置
            while (left <= right) {
                int mid = (left + right) / 2;
                if (list[mid] > list[i]) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                list[j + 1] =list[j];
            }
            list[left] = temp;
        }
    }
}
