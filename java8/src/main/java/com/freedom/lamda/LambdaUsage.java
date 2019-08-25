package com.freedom.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * create in 2019/6/19 23:02 by Allen
 */
public class LambdaUsage {

    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
        List<Apple> apples = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple))
                apples.add(apple);
        }
        return apples;
    }


    public static void main(String[] args) {
        List<Apple> source = Arrays.asList(new Apple("red", 150),
                new Apple("green", 170),
                new Apple("green", 70),
                new Apple("yellow", 170));
        List<Apple> redApples = filter(source, apple -> apple.getColor().equals("red"));
        System.out.println(redApples);
    }
}
