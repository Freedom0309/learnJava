package com.freedom.nettyDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright: Copyright (c) 2020 TD
 *
 * <p> Description:
 *
 * @author liufeng
 * @version 2020/7/24 10:10
 * @since
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        int idx = 0;
//        System.out.println(System.nanoTime());
//
//        for (; ; ) {
//            System.out.println(++idx);
//            if (idx > 10) {
//                break;
//            }
//        }
        int processors = Runtime.getRuntime().availableProcessors();

        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5 * processors);
        /**
         *
         * int corePoolSize,
         * int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory,
         *                               RejectedExecutionHandler handler
         *
         * 1. 线程池初始化5个线程
         * 2. 最大线程数是10
         * 3.比如来4个任务，线程池可以完全执行这些任务
         * 4.如果来了7个任务，那么有5个线程可以立即执行，剩下 的2个被放到缓冲队列中 --> queue
         * 5.如果来了14个任务，其中5个可以立即执行，有5个在缓冲队列中，剩下的4个，线程池会在创建4个线程来执行剩下的4个任务
         * 6.20, 5-->pool 5-->queue 5--> maxthread(10) 5--由拒绝策略来处理
         */
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(processors,
                        processors * 3,
                        30,
                        TimeUnit.SECONDS,
                        queue);

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        executor.execute(() -> {
            System.out.println("=====================================");
            System.out.println("------" + Thread.currentThread());
        });
        lock.unlock();

        executor.execute(() -> System.out.println("123123123123"));

        Thread thread = new Thread();
        thread.start();
        System.out.println("--------------====");
        System.out.println(thread.getId());

        Thread1 thread1 = new Thread1();
        thread1.run();

        Thread2 thread2 = new Thread2();
        Object call = thread2.call();
        System.out.println(call.toString());
        System.out.println(processors);


    }

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread1 run...");
        }
    }

    static class Thread2 implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Thread2 run...";
        }
    }
}
