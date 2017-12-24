package com.learn.dataStructure;

/**
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 12:23 2017/12/24
 * @Modified By:
 **/
public class RotateArray {

    /**
     * 返回将一维数组向右旋转k个位置的结果。
     * @param A
     * @param k
     * @return
     */
    public  int [] rotateArray(int[] A, int k){
        //反转整个数组
        reverse(A, 0, A.length-1);
        //反转前k个数
        reverse(A, 0, k-1);
        reverse(A, k, A.length - 1);
        return A;
    }

    /**
     * 辅助函数，反转从start到end的数
     * @param A
     * @param start
     * @param end
     */
    public static void reverse(int [] A, int start, int end){
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }
}

