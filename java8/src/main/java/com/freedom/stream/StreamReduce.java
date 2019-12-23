package com.freedom.stream;

import java.util.*;

import static java.util.stream.Collectors.*;

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
       /* Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6});

        stream.reduce(Integer::max).ifPresent(System.out::println);
        System.out.println("========================");
        stream = Arrays.stream(new Integer[]{1, 21, 3, 4, 5});
        stream.skip(1)//跳过从第一个元素开始的n个元素
                .reduce((a, b) -> a > b ? a : b).ifPresent(System.out::println);
        System.out.println("------------------------");
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6});
        Integer resultReduce = stream.filter(item -> item % 2 == 0).reduce(1, (a, b) -> a * b);
        System.out.println(resultReduce);
        Optional.of(resultReduce).ifPresent(System.out::println);*/

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 3, 4, 3, 4, 3, 4);
        Integer collect = integers.stream().collect(reducing(0, Integer::intValue, Integer::sum));
        System.out.println(collect);
        IntSummaryStatistics summary = integers.stream().collect(summarizingInt(Integer::intValue));
        summary.getCount();
        summary.getAverage();
        summary.getMax();
        summary.getMin();
        summary.getSum();

        System.out.println("summarizingInt:" + summary);
        Integer summar1 = integers.stream().collect(summingInt(Integer::intValue));
        System.out.println(summar1);
        Double avg = integers.stream().collect(averagingInt(Integer::intValue));
        System.out.println(avg);
        integers.stream().mapToInt(Integer::intValue).sum();

        //分组
        Map<Integer, List<Integer>> maps = integers.stream().collect(groupingBy(Integer::intValue));
        System.out.println("group:" + maps);
        //二级分组
        Map<Integer, Long> mapCounts = integers.stream().collect(groupingBy(Integer::intValue, counting()));
        System.out.println("map counts:" + mapCounts);

        Map<Integer, Integer> mapByMax = integers.stream().collect(groupingBy(Integer::intValue,
                collectingAndThen(maxBy(Comparator.comparingInt(Integer::intValue)), Optional::get)));
        System.out.println("map by max:" + mapByMax);

        List<String> strings = Arrays.asList("Jack", "Bob", "Liu", "C");
        String names = strings.stream().map(String::toString).collect(joining("--"));
        System.out.println(names);

        List<Dish> menu = Dish.getMenu();
        //分区
        Map<Boolean, Map<Dish.Type, List<Dish>>> dishPart = menu.stream().collect(
                partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType))
        );
        System.out.println("分区：" + dishPart);
        Map<Boolean, List<Dish>> mapP = menu.stream().collect(
                partitioningBy(Dish::isVegetarian)
        );
        System.out.println("分区，不使用type：" + mapP);
    }
}
