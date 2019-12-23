package com.freedom.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * create in 2019/7/1 21:55 by Allen
 */
public class CreateStream {

    public static void main(String[] args) {
        createStreamFromCollection().forEach(System.out::println);
        createStreanForValues().forEach(System.out::println);
    }

    private static Stream<String> createStreamFromCollection(){
        List<String> strings = Arrays.asList("123", "456", "789");
        return strings.stream();
    }

    private static Stream<String> createStreanForValues(){
        return Stream.of("122","333","444");
    }
}
