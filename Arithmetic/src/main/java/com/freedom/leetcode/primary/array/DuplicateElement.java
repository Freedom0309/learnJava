package com.freedom.leetcode.primary.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description: 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；
 * 如果数组中每个元素互不相同，返回 false
 *
 * @author LiuFeng
 * @version 2022/1/19 22:36
 * @since
 */
public class DuplicateElement {


    public static boolean duplicateElements(int[] nums) {
        if (nums.length <= 1) return true;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return true;
        }
//        return set.size() != nums.length;
        return false;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        boolean isDuplicate = duplicateElements(nums);
        System.out.println(isDuplicate);
    }
}
