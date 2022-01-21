package com.freedom.leetcode.primary.array;

import com.freedom.leetcode.utils.ArrayUtils;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description:给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * @author LiuFeng
 * @version 2022/1/21 21:29
 * @since
 */
public class MoveZeros {

    public  static  void move(int[] nums) {
        int length = nums.length;
        int zeroCount = 0, index = 0;
        for (; index < length; index++) {
            if (nums[index] == 0) {
                zeroCount++;
            } else if (zeroCount != 0) {
                nums[index - zeroCount] = nums[index];
                nums[index] = 0;

            }
        }
    }

    public static void move2(int[] nums){
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }

        while(index < nums.length){
            nums[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,0,2,3};
        move2(nums);
        ArrayUtils.printArray(nums);
    }
}
