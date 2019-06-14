package com.freedom.array;

import java.util.HashSet;
import java.util.Random;

/**
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 17:42 2017/12/21
 * @Modified By:
 **/
public class RandomNumber {

    /**
     * 随机指定范围内N个不重复的数
     * @param min 指定最小范围
     * @param max 指定最大范围
     * @param n 随机数个数
     * @return
     */
    public  int[] randomCommon(int min, int max, int n){
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        return result;
    }

    /**
     * l利用HashSet只能存放不同的值来生成
     * @param min n 指定最小范围
     * @param max 指定最大范围
     * @param n 随机数个数
     * @param set
     * 有Bug,有时会打印出4个值来
     */
    public  void randomSet(int min, int max, int n, HashSet<Integer> set){
        if (n > (max - min) + 1 || max < min) {
            return;
        }
        for (int i = 0; i < n; i++) {
            //调用Math.random()方法
            int num = (int)(Math.random() * (max - min))+ min;
            //将不同的数存入HashSet中
            set.add(num);
        }
        int setSize = set.size();

        //如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，知道达到指定大小
        if (setSize < n) {
            //递归
            randomSet(min, max, setSize, set);
        }
    }

    /**
     * 随机指定范围内N个不重复的数
     * 在初始化的无重复待选数组中随机产生一个数放入结果中，
     * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换
     * 然后从len-2里随机产生下一个随机数，如此类推
     * @param max  指定范围最大值
     * @param min  指定范围最小值
     * @param n  随机数个数
     * @return int[] 随机数结果集
     */
    public  int[] randomArray(int min,int max,int n){
        int len = max-min+1;

        if(max < min || n > len){
            return null;
        }
        //初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min+len; i++){
            source[i-min] = i;
        }

        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            //待选数组0到(len-2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            System.out.println(index+"<<<" +len +": " + rd.nextInt());
            //将随机到的数放入结果集
            result[i] = source[index];
            //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }
}
