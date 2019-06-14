package com.freedom.array;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 设计一个类，包含如下两个成员函数：
 * Save(int input) 插入一个整数到整数集合中
 * Test(int target) 检验是否两个数和为输入值。如果存在这个两个数，则返回true;否则返回false.
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 12:40 2017/12/24
 * @Modified By:
 **/
public class TwoSum {
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    public void save(int input){
        int originalCount = 0;
        if (hm.containsKey(input)) {
            //判断是否已经存在，如果存在，则读取这个数
            originalCount = hm.get(input);
        }
//     将输入的数字存在HashMap中
        hm.put(input, originalCount + 1);
    }

    public boolean test(int target){
        //使用迭代器来进行遍历
        Iterator<Integer> it = hm.keySet().iterator();
        while (it.hasNext()) {
            int val = it.next();
            if (hm.containsKey(target - val)) {
                //需要判断一下是否有这中特殊情况
                boolean isDouble = target == val * 2;
                if (!(isDouble && hm.get(val) == 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void print(){
        Iterator it = hm.keySet().iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
}
