package com.freedom.lamda;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExpression {

    public static void main(String[] args) {
        Comparator byColor = new Comparator<Apple>() {
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> list = Collections.emptyList();
        list.sort(byColor);

        Comparator<Apple> byColor2 = (o1, o2) -> o1.getColor().compareTo(o2.getColor());
        //加花括号需要return返回
        Comparator<Apple> byColor3 = (Apple o1, Apple o2) -> {
            return o1.getColor().compareTo(o2.getColor());
        };

        String s1 = "asdasd";

        Function<String, Integer> fLambda = s -> s1.length();

        System.out.println("function:" + fLambda);

        Predicate<Apple> predicate = apple -> apple.getColor().equals("green");

        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        for (File hiddenFile : hiddenFiles) {
            System.out.println(hiddenFile.getName());
        }

        Supplier<Apple> apple = Apple::new;
        Apple apple1 = apple.get();
        Apple apple2 = apple.get();
        apple1.setColor("red");
        System.out.println(apple + "\n" + apple1.hashCode() + "\n" + apple2.hashCode());
    }
}
