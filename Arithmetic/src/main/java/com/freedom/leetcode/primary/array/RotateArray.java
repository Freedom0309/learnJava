package com.freedom.leetcode.primary.array;

import com.freedom.leetcode.utils.ArrayUtils;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description: 旋转数组
 *
 * @author LiuFeng
 * @version 2022/1/18 16:37
 * @since
 */
public class RotateArray {

    /**
     * 遇到大的数组时，会超时
     *
     * @param nums 数组
     * @param k    要旋转k个位置
     */
    public static void rotate1(int[] nums, int k) {
        int length = nums.length;
        int last = length - 1;
        int temp = 0;
        for (int index = 0; index < k; index++) {
            temp = nums[last];
            for (int i = length - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = temp;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int length = nums.length;
        int temp[] = new int[length];
        System.arraycopy(nums, 0, temp, 0, length);
        for (int index = 0; index < length; index++) {
            nums[(index + k) % length] = temp[index];
        }
    }


    public static void rotate3(int[] nums, int k) {

        int length = nums.length;
        reverse(nums, 0, length - 1 - k);
        ArrayUtils.printArray(nums);
        reverse(nums, length - k, length - 1);
        ArrayUtils.printArray(nums);
        reverse(nums, 0, length - 1);
        ArrayUtils.printArray(nums);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        ArrayUtils.printArray(nums);
        rotate3(nums, 3);
        ArrayUtils.printArray(nums);
    }
}
