package com.freedom.concurrent;

/**
 * Copyright: Copyright (c) 2021
 *
 * <p>
 * Description:
 *
 * @author LiuFeng
 * @version 2021/9/29 21:14
 * @since
 */
public class VolatileTest {

//    public static volatile int race = 0;
//
//    public static void increase() {
//        race++;
//    }
//
//    private static final int THREAD_COUNT = 20;
//
//    public static void main(String[] args) {
//
//        Thread[] threads = new Thread[THREAD_COUNT];
//        for (int i = 0; i < THREAD_COUNT; i++) {
//            threads[i] = new Thread(() -> {
//                for (int j = 0; j < 100; j++) {
//                    increase();
//                }
//            });
//            threads[i].start();
//        }
//
//        //等待所有累加线程都结束
//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
//        System.out.println(race);
//    }

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

//        System.out.println(Thread.activeCount());
        // 等待所有累加线程都结束
        while (Thread.activeCount() > 2)
            Thread.yield();

        System.out.println(race);
    }
}
