package com.freedom.function;

import java.util.function.Consumer;

/**
 * @Describe: 消费型接口
 * @version:
 * @author: liuf
 * @date: 2020-05-17
 */
public class ConsumerDemo {
    private String str = "";
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        };
        consumer.accept("liu feng");

        Consumer<String> cons = str -> {
            System.out.println(str);
        };
        cons.accept("liu");

        int modifiers = Test.class.getModifiers();
        /**
         * default:   0           0b0000
         * public:    1           0b0001
         * private:   2           0b0010
         * protected: 4           0b0100
         * final:    16           0b0001_0000
         * abstract: 1024         0b0100_0000_0000
         */

        System.out.println(modifiers);

        System.out.println(Test01.class.getModifiers());

    }

    protected class Test01 {
        public Test01() {
            System.out.println("Test01");
        }
    }
}
