package com.freedom.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * create in 2019/6/14 14:57 by Allen
 */
public class FilterApple {
    /**
     * 策略模式
     */
    @FunctionalInterface
    public interface AppleFilter {
        public boolean filter(Apple apple);

        default boolean test() {
            return true;
        }

        ;

        static boolean test(int a) {
            return true;
        }

        ;
    }

    public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (appleFilter.filter(apple))
                result.add(apple);
        }
        return result;
    }

    /**
     * 绿色并且大于160的苹果
     */
    public static class GreenAnd160weightApple implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green")
                    && apple.getWeight() > 160);
        }
    }

    /**
     * 红色并且小于150的苹果
     */
    public static class RedAndLess150Apple implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return ("red".equals(apple.getColor())
                    && apple.getWeight() <= 150);
        }
    }


    public static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    public static void main(String[] args) throws InterruptedException {
        List<Apple> apples = Arrays.asList(new Apple("red", 150),
                new Apple("green", 170),
                new Apple("green", 70),
                new Apple("yellow", 170));
//        List<Apple> applesResult = filterGreenApples(apples);
//        System.out.println(applesResult);

        List<Apple> appleList = findApple(apples, new GreenAnd160weightApple());
        System.out.println(appleList);

        List<Apple> redApples = findApple(apples, new RedAndLess150Apple());
        System.out.println(redApples);

        //匿名内部类
        List<Apple> yellowApples = findApple(apples, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return ("yellow".equals(apple.getColor()) && apple.getWeight() <= 170);
            }
        });
        System.out.println(yellowApples);

        //lambda表达式来过滤green
        List<Apple> lambdaResult = findApple(apples, apple -> {
            return apple.getColor().equals("green");
        });
        System.out.println("lambda:" + lambdaResult);

        //线程的创建
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

        Thread.currentThread().join();
    }

}