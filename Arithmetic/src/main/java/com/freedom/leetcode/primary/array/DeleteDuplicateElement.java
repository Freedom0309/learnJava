package com.freedom.leetcode.primary.array;

import com.freedom.leetcode.utils.ArrayUtils;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description: 删除有序数组中的重复元素
 *
 * @author LiuFeng
 * @version 2022/1/16 21:11
 * @since
 */
public class DeleteDuplicateElement {

    public static int removeDuplicates(int[] nums) {

        int left = 0;
        for (int right = 1; right < nums.length; ) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 2, 3, 3};

        ArrayUtils.printArray(nums);
        removeDuplicates(nums);
        ArrayUtils.printArray(nums);

    }
}
