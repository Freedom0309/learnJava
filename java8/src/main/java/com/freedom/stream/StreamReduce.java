package com.freedom.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Copyright: Copyright (c) 2019 Asiainfo-Linkage
 *
 * @Description: TODO reduce
 * @version:
 * @author: liufeng
 * @date: 2019/9/4 20:53
 * <p>
 * Modification History:
 * Date             Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/9/4 20:53  liufeng
 */
public class StreamReduce {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6});

        stream.reduce(Integer::max).ifPresent(System.out::println);
        System.out.println("========================");
        stream = Arrays.stream(new Integer[]{1, 21, 3, 4, 5});
        stream.skip(1)//跳过从第一个元素开始的n个元素
                .reduce((a, b) -> a > b ? a : b).ifPresent(System.out::println);
        System.out.println("------------------------");
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6});
        Integer resultReduce = stream.filter(item -> item % 2 == 0).reduce(1, (a, b) -> a * b);
        System.out.println(resultReduce);
        Optional.of(resultReduce).ifPresent(System.out::println);
    }
}
