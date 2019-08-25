package com.freedom.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * create in 2019/6/25 0:01 by Allen
 */
public class SimpleStream {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
//        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        //循环合并
        List<String> listByStream = menu.stream().filter(p -> {
            System.out.println("filter:" + p.getName());
            return p.getCalories() < 400;
        })
                .map(d->{
                    System.out.println("mapping:" + d.getName());
                    return d.getName();})
                .limit(3).distinct()
                .collect(toList());
        System.out.println(listByStream);
//        menu.stream().forEach(System.out::println);
        List<Integer> nameLength = menu.stream().map(Dish::getName).map(String::length).collect(toList());
        System.out.println(nameLength);

        List<String> words = Arrays.asList("Hello World");
        /* 生成一个字符串数组，但这并不是我想要的结果 */
        List<String[]> collect = words.stream().map(d -> d.split("")).collect(toList());
        System.out.println(collect);
        String[] words1 = {"How", "do", "you", "do?"};
        Stream<String> streamOfWord = Arrays.stream(words1);
        List<String> collect1 = words.stream().map(d -> d.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(collect1);

        //获取列表中数字的平方
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squareNum = nums.stream().map(d -> d * d).collect(toList());
        System.out.println(squareNum);

        //获取数对
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> numberPair = numbers1.stream().flatMap(num1 -> numbers2.stream().map(num2 -> new int[]{num1, num2})).collect(toList());
        System.out.println(numberPair.toString());

        //查找菜单中是否包含名称为rice的菜
        menu.stream().anyMatch(d->d.getName().equals("rice"));
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d-> System.out.println(d.toString()));
    }
}
