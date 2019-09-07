package com.freedom.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Copyright: Copyright (c) 2019 Asiainfo-Linkage
 *
 * @Description: TODO
 * @version:
 * @author: liufeng
 * @date: 2019/9/5 19:34
 * <p>
 * Modification History:
 * Date             Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/9/5 19:34  liufeng
 */
public class NumericStream {
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

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
//        intStream.forEach(System.out::println);
        Stream<Integer> boxed = intStream.boxed();
//        boxed.forEach(System.out::println);
        OptionalInt max = menu.stream().mapToInt(Dish::getCalories).max();
        max.ifPresent(System.out::println);
        System.out.println(max.orElse(1));

        int a1 = 90;

        Stream<int[]> stream = IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a1 * a1 + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a1, b, (int) Math.sqrt(a1 * a1 + b * b)});
        stream.forEach(t -> System.out.println("a=" + t[0] + ",b=" + t[1] + ",c=" + t[2]));

        //勾股定理
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );
        pythagoreanTriples.limit(5).forEach(t -> System.out.println("a=" + t[0] + ",b=" + t[1] + ",c=" + t[2]));

        Stream<double[]> optimizePythagoreanTriples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b,  Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0)
                );
        System.out.println("optimize---------------------");
        optimizePythagoreanTriples.limit(10).forEach(t-> System.out.println("a=" + t[0] + ",b=" + t[1] + ",c=" + t[2]));

    }
}
