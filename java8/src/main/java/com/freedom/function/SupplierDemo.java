package com.freedom.function;

import java.util.function.Supplier;

/**
 * @Describe: 供给型接口
 * @version:
 * @author: liuf
 * @date: 2020-05-17
 */
public class SupplierDemo {
    public static void main(String[] args) {
        int i = 0b0000_0000_001_10;
        System.out.println(i);
        String name = "feng";
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "null";
            }
        };

        System.out.println(supplier.get());
        Supplier<String> sup = () -> {
            return "123";
        };
        sup = () -> name;
        System.out.println(sup.get());
        System.out.println("---------------------");
        System.out.println();
        System.getProperties().forEach((k, v) -> {
            System.out.println("key is { " + k + " }, value is { " + v + " }");
        });

    }
}
