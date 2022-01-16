package com.freedom.leetcode.utils;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description:
 *
 * @author LiuFeng
 * @version 2022/1/16 21:25
 * @since
 */
public class ArrayUtils {

    private ArrayUtils() {

    }

    public static void printArray(Object[] objects) {
        for (Object o : objects) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] nums) {
        for (int o : nums) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
