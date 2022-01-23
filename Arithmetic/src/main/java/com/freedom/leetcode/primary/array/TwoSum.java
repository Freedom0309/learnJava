package com.freedom.leetcode.primary.array;

import java.util.HashMap;
import java.util.Map;

import com.freedom.leetcode.utils.ArrayUtils;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description:给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author LiuFeng
 * @version 2022/1/23 17:43
 * @since
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[]{-1, -1};

        for (int i = 0; i < nums.length - 1; i++) {
            int num1 = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{0, 0};
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 13;

        int[] res = twoSum1(nums, target);
        ArrayUtils.printArray(res);
    }
}
