package com.freedom.flyweight;

/**
 * @author liuf
 * date: 2020-02-07
 */
public class FlyWeight {
    public static void main(String[] args) {
        Integer x = Integer.valueOf(123);
        Integer y = new Integer(123);
        Integer z = Integer.valueOf(123);
        Integer w = new Integer(123);

        System.out.println(x.equals(y));
        System.out.println(x == y);
        System.out.println(x == z );
        System.out.println(y == w);
    }
}
