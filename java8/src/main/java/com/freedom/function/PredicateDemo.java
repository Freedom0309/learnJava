package com.freedom.function;

import java.util.function.Predicate;

/**
 * @Describe: 断定型接口
 * @version:
 * @author: liuf
 * @date: 2020-05-17
 */
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String o) {
                return o.isEmpty();
            }
        };

        Predicate<String> isEmptyStr = str -> {
            return str.isEmpty();
        };

        System.out.println(isEmptyStr.test(""));
        System.out.println(predicate.test("1"));
    }
}
