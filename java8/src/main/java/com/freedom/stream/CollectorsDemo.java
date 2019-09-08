package com.freedom.stream;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollectorsDemo {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 1300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> maxCaloryDish = menu.stream().collect(maxBy(dishComparator));
        maxCaloryDish.ifPresent(System.out::println);
        Optional<Dish> minCaloryDish = menu.stream().collect(minBy(dishComparator));
        minCaloryDish.ifPresent(System.out::println);
        IntSummaryStatistics totalCalories = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(totalCalories);
        String dishName = menu.stream().map(Dish::getName).collect(Collectors.joining("-"));
        System.out.println(dishName);

        //reducing， 菜单中菜品卡路里总和
        int totalCalories1 = menu.stream().collect(reducing(
                0, Dish::getCalories, (a,b)->a+b
        ));
        totalCalories1 = menu.stream().collect(reducing(
                0, Dish::getCalories, Integer::sum
        ));
        //卡路里最高的菜肴
        Optional<Dish> mostCaliryDish = menu.stream().collect(reducing(
                (a, b) -> a.getCalories() > b.getCalories() ? a : b
        ));
        //可以使用orElse方法给定默认值
        Integer maxCalory = menu.stream().map(Dish::getCalories)
                .reduce(Integer::max).get();
        System.out.println(maxCalory);
        List<Dish> menu1 = new LinkedList<>();
        menu1.stream().map(Dish::getCalories).reduce(Integer::sum)
                .ifPresent(System.out::println);

        //分组
        menu.stream().collect(groupingBy(Dish::getType));

        menu.stream().collect(groupingBy(
                dish -> {
                    if (dish.getCalories() <=400)
                        return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                }
        ));

    }
}
