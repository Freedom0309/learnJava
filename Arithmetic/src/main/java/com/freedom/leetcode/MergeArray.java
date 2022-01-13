package com.freedom.leetcode;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description:
 *
 * @author LiuFeng
 * @version 2022/1/11 16:56
 * @since
 */
public class MergeArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, index = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[index++] = nums1[i++];
            } else {
                temp[index++] = nums2[j++];
            }
        }

        for (; i < m; ) {
            temp[index++] = nums1[i++];
        }
        for (; j < n; ) {
            temp[index++] = nums2[j++];
        }
        System.out.println(i + " " + j);
        print(temp, "merge arr");

        for (int k = 0; k < m + n; k++) {
            nums1[k] = temp[k];
        }

    }

    public static void print(int[] arr, String message) {
        System.out.println(message);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 10, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        print(nums1, "before merge:");
        merge(nums1, 4, nums2, 3);
        print(nums1, "after  merge:");
    }
}
