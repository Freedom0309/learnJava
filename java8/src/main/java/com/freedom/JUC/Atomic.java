package com.freedom.JUC;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Describe:
 * @version:
 * @author: liuf
 * @date: 2020-05-19
 */
public class Atomic {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.compareAndSet(1,3);
        System.out.println(atomicInteger.get());

        AtomicStampedReference<Integer> atomicReference = new AtomicStampedReference<>(1,2);
        new AtomicReference<>();
        Integer reference = atomicReference.getReference();
        atomicReference.getStamp();

    }
}
