package com.freedom.stream;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.DoubleSupplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Copyright: Copyright (c) 2019 Asiainfo-Linkage
 *
 * @Description: 读取文本文件中的内容，并计算其有多少单词
 * @version:
 * @author: liufeng
 * @date: 2019/9/6 11:55
 * <p>
 * Modification History:
 * Date             Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/9/6 11:55  liufeng
 */
public class FileStream {
    public static void main(String[] args) {
        long count = 0L;
        try (Stream<String> lines = Files.lines(Paths.get("..\\learnJava\\java8\\src\\main\\resources\\data.txt"), Charset.defaultCharset())) {
            count = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println(count);

        Stream.iterate(0, n -> n + 3)
                .limit(10)
                .forEach(System.out::println);
        System.out.println("========斐波那契数列==========");
        //斐波那契数列
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        //generate不是一次新生成的值应用函数，他接受一个Supplier<T>类型的lambda提供的新值
        System.out.println("========generate======");
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("===========IntSupplier + generate 实现斐波那契数列：========");
        DoubleSupplier lib = new DoubleSupplier() {
            private double previous = 0;
            private double current = 1;

            @Override
            public double getAsDouble() {
                double oldPrevious = this.previous;
                double nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        DoubleStream.generate(lib).limit(10).forEach(System.out::println);
    }
}
