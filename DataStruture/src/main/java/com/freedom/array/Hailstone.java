package com.freedom.array;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 有穷性
 *
 * @author liuf
 * date: 2020-02-17
 */
public class Hailstone {
    public static void main(String[] args) {
        hailstone(7);
        hailstone(27);
    }

    public static int hailstone(int n) {
        Collection<Integer> list = new ArrayList<Integer>();
        list.add(n);
        int length = 1;
        while (n > 1) {
            if (((n % 2) != 0)) {
                n = 3 * n + 1;
            } else {
                n /= 2;
            }
            list.add(n);

            length++;
        }
        System.out.println(list.toString());
        System.out.println(" the length is " + length);
        return length;

    }
}
