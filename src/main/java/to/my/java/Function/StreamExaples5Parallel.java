package to.my.java.Function;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by hreeman on 1/14/16.
 */
public class StreamExaples5Parallel {
    public static void main(String[] args) {
        final int[] sum = { 0 };
        IntStream.range(0, 100)
                .forEach(i -> sum[0] += i);

        System.out.println("                   sum (with side-effect): " + sum[0]);

        final int[] sum2 = { 0 };
        IntStream.range(0, 100)
                .parallel()
                .forEach(i -> sum2[0] += i);

        System.out.println("          parallel sum (with side-effect): " + sum2[0]);

        System.out.println("         stream sum (without side-effect): " +
            IntStream.range(0, 100)
                    .sum()
        );

        System.out.println("parallel stream sum (without side-effect): " +
            IntStream.range(0, 100)
                    .parallel()
                    .sum()
        );

        System.out.println();
        System.out.println("stream");
        final long start = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .stream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start);

        System.out.println();
        System.out.println("parallel stream (4core 8elements)");
        final long start2 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start2);

        System.out.println();
        System.out.println("parallel stream (4core 9elements)");
        final long start3 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start3);
    }
}
