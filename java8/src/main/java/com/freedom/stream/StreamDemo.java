package com.freedom.stream;

import java.util.stream.LongStream;

/**
 * @Describe:
 * @version:
 * @author: liuf
 * @date: 2020-05-17
 */
public class StreamDemo {
    public static void main(String[] args) {
//        Stream.builder().add("q").add("222").build().forEach(System.out::println);
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).reduce(Long::sum).getAsLong();
        long end = System.currentTimeMillis();
        System.out.println("结果是：" + sum + "，耗时：" + (end - start)  + "秒");
    }

}
