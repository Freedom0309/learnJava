package com.freedom.leetcode.primary.array;

import com.freedom.leetcode.utils.ArrayUtils;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description:给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author LiuFeng
 * @version 2022/1/21 17:25
 * @since
 */
public class PlusOne {


    public static int[] plus(int[] nums){
        int length = nums.length;

        for (int index = length - 1; index >= 0 ; index--) {
            if (nums[index] != 9){
                nums[index]++;
                return nums;
            }else{
                nums[index] = 0;
            }
        }

        //数组中的数都是9的情况，会执行到此代码
        int[] temp = new int[length+1];
        temp[0] = 1;
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,9};
        int[] plus = plus(nums);

        ArrayUtils.printArray(plus);
    }
}
