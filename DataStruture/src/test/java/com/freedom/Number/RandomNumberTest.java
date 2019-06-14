package com.freedom.Number;

import com.freedom.array.RandomNumber;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 17:56 2017/12/21
 * @Modified By:
 **/
public class RandomNumberTest {

    @Test
    public void RandomCommonTest(){
        RandomNumber randomNumber = new RandomNumber();
        int[] result = randomNumber.randomCommon(0, 10, 3);
        for (int temp : result) {
            System.out.println("foreach" + temp);
        }
    }

    @Test
    public void RandomSetTest(){
        RandomNumber randomNumber = new RandomNumber();
        HashSet<Integer> set = new HashSet<Integer>();
        randomNumber.randomSet(0, 10, 3, set);
        Iterator iterator = set.iterator();
        for (int temp : set) {
            System.out.println("foreach" + temp);
        }
        while (iterator.hasNext()) {
            System.out.println(">>"+iterator.next());
        }
    }

    @Test
    public void RandomArrayTest(){
        RandomNumber rn = new RandomNumber();
        int [] result;
        result = rn.randomArray(0,10, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
