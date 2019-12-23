package com.freedom.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class StreamPartition {
    public static void main(String[] args) {
        StreamPartition streamPartition = new StreamPartition();
        Map<Boolean, List<Integer>> primes = streamPartition.partitionPrimes(100);
        System.out.println(primes.get(true));
    }

    /**
     * 判断2到candidate中的数那些是质数
     *
     * @param candidate
     * @return
     */
    public boolean isPrime(int candidate) {
        int candidateRoot = (int)Math.sqrt((double) candidate);
        return IntStream.range(2, candidateRoot)
                .noneMatch(number -> candidate % 2 == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));

    }
}
