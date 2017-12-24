package com.learn.dataStructure;

import org.junit.Test;

/**
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 12:30 2017/12/24
 * @Modified By:
 **/
public class ArrayTest {

    @Test
    public void rotateArrayTest(){
        RotateArray ra = new RotateArray();
        int [] array = {1,2,3,4,5,6};
        ra.rotateArray(array, 4);
        for (int i: array) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void TwoSumTest(){
        int [] array = {1,12,15,12,13,17,2,4,5,8,9,10,1};
        TwoSum ts = new TwoSum();
        for (int i : array) {
           ts.save(i);
        }

        ts.save(55);
        ts.print();

        System.out.println();
        System.out.println(ts.test(10));
        System.out.println(ts.test(20));
        System.out.println(ts.test(100));
    }
}
