package to.my.java.Function;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by hreeman on 1/15/16.
 */
public class StreamExamples5ParallelPerformance {
    public static long iterativeSum(long n) {
        long result = 0;

        for(long i = 0; i <= n; i++) {
            result += i;
        }

        return result;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                    .limit(n)
                    .reduce(Long::sum)
                    .get();
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .parallel()
                .reduce(Long::sum)
                .get();
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                        .reduce(Long::sum)
                        .getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(Long::sum)
                .getAsLong();
    }

    public static void main(String[] args) {
        final long n = 10_000_000;
        final long start1 = System.currentTimeMillis();
        System.out.println("iterativeSum(n):      " + iterativeSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start1) + " ms\n");

        final long start2 = System.currentTimeMillis();
        System.out.println("sequentialSum(n):     " + sequentialSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start2) + " ms\n");

        final long start3 = System.currentTimeMillis();
        System.out.println("parallelSum(n):       " + parallelSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start3) + " ms\n");

        final long start4 = System.currentTimeMillis();
        System.out.println("rangedSum(n):         " + rangedSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start4) + " ms\n");

        final long start5 = System.currentTimeMillis();
        System.out.println("parallelRangedSum(n): " + parallelRangedSum(n));
        System.out.println("                      " + (System.currentTimeMillis() - start5) + " ms\n");
    }
}
