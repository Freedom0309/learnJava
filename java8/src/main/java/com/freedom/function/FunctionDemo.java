package com.freedom.function;

import java.util.function.Function;

/**
 * @Describe: 函数型接口
 * @version:
 * @author: liuf
 * @date: 2020-05-17
 */
public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };
        Function<String, String> func = str -> str;

        System.out.println(function.apply("123"));
        System.out.println(func.apply("123"));
        System.out.println(function.compose(function));
        System.out.println(Function.identity());
    }
}
