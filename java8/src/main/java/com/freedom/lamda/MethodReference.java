package com.freedom.lamda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * create in 2019/6/23 22:07 by Allen
 */
public class MethodReference {

    public static void main(String[] args) {

        Consumer<String> consumer = s -> System.out.println(s);
        userConsumer(consumer, "How are you? Allen");

        userConsumer((s)-> System.out.println(s), "How do you do? Allen");
        userConsumer(System.out::println, "Hello, Allen");

        List<Apple> source = Arrays.asList(new Apple("red", 150),
                new Apple("green", 170),
                new Apple("green", 70),
                new Apple("yellow", 170));
        System.out.println(source);

        //lambda表达式来传入要比较的参数, 函数推导方式
        source.sort((a1, a2) -> {return  a1.getColor().compareTo(a2.getColor());});
      /*  source.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
        */
      source.sort(Comparator.comparing(Apple::getColor));
        System.out.println(source);

        source.stream().forEach(apple -> System.out.println(apple));
        System.out.println("---------------");
        source.stream().forEach(System.out::println);


        // Function
        Function<String, Integer> f = Integer::parseInt;
        Integer apply = f.apply("1234");
        System.out.println(apply);

        //Function函数中类方法和对象方法的区别
        BiFunction<String, Integer, Character> scbf = String::charAt;
        Character c = scbf.apply("Algorithm", 2);
        System.out.println(c);

        String string = new String("Arithmetic");
        Function<Integer, Character> icf = string::charAt;
        Character c2 = icf.apply(3);
        System.out.println(c2);


        ThreeFunctional<String, Integer, String, Person> threeFunctional = Person::new;
        Person person = new Person("Allen", 26, "male");
        Person per = threeFunctional.Apply("Allen", 26, "male");
        System.out.println(per);

    }

    private static <T> void userConsumer(Consumer<T> consumer, T t){
        consumer.accept(t);
    }
}
